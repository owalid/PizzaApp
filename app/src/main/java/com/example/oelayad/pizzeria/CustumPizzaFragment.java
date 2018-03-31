package com.example.oelayad.pizzeria;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
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
//declaration des bouttons
    private Button btnMozzarella,btnGorgonzola, btnOlives, btnAnchois, btnArtichaud, btnCapres, btnTuna, btnegg, btnEnvoyer;
//    declaration de la chaine de caractere contenant tout les ingredient
    private String nomIngredient="";


//    creation de la vue
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_custum_pizza, container, false);

//        on recupere le bouton de la vue
        btnMozzarella = (Button) v.findViewById(R.id.btnMozzarella);
//        on defini un ecouteur d'evenement pour interragir avec les boutton
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
//                on modifie la couleur du boutton
                btnMozzarella.setBackgroundColor(Color.WHITE);
//                  on concatene la chaine de caractere nomIngredient definit plus haut
                nomIngredient += (String) btnMozzarella.getText();
                break;
//            fin de Mozzarella

            case  R.id.btnGorgonzola:
                btnGorgonzola.setBackgroundColor(Color.WHITE);
                nomIngredient += (String) btnGorgonzola.getText();
                break;
//            fin de Gorgonzola

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
//          on verifie que la chaine de caractere n'es pas nulle sinon on envois une alerte
            if(!nomIngredient.equals("")){
//    on instancie un objet commande
                Commande cCustom = new Commande();
//                on execute la commande pour l'envoyer au serveur
                cCustom.execute(PizzeriaMainActivity.numTable+nomIngredient);

//                on recupere le fragment pizza pour retourner en arriere
                FragmentPizza fragmentPizza = new FragmentPizza();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragementContainer, fragmentPizza);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
            else{
                alert();
            }

              break;
//            fin de Envoyer

        }
//        end of switch
    }

//    definition de l'alerte
    public void alert(){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        };
        AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
        ab.setMessage(R.string.No_custom).setPositiveButton("OK", dialogClickListener).show();
    }

}
//end of class

