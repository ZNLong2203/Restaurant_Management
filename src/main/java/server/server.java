package server;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class server {
    public static MongoCollection<Document> connect(String dbName, String collectionName) {
        String connectionString = "mongodb+srv://o84267877:uRolj9Hf5boFwCBS@cluster0.huhiakh.mongodb.net/?retryWrites=true&w=majority";

        // Create a new client and connect to the server.server
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Get the database
            MongoDatabase database = mongoClient.getDatabase(dbName);
            // Create a collection (table)
            return database.getCollection(collectionName);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}