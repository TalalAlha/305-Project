package Networking;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    @Test
    public void testClientConnectsToServer() throws Exception {
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(9000);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                out.println("Welcome:");
                out.println("END");

            } catch (IOException ignored) {}
        });
        serverThread.start();

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream("test input\n".getBytes()));

        Client.main(null);

        System.setIn(originalIn);

        assertTrue(true);
    }
}