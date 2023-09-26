package models;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import oop.EmployeeOOP;
import org.bson.Document;


public class Employee {
    private final MongoClient mongoClient;
    private final String databaseName;
    private final String collectionName;
    public Employee() {
        mongoClient = MongoClients.create("mongodb+srv://o84267877:uRolj9Hf5boFwCBS@cluster0.huhiakh.mongodb.net/?retryWrites=true&w=majority");
        databaseName = "PTIT";
        collectionName = "Employee";
    }
    // Create a new user
    public void createUser(EmployeeOOP user) {
        try (MongoClient client = mongoClient) {
            MongoDatabase database = client.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            Document document = new Document("employee_id", user.getId())
                    .append("name", user.getName())
                    .append("title", user.getTitle())
                    .append("modifidate", user.getModifidate());

            collection.insertOne(document);
        }
    }

    // Read a user by ID
    public EmployeeOOP getUserById(int id) {
        try (MongoClient client = mongoClient) {
            MongoDatabase database = client.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            Document query = new Document("employee_id", id);
            Document result = collection.find(query).first();

            if (result != null) {
                EmployeeOOP user = new EmployeeOOP();
                user.setId(result.getInteger("employee_id"));
                user.setName(result.getString("name"));
                user.setTitle(result.getString("title"));
                user.setModifidate(result.getString("modifidate"));
                return user;
            }

            return null;
        }
    }

    // Update a user by ID
    public void updateUserById(int id, EmployeeOOP updatedUser) {
        try (MongoClient client = mongoClient) {
            MongoDatabase database = client.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            Document query = new Document("employee_id", id);
            Document update = new Document("$set", new Document("name", updatedUser.getName())
                    .append("title", updatedUser.getTitle())
                    .append("modifidate", updatedUser.getModifidate()));

            collection.updateOne(query, update);
        }
    }

    // Delete a user by ID
    public void deleteUserById(int id) {
        try (MongoClient client = mongoClient) {
            MongoDatabase database = client.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            Document query = new Document("employee_id", id);
            collection.deleteOne(query);
        }
        mongoClient.close();
    }

}