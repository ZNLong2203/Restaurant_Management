package org.example;
//o84267877@gmail.com
//qwert1234#

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsertMenu {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://o84267877:uRolj9Hf5boFwCBS@cluster0.huhiakh.mongodb.net/?retryWrites=true&w=majority";

        // Create a new client and connect to the server.server
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Get the database
            MongoDatabase database = mongoClient.getDatabase("PTIT");
            // Create a collection (table)
            MongoCollection<Document> collection1 = database.getCollection("Menu");
            // Create a CSV reader
            BufferedReader csvReader = new BufferedReader(new FileReader("src/main/java/org/example/Menu.csv"));

            // Create a list to store the records
            List<Document> documents = new ArrayList<>();
            // Read each line of the CSV file and parse it into a Document object
            String line;
            while((line = csvReader.readLine()) != null) {
                String[] fields = line.split(",");
                Document document = new Document();

                // Parse the id field
                int id = Integer.parseInt(fields[0]);
                document.put("id", id);

                // Parse the name field
                String name = fields[1];
                document.put("name", name);

                // Parse the price field
                float price = Float.parseFloat(fields[2]);
                price = Math.round(price * 100) / 100f;
                document.put("price", price);

                // Parse the modified field
                String modifidate = fields[3];
                document.put("modifidate", modifidate);

                documents.add(document);
            }
            // Insert the documents into the collection
            collection1.insertMany(documents);
            // Close the CSV reader
            csvReader.close();
            // Close the MongoDB connection
            mongoClient.close();
            System.out.println("Data inserted successfully");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
