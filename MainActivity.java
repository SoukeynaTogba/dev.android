package com.example.appli_intent03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //on déclare les variables dont on aura besoin partout
    protected String textModifie;
    protected TextView textedeux;
    protected EditText letexte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textedeux = findViewById(R.id.textView); //on précise de quel textview il s'agit pour la variable textedeux
        letexte = findViewById(R.id.editText); //on précise de quel edittext il s'agit pour la variable letexte

        //Déclaration de la variable modifier
        Button modifier = findViewById(R.id.modifier);

        //Création de la fonction modifier au clique
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //on met letexte (EditText) dans la variable lecontenu
                String lecontenu = letexte.getText().toString();
                // à savoir: quand on fait un getText on précise toujours que c'est une chaine de charactère (tostring)

                //on crée l'intention d'envoyer sur la deuxieme page
                Intent envoie = new Intent(MainActivity.this, SecondActivity.class);
                envoie.putExtra("ici" , lecontenu); //ça envoie lecontenu dans la chaine de charactere qui récupere dans la deuxième page et qui se nomme 'ici'

                //on ouvre l'activite en attendant un retour, il faut donner un code au cas ou on a plusieurs activités
                startActivityForResult(envoie,1);

            }
        });

        //déclaration de la variable pour le boutton valider
        Button valider = findViewById(R.id.valider);

        //création de la fonction du boutton valider qui à une réaction au clique
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Met letexte du TextView dans L'EditText qui se nomme textedeux
                letexte.setText(textedeux.getText().toString());
                //ne pas oublier de préciser que c'est une chaine de character avec toString
            }
        });


    }


    @Override
    //On repond au start activity on result
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //si le startActivity correspond bien à 1
        if (requestCode  == 1 && RESULT_OK == resultCode) {
            textModifie = data.getStringExtra("la"); //On met dans la variable TextModifie ce qu'on avait dans 'la'
            textedeux.setText(textModifie); //Et on met dans l'EditText textdeux ce qu'on a dans la variable TextModifie

        }


    }

}