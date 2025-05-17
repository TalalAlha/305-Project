package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {
    @Test
    public void testGetConnection() {
        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            Connection conn = dbConn.getConnection();

            assertNotNull(conn);
            assertTrue(conn.isValid(2));
        } catch (SQLException e) {
            fail("Connection should not throw exception, but got: " + e.getMessage());
        }
    }
}