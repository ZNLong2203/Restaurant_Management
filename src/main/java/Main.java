import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import server.server;
public class Main {
    public static void main(String[] args) {
        MongoCollection<Document> connection = server.connect("PTIT", "Employee");
        System.out.println(connection);
        Document queryFilter = new Document();
        // Find the documents that match the query filter
        assert connection != null;
        MongoCursor<Document> cursor = connection.find(queryFilter).iterator();
        // Iterate over the documents and print them out
        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println(document);
        }
//         Close the cursor
        cursor.close();
    }
}
