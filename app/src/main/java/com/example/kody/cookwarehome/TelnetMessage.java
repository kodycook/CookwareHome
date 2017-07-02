package com.example.kody.cookwarehome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Kody on 2/07/2017.
 */

public class TelnetMessage {
    BufferedReader reader;
    PrintStream output;
    Socket socket;
    int PORT;
    String ip;


    public TelnetMessage() {
        System.out.println("Enter IP adress.");
        ip = "10.1.1.27";
        PORT = 23;

        System.out.println("Connecting...");
        socket = connection(PORT, ip);

        System.out.println("Setting up InputStream");
        reader = reader(socket);

        System.out.println("Setting up OutputStream");
        output = output(socket);
    }

    public void postNewComment(String outMsg) {
        output.print(outMsg);
    }


    public Socket connection(int port, String ip) {
        try {
            return new Socket(InetAddress.getByName(ip), port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Unknown host...");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to connect...");
            return null;
        }
    }

    public BufferedReader reader(Socket socket) {

        try {
            return new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.err.println("Couldn't get inputStream...");
            e.printStackTrace();
            return null;
        }
    }
    public PrintStream output(Socket socket) {
        try {
            return new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Couldn't get outputStream");
            return null;
        }
    }
}
