package Networking;

import db.CarsController;

import java.io.*;
import java.net.*;

public class Server {

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            System.out.println("VehicFinder Server running on port 9000");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }

        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {

                out.println("Please enter model year:");
                int year = Integer.parseInt(in.readLine());

                out.println("Please enter your maximum price:");
                int price = Integer.parseInt(in.readLine());

                out.println("Please enter number of seats:");
                int seats = Integer.parseInt(in.readLine());

                CarsController controller = new CarsController();
                for (String car : controller.DesiredCars(year, price, seats)) {
                    out.println(car);
                }

                out.println("END");

            } catch (Exception e) {
                System.out.println("Client error: " + e.getMessage());
            }
        }
    }
}

