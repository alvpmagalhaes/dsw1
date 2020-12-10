package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                
                String user = "postgres";
                String password = "teste";
                
                Class.forName("org.postgresql.Driver");

                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}