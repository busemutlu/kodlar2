package com.example.dilay.myapplication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Bundle alinanBundle;
    int sayi,operatorCount=0;
    String trueAnswer,question;
    TextView soru;
    EditText answer;
    Button   answerBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final MediaPlayer succesfull=MediaPlayer.create(this,R.raw.succes);
        final MediaPlayer fail=MediaPlayer.create(this,R.raw.fail);


        alinanBundle=getIntent().getExtras();

        soru=(TextView)findViewById(R.id.questionStack);
        answer=(EditText)findViewById(R.id.answerEditTextStack);
        answerBut=(Button)findViewById(R.id.answerButtonStack);

        sayi=alinanBundle.getInt("sayi");
        if(sayi==4)
            operatorCount=3;
        else if(sayi==5)
            operatorCount=4;
        else if(sayi==7)
            operatorCount=4;



        question=QuestionGenarator.Genearete(sayi,operatorCount);
        trueAnswer=String.valueOf(Calculator.findPostfixResult(question));
        Log.w("Sayı degeri",trueAnswer);

        if(trueAnswer.endsWith(".0"))
            trueAnswer=removelastTwoChar(trueAnswer);


        Log.w("Sayı degeri2",trueAnswer);


        soru.setText(question);

        answerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if(!answer.getText().equals("")){
                   if(String.valueOf(answer.getText()).replaceAll("\\s+$", "").equals(trueAnswer)){
                       succesfull.start();

                       question=QuestionGenarator.Genearete(sayi,operatorCount);

                       trueAnswer=String.valueOf(Calculator.findPostfixResult(question));

                       if(trueAnswer.endsWith(".0"))
                           trueAnswer=removelastTwoChar(trueAnswer);


                       soru.setText(question);
                       answer.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                       answer.setText("");
                        Log.w("Sayı degeri",trueAnswer);





                    }else {
                       answer.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                       fail.start();
                       answer.startAnimation(vibrateText());
                   }


            }
        });

    }
    public TranslateAnimation vibrateText() {
        TranslateAnimation vibrate = new TranslateAnimation(0, 8, 0, 0);
        vibrate.setDuration(450);
        vibrate.setInterpolator(new CycleInterpolator(5));
        return vibrate;
    }

    private  String removelastTwoChar(String str) {
        double temp =Double.parseDouble(str);
        str=String.valueOf((int)temp);
        return str;
    }
}
