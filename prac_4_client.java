// File: MyClient.java

import java.io.*;
import java.net.*;

public class MyClient {

    public static void main(String[] args) {

        try {

            // Connect to server
            Socket s = new Socket("localhost", 6666);

            // Send data to server
            DataOutputStream dout =
                    new DataOutputStream(s.getOutputStream());

            dout.writeUTF("Hello Server");

            dout.flush();

            System.out.println("Message sent to server");

            // Close connections
            dout.close();
            s.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}