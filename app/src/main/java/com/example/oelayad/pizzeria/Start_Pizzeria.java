package com.example.oelayad.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Start_Pizzeria extends AppCompatActivity implements View.OnClickListener {

    public final static String SAUVEGARDE_SAISIE = "Sauvegarde du champ text";
    final static String CLE_DONNEES = "passage numTable";
    private Button btnSubmit;
    private EditText textInput;
    private String tableNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start__pizzeria);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        textInput = (EditText) findViewById(R.id.textInput);

        if(savedInstanceState != null){
            tableNum = savedInstanceState.getString(SAUVEGARDE_SAISIE);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSubmit) {
            tableNum = String.valueOf(textInput.getText());
            Intent intent = new Intent(this, PizzeriaMainActivity.class);
            intent.putExtra(CLE_DONNEES, tableNum);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ACTIVITÉ : PizzariaTable \nMÉTHODE : onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ACTIVITÉ : PizzariaTable \nMÉTHODE : onStop");
    }
}