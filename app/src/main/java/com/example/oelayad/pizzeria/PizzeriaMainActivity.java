package com.example.oelayad.pizzeria;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.app.Fragment;
import android.app.FragmentTransaction;



public class PizzeriaMainActivity extends AppCompatActivity implements FragmentPizza.OnFragmentInteractionListener {

;
    private int numtab;
    public static String numTable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria_main);

        Intent intent = getIntent();
        numtab = intent.getIntExtra(Start_Pizzeria.CLE_DONNEES, -1);

        if (numtab == -1){
            Log.d("test", "onCreate: Erreur");
            finish();
            System.exit(-1);
        }

        FragmentPizza fragmentPizza = new FragmentPizza();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragementContainer, fragmentPizza);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }






    @Override
    public void onFragmentInteraction(Uri uri) {
        //
    }
}

