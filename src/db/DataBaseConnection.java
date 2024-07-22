package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static Connection connection = null;

    private final static String url = "jdbc:mysql://localhost:3306/vehicle_store_bd";
    private final static String user = "root";
    private final static String password = "1234";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                throw new DataBaseException("Error while establishing database connection: " + ex.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new DataBaseException("Error occurred while closing the database connection: " + ex.getMessage());
            }
        }
    }
}
