package com.example.oelayad.pizzeria;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
//=======================================================
//===================Main pizzeria=======================
//=======================================================

public class PizzeriaMainActivity extends AppCompatActivity implements FragmentPizza.OnFragmentInteractionListener {
    private int numtab;
    public static String numTable;
    public static TextView textHead;

//    recuperer les deux fragement utilisé: fragement pizza et preferenceFragment
    FragmentPizza fragmentPizza = new FragmentPizza();
    PreferenceFragment preferenceFragment = new Prefs();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

// Recuperer la valeur de l'input pour l'afficher
        Intent intent = getIntent();
        numTable = intent.getStringExtra(Start_Pizzeria.CLE_DONNEES);
        textHead = (TextView) findViewById(R.id.textTable);


        if(numTable.length() >0 && numTable.length()<1){
            numTable = "0" + numTable;
        }
        textHead.setText(numTable);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragementContainer, fragmentPizza);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //
    }

    // Création du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Écouteur sur le menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // L'item sur lequel l'utilisateur a cliqué
        int id = item.getItemId();
        // Action choisie selon l'item
        switch (id){
//            pour afficher les reglages
            case R.id.action_settings:
                    // Attachement du fragment de préférences
                    getFragmentManager().beginTransaction().addToBackStack("pref").replace(R.id.fragementContainer, preferenceFragment).commit();
                    return true;
//          pour reinitialiser les commandes
            case R.id.action_reset:
                fragmentPizza.alert();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onResume() {
        super.onResume();
        applyPref();
    }

    // Méthode pour appliquer les préférences :
    protected void applyPref() {
        // - récupérer les valeurs choisies par l'utilisateur
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean color = sharedPref.getBoolean(String.valueOf(getResources().getText(R.string.COLOR)), true);

    }

}

