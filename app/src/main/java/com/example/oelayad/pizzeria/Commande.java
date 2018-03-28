package com.example.oelayad.pizzeria;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Othmane on 20/03/2018.
 */

public class Commande extends AsyncTask<String, String, Void> {

    private int port = 9874;


    @Override
    //code exécuter par la tâche
    protected Void doInBackground(String... strings) {
        Socket socket = null;

        try{
            System.out.println("fesse" + strings[0]);
            socket = new Socket("chadok.info", port);  //création de socket faisant la connexion client/serveur
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.println(strings[0]);
            //writer.append(strings[0]);    //envoie du message au serveur mais sans retour à la ligne
            String retour1 = reader.readLine();  //lecture des message envoyer dans le socket par le serveur
            if (retour1 != null) {      //bien verifier à ce que reader ne soit pas vide
                System.out.println("Message du serveur : " + retour1);
                //onProgressUpdate(retour1);    //lance l'affichage mais redemarre l'application
                publishProgress(retour1);
            }

            String s= "";
            //readLine a un timeout integré, ce qui fait que s'il ne reçoit
            // aucune ligne de caractère la variable ne contiendra rien, c'est pour ça qu'avec while()
            //on oblige à attendre à ce que "s" ait un contenue
            while(s.equals("")){
                s = reader.readLine();
            }
            publishProgress(s);

        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(socket != null) {
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