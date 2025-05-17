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

            assertNotNull(conn, "Connection object should not be null");

            if (conn.isClosed()) {
                fail("Connection is closed — maybe it was closed by another test?");
            }

            System.out.println("Connection isClosed? " + conn.isClosed());
            assertFalse(conn.isClosed(), "Connection should be open");

        } catch (SQLException e) {
            fail("Connection failed with exception: " + e.getMessage());
        }
}}