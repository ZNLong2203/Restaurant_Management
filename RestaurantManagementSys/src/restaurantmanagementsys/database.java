package restaurantmanagementsys;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {

    public static Connection connectDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // CONNECT YOUR DATABASE
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/restaurant?autoReconnect=true&useSSL=false&characterEncoding=utf8&useSSL=false&useUnicode=true", "root", "root123");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
