package com.example.oelayad.pizzeria;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.net.Uri;

/**
 * A simple {@link Fragment} subclass.
 * * Activities that contain this fragment must implement the
 * {@link FragmentPizza.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */

//=======================================================
//===================Fragment pizzeria====================
//========================================================
public class FragmentPizza extends Fragment implements View.OnClickListener {
//    definition des attribut de la classe
    private Button btnnapolitaine,btnroyale,btnqfromage, btnmontagnarde, btnraclette,  btnhawai,btnpannaCotta, btntiramisu, btncustom  ;
    static int clickhawai, clickmontagnarde, clicknapolitaine, clickpannacotta, clickqfrommage, clickraclette, clickroyale, clicktiramisu = 0;
    public static TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_pizza, container, false);

        super.onCreate(savedInstanceState);


        btnnapolitaine = (Button) view.findViewById(R.id.btnnapolitaine);
        btnnapolitaine.setText("Napolitaine " + clicknapolitaine);
        btnnapolitaine.setOnClickListener(this);

        btnroyale = (Button) view.findViewById(R.id.btnroyale);
        btnroyale.setText("Royale " + clickroyale);
        btnroyale.setOnClickListener(this);

        btnqfromage = (Button) view.findViewById(R.id.btnqfromage);
        btnqfromage.setText("Quatre Frommage "+ clickqfrommage);
        btnqfromage.setOnClickListener(this);

        btnmontagnarde = (Button) view.findViewById(R.id.btnmontagnarde);
        btnmontagnarde.setText("Montagnarde " + clickmontagnarde );
        btnmontagnarde.setOnClickListener(this);

        btnraclette = (Button) view.findViewById(R.id.btnraclette);
        btnraclette.setText("Raclette " + clickraclette);

        btnraclette.setOnClickListener(this);

        btnhawai = (Button) view.findViewById(R.id.btnhawai);
        btnhawai.setText("Hawaienne" + ":" + clickhawai);
        btnhawai.setOnClickListener(this);

        btnpannaCotta = (Button) view.findViewById(R.id.btnpannaCotta);
        btnpannaCotta.setText("Pannacotta " + clickpannacotta);
        btnpannaCotta.setOnClickListener(this);

        btntiramisu = (Button) view.findViewById(R.id.btntiramisu);
        btntiramisu.setText("Tiramisu " + clicktiramisu);
        btntiramisu.setOnClickListener(this);

        btncustom = (Button) view.findViewById(R.id.btnCustom);
        btncustom.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        text = (TextView) getActivity().findViewById(R.id.textTable);

        String nomCommande;
        switch (v.getId()){
            case R.id.btnhawai:
                clickhawai++;
                btnhawai.setText("Hawaienne" + ":" + clickhawai);
                nomCommande = (String) btnhawai.getText();
                Commande cHwai = new Commande();
                cHwai.execute(text.getText() + "Hawaienne");
                break;
//            fin de hawaienne

            case  R.id.btnmontagnarde:
                clickmontagnarde++;
                btnmontagnarde.setText("Montagnarde " + clickmontagnarde );

                nomCommande = (String) btnmontagnarde.getText();
                Commande cMont = new Commande();
                cMont.execute(text.getText() + "Montagnarde");
                break;
//            fin de montagnarde

            case R.id.btnnapolitaine:
                clicknapolitaine++;
                btnnapolitaine.setText("Napolitaine " + clicknapolitaine);

                nomCommande = (String) btnnapolitaine.getText();
                Commande cNap = new Commande();
                cNap.execute(text.getText() + "Napolitaine");

                break;
//            fin de napolitaine

            case  R.id.btnpannaCotta:
                clickpannacotta++;
                btnpannaCotta.setText("Pannacotta " + clickpannacotta);

                nomCommande = (String) btnpannaCotta.getText();
                Commande cPana = new Commande();
                cPana.execute(text.getText() + "Pannacotta");
                break;
//            fin de panacotta

            case R.id.btnqfromage:
                clickqfrommage++;
                btnqfromage.setText("Quatre Frommage "+ clickqfrommage);
                nomCommande = (String) btnqfromage.getText();
                Commande cQfrom = new Commande();
                cQfrom.execute(text.getText() + "Fromagere");
                break;
//            fin de 4 frommage

            case  R.id.btnraclette:
                clickraclette++;
                btnraclette.setText("Raclette " + clickraclette);

                nomCommande = (String) btnraclette.getText();
                Commande cRac = new Commande();
                cRac.execute(text.getText() + "Raclette");

                break;
//            fin de raclette

            case R.id.btnroyale:
                clickroyale++;
                btnroyale.setText("Royale " + clickroyale);
                nomCommande = (String) btnroyale.getText();
                Commande cHawai = new Commande();
                cHawai.execute(text.getText() + "Royale");
                break;
//            fin de royale

            case  R.id.btntiramisu:
                clicktiramisu++;
                btntiramisu.setText("Tiramisu " + clicktiramisu);

                nomCommande = (String) btntiramisu.getText();
                Commande cTiram = new Commande();
                cTiram.execute(text.getText() + "Tiramisu");
                break;
//            fin de tirramissu

             case  R.id.btnCustom:
                 CustumPizzaFragment fragmentCustom = new CustumPizzaFragment();
                 FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                 fragmentTransaction.replace(R.id.fragementContainer, fragmentCustom);
                 fragmentTransaction.addToBackStack(null);
                 fragmentTransaction.commit();
                break;
//            fin de Custom

        }
