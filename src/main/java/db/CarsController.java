package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class CarsController {
    private final Connection connection;

    private static final ReentrantLock lock = new ReentrantLock();

    public CarsController() throws SQLException {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void InsertCar(String Name, int Model, int Price, int Seats, String Issues) throws SQLException {
        lock.lock();
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO cars (Car, Model, Price, Seats, Issues) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, Name);
            stmt.setInt(2, Model);
            stmt.setInt(3, Price);
            stmt.setInt(4, Seats);
            stmt.setString(5, Issues);

            int row = stmt.executeUpdate();
            if (row != 1) {
                throw new SQLException("Failed to insert these data: " + Name + " " + Model + " " + Price + " " + Seats + " " + Issues);
            }
            System.out.printf("Data Inserted: Car: " + Name + ", Model: " + Model + ", Price: " + Price + ", Seats: " + Seats + ", Issues: " + Issues);
        } catch (SQLException e) {
            System.err.println("Failed to insert Car data: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public List<String> DesiredCars(int model, int price, int seats) {
        lock.lock();
        List<String> Cars = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cars WHERE model = ? AND price <= ? AND seats = ?")) {
            stmt.setInt(1, model);
            stmt.setInt(2, price);
            stmt.setInt(3, seats);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String carName = rs.getString("Car");
                    int carModel = rs.getInt("Model");
                    int carPrice = rs.getInt("Price");
                    int carSeats = rs.getInt("Seats");
                    String carIssues = rs.getString("Issues");

                    String carss = ("Car: " + carName + ", Model: " + carModel + ", Price: " + carPrice + ", Seats: " + carSeats + ", Issues: " + carIssues);

                    Cars.add(carss);
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve car data: " + e.getMessage());
        } finally {
            lock.unlock();
            return Cars;
        }
    }
}

