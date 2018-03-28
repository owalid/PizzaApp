package com.example.oelayad.pizzeria;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.os.PersistableBundle;
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
public class FragmentPizza extends Fragment implements View.OnClickListener {
    private Button btnnapolitaine;
    private Button btnroyale;
    private Button btnqfromage;
    private Button btnmontagnarde;
    private Button btnraclette;
    private Button btnhawai;
    private Button btnpannaCotta;
    private Button btntiramisu;
    private Button btncustom;


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
    private int numtab;
    public static TextView labelText;

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

        //get text for label
        labelText = (TextView) view.findViewById(R.id.textTable);
        String newText = labelText.getText() + PizzeriaMainActivity.numTable;
        labelText.setText(newText);

        btnnapolitaine = (Button) view.findViewById(R.id.napolitaine);
        btnnapolitaine.setOnClickListener(this);

        btnroyale = (Button) view.findViewById(R.id.btnroyale);
        btnroyale.setOnClickListener(this);

        btnqfromage = (Button) view.findViewById(R.id.btnqfromage);
        btnqfromage.setOnClickListener(this);

        btnmontagnarde = (Button) view.findViewById(R.id.btnmontagnarde);
        btnmontagnarde.setOnClickListener(this);

        btnraclette = (Button) view.findViewById(R.id.btnraclette);
        btnraclette.setOnClickListener(this);

        btnhawai = (Button) view.findViewById(R.id.btnhawai);
        btnhawai.setOnClickListener(this);

        btnpannaCotta = (Button) view.findViewById(R.id.btnpannaCotta);
        btnpannaCotta.setOnClickListener(this);

        btntiramisu = (Button) view.findViewById(R.id.btntiramisu);
        btntiramisu.setOnClickListener(this);

        btncustom = (Button) view.findViewById(R.id.btnCustom);
        btncustom.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        String text = labelText.getText().toString();
        if(text.length() >0 && text.length()<10){
            System.out.println("----------------" + labelText.getText() + "--------------");
            numTable = "0" + text;
        }else{
            numTable = String.valueOf(numtab);
        }
        String nomCommande;
        switch (v.getId()){
            case R.id.btnhawai:
                clickhawai++;
                btnhawai.setText("Hawaienne" + ":" + clickhawai);
                nomCommande = (String) btnhawai.getText();
                Commande cHwai = new Commande();
                cHwai.execute(text + "Hawaienne");

                break;
//            fin de hawaienne

            case  R.id.btnmontagnarde:
                clickmontagnarde++;
                btnmontagnarde.setText("Montagnarde " + clickmontagnarde );

                nomCommande = (String) btnmontagnarde.getText();
                Commande cMont = new Commande();
                cMont.execute(text + "Montagnarde");
                break;
//            fin de montagnarde

            case R.id.btnnapolitaine:
                clicknapolitaine++;
                btnnapolitaine.setText("Napolitaine " + clicknapolitaine);

                nomCommande = (String) btnnapolitaine.getText();
                Commande cNap = new Commande();
                cNap.execute(text + "Napolitaine");

                break;
//            fin de napolitaine

            case  R.id.btnpannaCotta:
                clickpannacotta++;
                btnpannaCotta.setText("Pannacotta " + clickpannacotta);

                nomCommande = (String) btnpannaCotta.getText();
                Commande cPana = new Commande();
                cPana.execute(text + "Pannacotta");
                break;
//            fin de panacotta

            case R.id.btnqfromage:
                clickqfrommage++;
                btnqfromage.setText("Quatre Frommage "+ clickqfrommage);
                nomCommande = (String) btnqfromage.getText();
                Commande cQfrom = new Commande();
                cQfrom.execute(text + "Fromagere");
                break;
//            fin de 4 frommage

            case  R.id.btnraclette:
                clickraclette++;
                btnraclette.setText("Raclette " + clickraclette);

                nomCommande = (String) btnraclette.getText();
                Commande cRac = new Commande();
                cRac.execute(text + "Raclette");

                break;
//            fin de raclette

            case R.id.btnroyale:
                clickroyale++;
                btnroyale.setText("royale " + clickroyale);
                nomCommande = (String) btnroyale.getText();
                Commande cHawai = new Commande();
                cHawai.execute(text + "Royale");
                break;
//            fin de royale

            case  R.id.btntiramisu:
                clicktiramisu++;
                btntiramisu.setText("Tiramisu " + clicktiramisu);

                nomCommande = (String) btntiramisu.getText();
                Commande cTiram = new Commande();
                cTiram.execute(text + "Tiramisu");
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
}
