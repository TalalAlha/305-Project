package Networking;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9000)) {

            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String line;
            while ((line = serverReader.readLine()) != null) {
                if (line.equals("END")) break;

                System.out.println(line);

                if (line.endsWith(":")) {
                    String userInput = scanner.nextLine();
                    serverWriter.println(userInput);
                }
            }

        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
        }
    }
}
