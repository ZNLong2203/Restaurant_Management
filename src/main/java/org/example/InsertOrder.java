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

public class InsertOrder {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://o84267877:uRolj9Hf5boFwCBS@cluster0.huhiakh.mongodb.net/?retryWrites=true&w=majority";

        // Create a new client and connect to the server.server
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Get the database
            MongoDatabase database = mongoClient.getDatabase("PTIT");
            // Create a collection (table)
            MongoCollection<Document> collection4 = database.getCollection("Order");
            // Create a CSV reader
            BufferedReader csvReader = new BufferedReader(new FileReader("src/main/java/org/example/Order.csv"));
            // Read the header

            List<Document> documents = new ArrayList<>();
            // Read each line of the CSV file and parse it into a Document object
            String line;
            while((line = csvReader.readLine()) != null) {
                String[] fields = line.split(",");
                Document document = new Document();

                // Parse the order_id field
                int order_id = Integer.parseInt(fields[0]);
                document.put("order_id", order_id);

                // Parse the item_id field
                String item_id = fields[1];
                document.put("item_id", item_id);

                // Parse the employee_id field
                String employee_id = fields[2];
                document.put("employee_id", employee_id);

                // Parse the quantity field
                int quantity = Integer.parseInt(fields[3]);
                document.put("quantity", quantity);

                // Parse the total_price field
                float total_price = Float.parseFloat(fields[4]);
                total_price = Math.round(total_price * 100) / 100f;
                document.put("total_price", total_price);

                // Parse the date field
                String date = fields[3];
                document.put("date", date);
                documents.add(document);
            }
            // Insert the documents into the collection
            collection4.insertMany(documents);
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
