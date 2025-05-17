package IO;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {
    @Test
    public void testPopulateDatabaseFromCsv() throws IOException, SQLException {
        Path tempFile = Files.createTempFile("test-cars", ".csv");
        Files.write(tempFile, (
                "Name,Model,Seats,Price,Issues\n" +
                        "Toyota,2020,5,60000,None\n" +
                        "Honda,2019,4,50000,AC problem\n"
        ).getBytes());

        CSVReader.populateDatabaseFromCsv(tempFile.toString());

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicfinder", "root", "12345");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM cars");

        assertTrue(rs.next());
        assertTrue(rs.getInt("total") >= 2);

        conn.close();
    }
}