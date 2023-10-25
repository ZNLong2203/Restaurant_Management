package restaurantmanagementsys;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {

    public static Connection connectDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // CONNECT YOUR DATABASE
            Connection connect = DriverManager.getConnection("jdbc:mysql://restaurantdb.chxccmwtsu06.ap-southeast-2.rds.amazonaws.com/restaurant?autoReconnect=true&useSSL=false", "admin", "admin123");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
