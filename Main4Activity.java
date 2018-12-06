package com.example.dilay.myapplication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.media.MediaPlayer;

public class Main4Activity extends AppCompatActivity {
    Bundle alinanBundle;
    int sayi;
    String [] trueAnswers=new String[3];
    String [] results=new String[4];
    TextView question;
    EditText preOrder,inOrder,postOrder;
    Button answerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        alinanBundle=getIntent().getExtras();
        question=(TextView)findViewById(R.id.questionBST);
        preOrder=(EditText)findViewById(R.id.preOrderText);
        inOrder=(EditText)findViewById(R.id.inOrder);
        postOrder=(EditText)findViewById(R.id.postOrder);
        answerButton=(Button)findViewById(R.id.bstAnswerButton);

        final MediaPlayer succesfull=MediaPlayer.create(this,R.raw.succes);
        final MediaPlayer fail=MediaPlayer.create(this,R.raw.fail);
        sayi=alinanBundle.getInt("sayi");
        clearEditText();

        results=QuestionGenarator.GenerateTreeQuestion(sayi);
        question.setText(results[0]);

        Log.w("Sayı degeri",results[1]+" "+" "+results[2]+" "+results[3]);









        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String userAnswerForPreOrder= String.valueOf(preOrder.getText()).replaceAll("\\s+$", "");
            String userAnswerForInOrder=String.valueOf(inOrder.getText()).replaceAll("\\s+$", "");
            String userAnswerForPostOrder=String.valueOf(postOrder.getText()).replaceAll("\\s+$", "");
            boolean isAllTrue=false;

            if(userAnswerForPreOrder.equals(results[1].replaceAll("\\s+$", ""))){
                isAllTrue=true;
                preOrder.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
            }else{
                isAllTrue=false;
                preOrder.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                preOrder.startAnimation(vibrateText());
            }
            if(userAnswerForInOrder.equals(results[2].replaceAll("\\s+$", ""))){
                    isAllTrue=true;
                inOrder.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
            }else{
                isAllTrue=false;
                inOrder.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                inOrder.startAnimation(vibrateText());
            }
            if(userAnswerForPostOrder.equals(results[3].replaceAll("\\s+$", ""))){
                    isAllTrue=true;
                postOrder.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
            }else{
                isAllTrue=false;
                postOrder.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                postOrder.startAnimation(vibrateText());
            }

            if (isAllTrue){
                clearEditText();
                results=QuestionGenarator.GenerateTreeQuestion(sayi);
                question.setText(results[0]);
                succesfull.start();
            }
            else {
                fail.start();

            }

            }
        });








    }
    void clearEditText(){
        preOrder.setText("");
        preOrder.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
        preOrder.setHint("Please Enter preOrder");
        inOrder.setText("");
        inOrder.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        inOrder.setHint("Please Enter inOrder");
        postOrder.setText("");
        postOrder.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        postOrder.setHint("Please Enter postOrder");
    }

    public TranslateAnimation vibrateText() {
        TranslateAnimation vibrate = new TranslateAnimation(0, 8, 0, 0);
        vibrate.setDuration(450);
        vibrate.setInterpolator(new CycleInterpolator(5));
        return vibrate;
    }
}
