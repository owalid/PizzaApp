package com.example.oelayad.pizzeria;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Othmane on 20/03/2018.
 */

public class Commande extends AsyncTask<String, String, Void> {

    private int port = 6666;

//        @Override
//        protected void onPreExecute() {
//
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//        }

    protected Void doInBackground(String... values) {
        Socket socket = null;
        try {
            socket = new Socket("chadok.info", port);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer.println(values[0]);
            String returnMessage = reader.readLine();
            if (returnMessage != null)
                System.out.println(returnMessage);
                publishProgress(returnMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
