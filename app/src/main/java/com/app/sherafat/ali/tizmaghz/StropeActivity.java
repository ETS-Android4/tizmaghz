package com.app.sherafat.ali.tizmaghz;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class StropeActivity extends AppCompatActivity {

    String RED="#ec3333";
    String BLUE="#3c3cee";
    String YELLOW ="#eadd0d";
    String GREEN="#2ae026";
    private String[] colorName = {"قرمز","آبی","زرد","سبز"};
    private String[] colorCode = {RED,BLUE,YELLOW,GREEN};
    TextView txtStropeAsk;
    private TextView txtTime;
    private ProgressBar progressBar;
    ImageView imgRed;
    ImageView imgBlue;
    ImageView imgYell;
    ImageView imgGreen;
    private int numberOfQues =G.preferences.getInt("STROPE",50);
    public int i = 0;
    private int counterTime;
    int rand1;
    int rand2;
    private String color;
    Animation shake;
    int week;
    int day;
    boolean superUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strope);

        week = G.preferences.getInt("WEEK",-1);
        day = G.preferences.getInt("DAY",0);
        superUser = G.preferences.getBoolean("SUPER_USER", false);

        shake = AnimationUtils.loadAnimation(getApplication(), R.anim.shake);

        progressBar =(ProgressBar) findViewById(R.id.progressBar);


        imgRed = (ImageView) findViewById(R.id.imgRed);
        imgBlue = (ImageView) findViewById(R.id.imgBlue);
        imgYell = (ImageView) findViewById(R.id.imgYell);
        imgGreen = (ImageView) findViewById(R.id.imgGreen);

        txtStropeAsk = (TextView) findViewById(R.id.txtStropeAsk);
        txtStropeAsk.setTypeface(G.yekan);
        txtStropeAsk.setTextSize(TypedValue.COMPLEX_UNIT_DIP,35);
        txtTime = (TextView) findViewById(R.id.txtTime);


        progressBar.setMax(numberOfQues);


        getRandomQues ();

        startTimer();


        imgRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
     if (color.equals(RED)) {
                // Toast.makeText(G.context,"درسته",Toast.LENGTH_SHORT).show();
                 getRandomQues();
     }else {
         txtStropeAsk.startAnimation(shake);
     }
            }
        });

        imgBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color.equals(BLUE)) {
                   // Toast.makeText(G.context,"درسته",Toast.LENGTH_SHORT).show();
                    getRandomQues();
                }else {
                    txtStropeAsk.startAnimation(shake);
                }
            }
        });

        imgYell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color.equals(YELLOW)) {
                  //  Toast.makeText(G.context,"درسته",Toast.LENGTH_SHORT).show();
                    getRandomQues();
                }else {
                    txtStropeAsk.startAnimation(shake);
                }
            }
        });

        imgGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color.equals(GREEN)) {
                  //  Toast.makeText(G.context,"درسته",Toast.LENGTH_SHORT).show();
                    getRandomQues();
                }else {
                    txtStropeAsk.startAnimation(shake);
                }
            }
        });

    }

    private void startTimer(){

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtTime.setText(String.valueOf(counterTime));
                        counterTime++;
                    }
                });
            }
        }, 1000, 1000);

    }

    public void getRandomQues () {

        progressBar.setProgress(i);

        i++;

        if (i > numberOfQues) {
                SharedPreferences.Editor editor = G.preferences.edit();
            if (superUser){
                Toast.makeText(G.context,counterTime+" ثانیه",Toast.LENGTH_SHORT).show();
            }
            if (!superUser) {
           Toast.makeText(getApplicationContext(),"آزمونا تموم شد :)", Toast.LENGTH_LONG).show();
                editor.putInt("WEEK", week + 1);
                editor.putBoolean("TEST_TIME", true);
                editor.putInt("SECOND_STROPE" + (week + 1), counterTime);
            }
            editor.putBoolean("SUPER_USER",false);
            editor.commit();
                finish();
        }


         rand1 = (int) (Math.random() * 4);
         rand2 = (int) (Math.random() * 4);

        switch (rand2){
            case 0:
                color=RED;
                break;
            case 1:
                color=BLUE;
                break;
            case 2:
                color=YELLOW;
                break;
            case 3:
                color=GREEN;
                break;
        }

        txtStropeAsk.setText(colorName[rand1]);
        txtStropeAsk.setTextColor(Color.parseColor(colorCode[rand2]));

    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_strope, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
