package com.example.oelayad.pizzeria;

import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.Socket;


public class PizzeriaMainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnnapolitaine;
    private Button btnroyale;
    private Button btnqfromage;
    private Button btnmontagnarde;
    private Button btnraclette;
    private Button btnhawai;
    private Button btnpannaCotta;
    private Button btntiramisu;


    //on crée des click static pour que leur valeurs ne se réinitialise pas au passage ecran vertical/horizontal
    static int clickhawai;
    static int clickmontagnarde;
    static int clicknapolitaine;
    static int clickpannacotta;
    static int clickqfrommage;
    static int clickraclette;
    static int clickroyale;
    static int clicktiramisu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

        btnnapolitaine = (Button) findViewById(R.id.btnnapolitaine);
        btnnapolitaine.setOnClickListener(this);

        btnroyale = (Button) findViewById(R.id.btnroyale);
        btnroyale.setOnClickListener(this);

        btnqfromage = (Button) findViewById(R.id.btnqfromage);
        btnqfromage.setOnClickListener(this);

        btnmontagnarde = (Button) findViewById(R.id.btnmontagnarde);
        btnmontagnarde.setOnClickListener(this);

        btnraclette = (Button) findViewById(R.id.btnraclette);
        btnraclette.setOnClickListener(this);

        btnhawai = (Button) findViewById(R.id.btnhawai);
        btnhawai.setOnClickListener(this);

        btnpannaCotta = (Button) findViewById(R.id.btnpannaCotta);
        btnpannaCotta.setOnClickListener(this);

        btntiramisu = (Button) findViewById(R.id.btntiramisu);
        btntiramisu.setOnClickListener(this);
    }

    public void onClick(View v){
        String nomCommande;
        switch (v.getId()){
            case R.id.btnhawai:
                btnhawai.setText("Hawaienne");
                nomCommande = (String) btnhawai.getText();

                break;
//            fin de hawaienne

            case  R.id.btnmontagnarde:
                btnmontagnarde.setText("Montagnarde");

                nomCommande = (String) btnmontagnarde.getText();

                break;
//            fin de montagnarde

             case R.id.btnnapolitaine:
                btnhawai.setText("Napolitaine");
                nomCommande = (String) btnnapolitaine.getText();

                break;
//            fin de napolitaine

            case  R.id.btnpannaCotta:
                btnmontagnarde.setText("Pannacotta");

                nomCommande = (String) btnpannaCotta.getText();

                break;
//            fin de panacotta

             case R.id.btnqfromage:
                btnhawai.setText("Fromagere");
                nomCommande = (String) btnqfromage.getText();

                break;
//            fin de 4 frommage

            case  R.id.btnraclette:
                btnmontagnarde.setText("Raclette");

                nomCommande = (String) btnraclette.getText();

                break;
//            fin de raclette

             case R.id.btnroyale:
                btnhawai.setText("royale");
                nomCommande = (String) btnroyale.getText();

                break;
//            fin de royale

            case  R.id.btntiramisu:
                btnmontagnarde.setText("Tiramisu");

                nomCommande = (String) btntiramisu.getText();

                break;
//            fin de tirramissu


        }
//        end of switch

    }
//        end of function onClick


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putInt(getResources().getString(R.string.key_hawaienne),clickhawai );
        outState.putInt(getResources().getString(R.string.key_montagnarde),clickmontagnarde );
        outState.putInt(getResources().getString(R.string.key_napolitaine),clicknapolitaine );
        outState.putInt(getResources().getString(R.string.key_pannaCotta),clickpannacotta );
        outState.putInt(getResources().getString(R.string.key_qfrommage),clickqfrommage );
        outState.putInt(getResources().getString(R.string.key_raclette),clickraclette );
        outState.putInt(getResources().getString(R.string.key_royale),clickroyale );
        outState.putInt(getResources().getString(R.string.key_tiramisu),clicktiramisu);

    }


    private class Commande extends AsyncTask<Void, Void, Void>{

        private final int wait = 9000;
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
            try{
                socket = new Socket("chadok.info", port);
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                writer.println(values[0]);
                String returnMessage = reader.readLine();
            }

            catch(IOException e){
                    e.printStackTrace();
            }
            finally {
                if(socket != null){
                    try{
                        socket.close();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

