package IO;

import db.CarsController;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class CSVReader {

    public static void populateDatabaseFromCsv(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] fields = line.split(",");
                if (fields.length < 5) {
                    System.err.println("Skipping invalid line: " + line);
                    continue;
                }

                String name = fields[0].trim();
                int model = Integer.parseInt(fields[1].trim());
                int seats = Integer.parseInt(fields[2].trim());
                int price = Integer.parseInt(fields[3].trim());
                String issues = fields[4].trim();

                CarsController db = new CarsController();
                db.InsertCar(name, model, seats, price, issues);
            }

            System.out.println("CSV data has been successfully imported into the database.");
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing numeric values: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}