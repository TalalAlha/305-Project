package db;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class CarsControllerTest {
    private static Connection connection;
    private CarsController controller;

    @BeforeAll
    public static void setupDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE TABLE cars (Car VARCHAR(255), Model INT, Price INT, Seats INT, Issues VARCHAR(255))");
    }

    @BeforeEach
    public void setupController() throws SQLException {
        DatabaseConnection.setMockConnection(connection);
        controller = new CarsController();
    }

    @Test
    public void testInsertCar() throws SQLException {
        controller.InsertCar("Toyota", 2022, 70000, 5, "None");

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM cars WHERE Car = 'Toyota'");
        assertTrue(rs.next());
        assertEquals(2022, rs.getInt("Model"));
        assertEquals(70000, rs.getInt("Price"));
        assertEquals(5, rs.getInt("Seats"));
        assertEquals("None", rs.getString("Issues"));
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        connection.close();
    }
}