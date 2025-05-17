package Networking;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {
    @Test
    public void testServerRespondsToClient() throws Exception {
        Thread serverThread = new Thread(() -> new Server().start());
        serverThread.start();

        Thread.sleep(500);

        try (
                Socket socket = new Socket("localhost", 9000);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String response = in.readLine();
            assertEquals("Please enter model year:", response);
        }
    }
}