package org.example;

import Networking.Server;
import db.CarsController;
import IO.CSVReader;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        CarsController car = new CarsController();
        CSVReader.populateDatabaseFromCsv("C:\\Users\\517ta\\Desktop\\305\\Project\\VehicFinder2\\CleanedCarData.csv");

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To VehicFinder where your choices become easier!");
        System.out.println("Do you want to run the server or local?");
        System.out.println("Write 1 for server , 2 for local");
        int choice = sc.nextInt();
        if (choice == 1) {
            Server s = new Server();
            s.start();
        } else if (choice == 2) {
            LocalSearch(car);
        } else {
            System.out.println("Invalid Choice!");
        }


    }

    public static void LocalSearch(CarsController car) throws SQLException {

        int year = 0;
        int price = 0;
        int seatNum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter model year: ");
        year = sc.nextInt();
        System.out.println("\nPlease enter your maximum price: ");
        price = sc.nextInt();
        System.out.println("\nPlease enter number of seat: ");
        seatNum = sc.nextInt();
        CarsController controller = new CarsController();
        for (String Car : controller.DesiredCars(year, price, seatNum)) {
            System.out.println(Car);
        }
    }
}






