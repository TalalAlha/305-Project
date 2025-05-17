package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Values from .env hardcoded (You should read the .env file in a real application)
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DB = "vehicfinder";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    private static DatabaseConnection instance;
    private Connection connection;
    private static Connection mockConnection = null;


    DatabaseConnection() throws SQLException {
        try {
            String url = String.format("jdbc:mysql://%s:%s/%s", HOST, PORT, DB);
            this.connection = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Connected to database: " + url);
        } catch (Exception ex) {
            System.out.println("Database Connection Creation Failed: " + ex.getMessage());
            throw new SQLException(ex);
        }
    }

    public Connection getConnection() {
        if (mockConnection != null) return mockConnection;

        return connection;
    }

    public static void setMockConnection(Connection conn) {
        mockConnection = conn;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