//        end of switch

    }
//        end of function onClick

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(getResources().getString(R.string.key_hawaienne),clickhawai );
        outState.putInt(getResources().getString(R.string.key_montagnarde),clickmontagnarde );
        outState.putInt(getResources().getString(R.string.key_napolitaine),clicknapolitaine );
        outState.putInt(getResources().getString(R.string.key_pannaCotta),clickpannacotta );
        outState.putInt(getResources().getString(R.string.key_qfrommage),clickqfrommage );
        outState.putInt(getResources().getString(R.string.key_raclette),clickraclette );
        outState.putInt(getResources().getString(R.string.key_royale),clickroyale );
        outState.putInt(getResources().getString(R.string.key_tiramisu),clicktiramisu);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        super.onResume();
        applyPref();
    }

    // Méthode pour appliquer les préférences :
    protected void applyPref() {
        // - récupérer les valeurs choisies par l'utilisateur
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean color = sharedPref.getBoolean(String.valueOf(getResources().getText(R.string.COLOR)), true);

//        permet de colorer les boutton
        if(color){
            btncustom.setBackgroundColor(getResources().getColor(R.color.colorRed));
            btnhawai.setBackgroundColor(getResources().getColor(R.color.colorRed));
            btnmontagnarde.setBackgroundColor(getResources().getColor(R.color.colorRed));
            btnnapolitaine.setBackgroundColor(getResources().getColor(R.color.colorRed));
            btnpannaCotta.setBackgroundColor(getResources().getColor(R.color.colorRed));
            btnqfromage.setBackgroundColor(getResources().getColor(R.color.colorRed));
            btnraclette.setBackgroundColor(getResources().getColor(R.color.colorRed));
            btnroyale.setBackgroundColor(getResources().getColor(R.color.colorRed));
            btntiramisu.setBackgroundColor(getResources().getColor(R.color.colorRed));
        }
    }

//    alerte pour reinitialiser
    public void alert(){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
//                    on declare tout le click a 0 et on set le text des boutton
                    clickhawai=0;
                    clickmontagnarde=0;
                    clicknapolitaine=0;
                    clickpannacotta=0;
                    clickqfrommage=0;
                    clickraclette=0;
                    clickroyale=0;
                    clicktiramisu = 0;

                    btnhawai.setText("Hawaienne" + ":" + clickhawai);
                    btnmontagnarde.setText("Montagnarde " + clickmontagnarde );
                    btnnapolitaine.setText("Napolitaine " + clicknapolitaine);
                    btnpannaCotta.setText("Pannacotta " + clickpannacotta);
                    btnqfromage.setText("Quatre Frommage "+ clickqfrommage);
                    btnraclette.setText("Raclette " + clickraclette);
                    btnroyale.setText("Royale " + clickroyale);
                    btntiramisu.setText("Tiramisu " + clicktiramisu);

                }
            }
        };
        AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());

        ab.setMessage(R.string.modal_reset).setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }
}
