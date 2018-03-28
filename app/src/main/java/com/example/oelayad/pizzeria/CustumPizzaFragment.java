package com.example.oelayad.pizzeria;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustumPizzaFragment extends Fragment implements View.OnClickListener{

    private Button btnMozzarella;
    private Button btnGorgonzola;
    private Button btnOlives;
    private Button btnAnchois;
    private Button btnArtichaud;
    private Button btnCapres;
    private Button btnTuna;
    private Button btnegg;
    private Button btnEnvoyer;

    private String nomIngredient;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_custum_pizza, container, false);

        btnMozzarella = (Button) v.findViewById(R.id.btnMozzarella);
        btnMozzarella.setOnClickListener(this);

        btnGorgonzola = (Button) v.findViewById(R.id.btnGorgonzola);
        btnGorgonzola.setOnClickListener(this);

        btnOlives = (Button) v.findViewById(R.id.btnOlives);
        btnOlives.setOnClickListener(this);

        btnAnchois = (Button) v.findViewById(R.id.btnAnchois);
        btnAnchois.setOnClickListener(this);

        btnArtichaud = (Button) v.findViewById(R.id.btnArtichaud);
        btnArtichaud.setOnClickListener(this);

        btnCapres = (Button) v.findViewById(R.id.btnCapres);
        btnCapres.setOnClickListener(this);

        btnTuna = (Button) v.findViewById(R.id.btnTuna);
        btnTuna.setOnClickListener(this);

        btnegg = (Button) v.findViewById(R.id.btnegg);
        btnegg.setOnClickListener(this);

        btnEnvoyer = (Button) v.findViewById(R.id.btnEnvoyer);
        btnEnvoyer.setOnClickListener(this);


        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMozzarella:
                btnMozzarella.setBackgroundColor(Color.WHITE);
                nomIngredient += (String) btnMozzarella.getText();
                break;
//            fin de Mozzarella

            case  R.id.btnGorgonzola:
                btnGorgonzola.setBackgroundColor(Color.WHITE);
                nomIngredient += (String) btnGorgonzola.getText();
                break;
//            fin de montagnarde

          case  R.id.btnOlives:
                btnOlives.setBackgroundColor(Color.WHITE);
                nomIngredient += (String) btnOlives.getText()+ " ";
                break;
//            fin de Olives

          case  R.id.btnAnchois:
                btnAnchois.setBackgroundColor(Color.WHITE);
                nomIngredient += (String) btnAnchois.getText()+ " ";
                break;
//            fin de Anchois

          case  R.id.btnArtichaud:
                btnArtichaud.setBackgroundColor(Color.WHITE);
                nomIngredient += (String) btnArtichaud.getText() + " ";
                break;
//            fin de Artichaud

          case  R.id.btnCapres:
                btnCapres.setBackgroundColor(Color.WHITE);
                nomIngredient += (String) btnCapres.getText()+ " ";
                break;
//            fin de Capres

          case  R.id.btnTuna:
                btnTuna.setBackgroundColor(Color.WHITE);
                nomIngredient += (String) btnTuna.getText()+ " ";
                break;
//            fin de Tuna

           case  R.id.btnegg:
                btnegg.setBackgroundColor(Color.WHITE);
                nomIngredient += (String) btnegg.getText()+ " ";
                break;
//            fin de Egg

          case  R.id.btnEnvoyer:


              Commande cCustom = new Commande();
              System.out.println(PizzeriaMainActivity.numTable+nomIngredient);
              cCustom.execute(PizzeriaMainActivity.numTable+nomIngredient);

              FragmentPizza fragmentPizza = new FragmentPizza();
              FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
              fragmentTransaction.replace(R.id.fragementContainer, fragmentPizza);
              fragmentTransaction.addToBackStack(null);
              fragmentTransaction.commit();
              break;
//            fin de Envoyer

        }
//        end of switch
    }


}
