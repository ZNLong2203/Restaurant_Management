package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class CreateTable {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://o84267877:uRolj9Hf5boFwCBS@cluster0.huhiakh.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("PTIT");
        database.createCollection("Menu");
        database.createCollection("Employee");
        database.createCollection("Customer");
        database.createCollection("Order");
        mongoClient.close();
    }
}
