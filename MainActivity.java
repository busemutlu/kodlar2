package com.example.dilay.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int secim;

    Button stackButton;
    Button searchTreeButton;

    Intent secondClassIntent;
    Bundle secondClassBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stackButton = (Button) findViewById(R.id.stackButton);
        searchTreeButton= (Button) findViewById(R.id.binarysearchButton);
        secondClassBundle = new Bundle();
        secondClassIntent = new Intent(MainActivity.this,Main2Activity.class);

        stackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                secondClassBundle.putString("secim","stack");
                secondClassIntent.putExtras(secondClassBundle);
                startActivity(secondClassIntent);
               // finish();

            }
        });


        searchTreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                secondClassBundle.putString("secim","searchtree");
                secondClassIntent.putExtras(secondClassBundle);
                startActivity(secondClassIntent);
                //finish();

            }
        });

    }
}
