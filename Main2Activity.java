package com.example.dilay.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Bundle alinanBundle;
    String secim;
    int sayi;
    Button easyButton, mediumButton, hardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        alinanBundle = getIntent().getExtras();

        easyButton = (Button) findViewById(R.id.easyButton);
        mediumButton = (Button) findViewById(R.id.mediumButton);
        hardButton = (Button) findViewById(R.id.hardButton);

        secim = alinanBundle.getString("secim");




        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(secim.equals("stack")){

                    sayi = 4;
                }else{sayi = 3;
                }

                launchFinalActivity(secim,sayi);


            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sayi = 5;

                launchFinalActivity(secim,sayi);
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sayi = 7;

                launchFinalActivity(secim,sayi);


            }
        });





    }

    private void launchFinalActivity(String secim, int sayi){

        Intent intent = null;

        Bundle bundle = new Bundle();

        if(secim.equals("stack")){

            intent = new Intent(Main2Activity.this,Main3Activity.class);


        }else if(secim.equals("searchtree")){


            intent = new Intent(Main2Activity.this,Main4Activity.class);

        }



        bundle.putInt("sayi",sayi);

        intent.putExtras(bundle);

        startActivity(intent);

    }
}
