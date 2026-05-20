// File: MyServer.java

import java.io.*;
import java.net.*;

public class MyServer {

    public static void main(String[] args) {

        try {

            // Create server socket on port 6666
            ServerSocket ss = new ServerSocket(6666);

            System.out.println("Server started...");
            System.out.println("Waiting for client...");

            // Wait for client connection
            Socket s = ss.accept();

            System.out.println("Client connected");

            // Receive data from client
            DataInputStream dis =
                    new DataInputStream(s.getInputStream());

            String str = dis.readUTF();

            System.out.println("Message from client: " + str);

            // Close connections
            dis.close();
            s.close();
            ss.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}