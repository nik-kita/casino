package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqLiteManager {
    private final String driverName = "org.sqlite.JDBC";
    private final String connectionString = "jdbc:sqlite:fb_info.db";
    private Connection connection;

    public SqLiteManager() {
        try {
            Class.forName(driverName);
            System.out.println("Class is finding successfuly!");
        } catch (ClassNotFoundException e) {
            System.err.println("Can't get class. No driver found");
            e.printStackTrace();
            System.exit(666);
        }
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(connectionString);
            System.out.println("Get connection!");
        } catch (SQLException e) {
            System.err.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
            System.exit(666);
        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Close connection!");
        } catch (SQLException e) {
            System.err.println("Can't close connection");
            e.printStackTrace();
            System.exit(666);
        }
    }
}
