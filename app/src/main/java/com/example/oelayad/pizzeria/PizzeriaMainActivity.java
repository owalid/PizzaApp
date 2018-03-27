package com.example.oelayad.pizzeria;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PizzeriaMainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnnapolitaine;
    private Button btnroyale;
    private Button btnqfromage;
    private Button btnmontagnarde;
    private Button btnraclette;
    private Button btnhawai;
    private Button btnpannaCotta;
    private Button btntiramisu;


    static int clickhawai;
    static int clickmontagnarde;
    static int clicknapolitaine;
    static int clickpannacotta;
    static int clickqfrommage;
    static int clickraclette;
    static int clickroyale;
    static int clicktiramisu;
    private EditText valueTab;
    private String numTable;
    public static TextView labelText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

        Intent intent = getIntent();
        numTable = intent.getStringExtra(Start_Pizzeria.CLE_DONNEES);

        labelText = (TextView) findViewById(R.id.textTable);
        String newText = labelText.getText() + numTable;
        labelText.setText(newText);

        btnnapolitaine = (Button) findViewById(R.id.napolitaine);
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
                clickhawai++;
                btnhawai.setText("Hawaienne" + ":" + clickhawai);
                nomCommande = (String) btnhawai.getText();
                Commande cHwai = new Commande();
                cHwai.execute(valueTab + "Hawaienne");

                break;
//            fin de hawaienne

            case  R.id.btnmontagnarde:
                clickmontagnarde++;
                btnmontagnarde.setText("Montagnarde " + clickmontagnarde );

                nomCommande = (String) btnmontagnarde.getText();
                Commande cMont = new Commande();
                cMont.execute(valueTab + "Montagnarde");
                break;
//            fin de montagnarde

             case R.id.btnnapolitaine:
                clicknapolitaine++;
                btnnapolitaine.setText("Napolitaine " + clicknapolitaine);

                nomCommande = (String) btnnapolitaine.getText();
                Commande cNap = new Commande();
                cNap.execute(valueTab + "Napolitaine");

                break;
//            fin de napolitaine

            case  R.id.btnpannaCotta:
                clickpannacotta++;
                btnpannaCotta.setText("Pannacotta " + clickpannacotta);

                nomCommande = (String) btnpannaCotta.getText();
                Commande cPana = new Commande();
                cPana.execute(valueTab + "Pannacotta");
                break;
//            fin de panacotta

             case R.id.btnqfromage:
                 clickqfrommage++;
                btnqfromage.setText("Quatre Frommage "+ clickqfrommage);
                nomCommande = (String) btnqfromage.getText();
                Commande cQfrom = new Commande();
                cQfrom.execute(valueTab + "Fromagere");
                break;
//            fin de 4 frommage

            case  R.id.btnraclette:
                clickraclette++;
                btnraclette.setText("Raclette " + clickraclette);

                nomCommande = (String) btnraclette.getText();
                Commande cRac = new Commande();
                cRac.execute(valueTab + "Raclette");

                break;
//            fin de raclette

             case R.id.btnroyale:
                 clickroyale++;
                btnroyale.setText("royale " + clickroyale);
                nomCommande = (String) btnroyale.getText();
                Commande cHawai = new Commande();
                cHawai.execute(valueTab + "Royale");
                break;
//            fin de royale

            case  R.id.btntiramisu:
                clicktiramisu++;
                btntiramisu.setText("Tiramisu " + clicktiramisu);

                nomCommande = (String) btntiramisu.getText();
                Commande cTiram = new Commande();
                cTiram.execute(valueTab + "Tiramisu");
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



}

