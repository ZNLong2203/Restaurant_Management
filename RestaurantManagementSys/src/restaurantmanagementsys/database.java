package restaurantmanagementsys;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {

    public static Connection connectDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // CONNECT YOUR DATABASE
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "123456");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
