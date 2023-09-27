package org.example;
//o84267877@gmail.com
//qwert1234#

import com.mongodb.client.*;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertEmployee {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://o84267877:uRolj9Hf5boFwCBS@cluster0.huhiakh.mongodb.net/?retryWrites=true&w=majority";

        // Create a new client and connect to the server.server
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Get the database
            MongoDatabase database = mongoClient.getDatabase("PTIT");
            // Create a collection (table)
            MongoCollection<Document> collection2 = database.getCollection("Employee");
            // Create a CSV reader
            BufferedReader csvReader = new BufferedReader(new FileReader("src/main/java/org/example/Employee.csv"));

            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap n: ");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Find");
            long n = sc.nextLong();
            if (n == 1) {
                // Create a list to store the records
                List<Document> documents = new ArrayList<>();
                // Read each line of the CSV file and parse it into a Document object
                String line;
                while ((line = csvReader.readLine()) != null) {
                    String[] fields = line.split(",");
                    Document document = new Document();

                    // Parse the id field
                    int id = Integer.parseInt(fields[0]);
                    document.put("id", id);

                    // Parse the name field
                    String name = fields[1];
                    document.put("name", name);

                    // Parse the price title
                    String title = fields[2];
                    document.put("title", title);

                    // Parse the modified field
                    String modifidate = fields[3];
                    document.put("modifidate", modifidate);

                    documents.add(document);
                }
                // Insert the documents into the collection
                collection2.insertMany(documents);
            } else if (n == 2) {
                // Create a query filter
                Document queryFilter = new Document();
                queryFilter.put("name", "Long");
                // Delete the document
                collection2.deleteOne(queryFilter);
            } else if (n == 3) {
                // Create a query filter
                Document queryFilter = new Document("name", "Tuan");
                // Find the documents that match the query filter
                MongoCursor<Document> cursor = collection2.find(queryFilter).iterator();
                // Iterate over the documents and print them out
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    System.out.println(document);
                }
                // Close the cursor
                cursor.close();
            }
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
