package com.example.oelayad.pizzeria;

import android.app.Fragment;
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
                nomIngredient += (String) btnMozzarella.getText();
                break;
//            fin de Mozzarella

            case  R.id.btnmontagnarde:
                nomIngredient += (String) btnGorgonzola.getText();
                break;
//            fin de montagnarde

          case  R.id.btnOlives:
                nomIngredient += (String) btnOlives.getText()+ " ";
                break;
//            fin de Olives

          case  R.id.btnAnchois:
                nomIngredient += (String) btnAnchois.getText()+ " ";
                break;
//            fin de Anchois

          case  R.id.btnArtichaud:
                nomIngredient += (String) btnArtichaud.getText() + " ";
                break;
//            fin de Artichaud

          case  R.id.btnCapres:
                nomIngredient += (String) btnCapres.getText()+ " ";
                break;
//            fin de Capres

          case  R.id.btnTuna:
                nomIngredient += (String) btnTuna.getText()+ " ";
                break;
//            fin de Tuna

           case  R.id.btnegg:
                nomIngredient += (String) btnegg.getText()+ " ";
                break;
//            fin de Egg

          case  R.id.btnEnvoyer:

              Commande cCustom = new Commande();
              cCustom.execute(PizzeriaMainActivity.numTable+nomIngredient);

              break;
//            fin de Envoyer

        }
//        end of switch
    }


}
