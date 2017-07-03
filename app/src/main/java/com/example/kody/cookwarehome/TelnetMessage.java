package com.example.kody.cookwarehome;

import android.os.AsyncTask;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by Kody on 2/07/2017.
 */

public class TelnetMessage extends  AsyncTask<URL, Void, String> {
    String message;

    public TelnetMessage() {

    }

        @Override
    protected String doInBackground(URL... params) {
        System.out.println("Enter IP adress.");
        String ip = "10.1.1.27";
        int PORT = 23;
        Socket socket;

        try {
            socket = new Socket(InetAddress.getByName(ip), PORT);
            PrintStream output = new PrintStream(socket.getOutputStream());
            output.print(message);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    void postNewComment(String mMessage){
        message = mMessage;
        this.execute();
    }

}
