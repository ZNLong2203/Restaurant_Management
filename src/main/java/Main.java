import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import model.Employee;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Main {

    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://o84267877:uRolj9Hf5boFwCBS@cluster0.huhiakh.mongodb.net/?retryWrites=true&w=majority");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("PTIT");
            MongoCollection<Employee> employees = db.getCollection("Employee", Employee.class);

            // create a new employee
            Employee newEmployee = new Employee().setEmployeeId(3)
                    .setName("Toan")
                    .setTitle("user")
                    .setModifidate("26/09/2023");
            employees.insertOne(newEmployee);
            System.out.println("Grade inserted.");
            System.out.println(newEmployee);

            // count the employees
            System.out.println("The collection contains " + employees.countDocuments() + " documents.");

            // find this employee.

            // findFirst() returns the first document in the collection.
            Employee employee = employees.find(eq("employee_id", 2)).first();
            System.out.println("Employee found:\t" + employee);

            Employee employee3 = employees.find(eq("employee_id", 3)).first();
            System.out.println("Employee found:\t" + employee3);

            // find all employees satisfying this filter
            Bson queryFilter = new Document("employee_id", 1);
            List<Employee> employeesFound = employees.find(queryFilter).into(new ArrayList<>());
            employeesFound.forEach(System.out::println);

            // update this employee:
            newEmployee.setTitle("user");
            assert employee != null;

            employees.replaceOne(eq("employee_id", newEmployee.getEmployeeId()), newEmployee);
            System.out.println("Employee replaced:\t" + newEmployee);

            // or

            Document filterByGradeId = new Document("_id", employee.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Employee updatedGrade = employees.findOneAndReplace(filterByGradeId, newEmployee, returnDocAfterReplace);
            System.out.println("Employee replaced:\t" + updatedGrade);

//            // delete this grade
            System.out.println("Grade deleted:\t" + employees.deleteOne(filterByGradeId));
            System.out.println("The collection contains " + employees.countDocuments() + " documents.");
        }
    }
}