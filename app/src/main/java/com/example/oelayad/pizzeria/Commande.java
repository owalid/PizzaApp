package com.example.oelayad.pizzeria;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Othmane on 20/03/2018.
 */


//========================================================
//=====================Commande===========================
//========================================================
public class Commande extends AsyncTask<String, String, Void> {
    private int port = 9874;

    @Override
    protected Void doInBackground(String... strings){
        Socket socket = null;

        try{
            // connexion client/serveur
            socket = new Socket("chadok.info", port);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.println(strings[0]); //envois du message au serveur
            String returnServer = reader.readLine();
            if (returnServer !=null){
                publishProgress(returnServer);
            }
            String str="";
            while(str.equals("")){
                str=reader.readLine(); //recuperer le message du serveur
            }
            publishProgress(str); //lancer l'instruction d'affciher

        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(socket!= null){
                try{
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

//    pour pouvoir afficher les messages retour du serveur
    @Override
    protected void onProgressUpdate(String... returnMessage) {
        PizzeriaMainActivity.textHead.setText(returnMessage[0]);
    }


}