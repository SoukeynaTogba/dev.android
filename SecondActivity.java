package com.example.appli_intent03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //pour recevoir ce que le boutton valider envoie
        Intent envoie = getIntent();
        String recuperation = envoie.getStringExtra("ici"); //ici cest le textview de la deuxieme page

        TextView text = findViewById(R.id.textView2);
        text.setText(recuperation);




        //boutton majuscule
        Button maj = findViewById(R.id.maj);

        maj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView sectext = findViewById(R.id.textView2);

                //dans la variable contient qui est une chaine de character, met le TextView de la deuxieme page qui se nomme sectexte
                String contient = sectext.getText().toString().toUpperCase();
                //on precise que c'est une chaine de character avec toString, et on le transforme en majuscule avec toUpperCase


                Intent renvoie = new Intent();
                renvoie.putExtra("la" , contient);
                setResult(RESULT_OK,renvoie);
                finish(); //on termine le resultat
            }
        });


        //boutton inverser
        Button inverser = findViewById(R.id.inverser);

        inverser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //dans la variable reverse qui est une chaine de character, on met ce qu'il y avait 'ici' et qu'on a mis dans la variable recuperation
                String reverse = new StringBuilder(recuperation).reverse().toString();
                //On inverse le texte grace à StringBuilder().reverse().

                Intent renvoiedeux = new Intent();
                renvoiedeux.putExtra("la" , reverse);//(la c'est le textView de la premiere page) on utilise la variable reverse pour inverser
                setResult(RESULT_OK,renvoiedeux);
                finish();
            }
        });



    }
}