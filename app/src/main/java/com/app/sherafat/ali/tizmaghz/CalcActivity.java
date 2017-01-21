package com.app.sherafat.ali.tizmaghz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class CalcActivity extends AppCompatActivity {

    private TextView txt_ques;
    private TextView txtTime;
    private EditText  editText ;
    private int value;
    private int numberOfQues = G.preferences.getInt("CALCULATE",100);
    public int i = 0;
    private ProgressBar progressBar;
    private int counterTime;
    int day;
    int week;
    boolean flag;
    boolean superUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mohasebe);
        txt_ques = (TextView) findViewById(R.id.txt_ques);
        txtTime = (TextView) findViewById(R.id.txtTime);
        editText = (EditText) findViewById(R.id.editText);
        progressBar =(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(numberOfQues);
        editText.setTypeface(G.yekan);
        txt_ques.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);

        day = G.preferences.getInt("DAY",0);
        week = G.preferences.getInt("WEEK", -1);
        flag=G.preferences.getBoolean("TEST_TIME", false);
        superUser=G.preferences.getBoolean("SUPER_USER", false);
if (!superUser) {
    TextView txrShowDay = (TextView) findViewById(R.id.txtShowDay);
    txrShowDay.setText("روز " + (day + 1));
    txrShowDay.setTypeface(G.yekan);
    txrShowDay.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 35);
    txrShowDay.setTextColor(Color.GRAY);
}

        if (!(G.preferences.getBoolean("WELLCOMED_CALC",false))){

            final AlertDialog.Builder builder =
                    new AlertDialog.Builder(CalcActivity.this, R.style.AppCompatAlertDialogStyle);
            builder.setTitle("حالا آزمونا چه شکلیه ؟");
            builder.setMessage("برای اینکه با آزمونا آشنا بشی راهنما رو بزن !");
            builder.setPositiveButton(" راهنما ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = G.preferences.edit();
                    editor.putBoolean("WELLCOMED_CALC", true);
                    editor.putBoolean("HELP",true);
                    editor.commit();
                    Intent intent = new Intent(CalcActivity.this, tizMaghz.class);
                    startActivity(intent);
                    dialog.dismiss();
                    finish();
                }
            });

            builder.setCancelable(false);
            builder.show();
        }


        if (week==12 & !superUser){
            // after course
                //  DAY SECOND EQUAL TO ZERO

            final AlertDialog.Builder builder =
                    new AlertDialog.Builder(CalcActivity.this, R.style.AppCompatAlertDialogStyle);
            builder.setTitle("پایان دوره...");
            builder.setMessage("خُب ، دوره شصت روزتون تموم شد:)  میخای از اول شروع کنی؟");
            builder.setPositiveButton("آره", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = G.preferences.edit();
                    editor.putInt("WEEK",-1);
                    editor.putInt("DAY",0);
                    editor.putBoolean("TEST_TIME", false);
                    for (int i=1 ; i<=60; i++){
                        editor.putInt("SECOND_DAY"+ i , 0);
                    }
                    for (int i=0; i<=12; i++){
                        editor.putInt("MEMORIZE_WEEK"+i,0);
                        editor.putInt("SECOND_STROPE"+i,0);
                    }
                    editor.commit();
                    dialog.dismiss();
                    finish();
                }
            });
            builder.setNegativeButton("نه!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            builder.setCancelable(false);
            builder.show();
        }


        if (week==-1 & !superUser & G.preferences.getBoolean("WELLCOMED_CALC",false)){
            //preTest

            final AlertDialog.Builder builder =
                    new AlertDialog.Builder(CalcActivity.this, R.style.AppCompatAlertDialogStyle);

            builder.setTitle("قبل از شروع...");
            builder.setMessage("اول باید آزمون های قبل از شروع رو انجام بدی تا عملکردت بررسی بشه!");
            builder.setPositiveButton("خُب ...", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(CalcActivity.this, MemorizeActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    finish();
                }
            });
            builder.setNegativeButton("بیخیال !", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setCancelable(false);
            builder.show();

        }if(day!=0 & day%5==0 & !flag & !superUser & week!=12){

                final AlertDialog.Builder builder =
                        new AlertDialog.Builder(CalcActivity.this, R.style.AppCompatAlertDialogStyle);
                builder.setTitle("وقت آزمونه ...");
                builder.setMessage("این آزمونو انجام بدید تا عملکرد مغزتون رو بعد از آزمون های روزانه ببینید!");
                builder.setPositiveButton("خُب ...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(CalcActivity.this, MemorizeActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                        finish();
                    }
                });
            builder.setNegativeButton("بیخیال !", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                finish();
                }
            });
                builder.setCancelable(false);
                builder.show();

        }

            getRandomQues();

             startTimer();


            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if (editText.getText().toString() != null & editText.getText().toString().equals(String.valueOf(value))) {
                    //    Toast.makeText(getApplicationContext(), "درست", Toast.LENGTH_SHORT).show();
                        editText.setText("");
                        getRandomQues();
                    }

                    if (editText.getText().toString() != null & editText.getText().toString().length() >= String.valueOf(value).length()) {
                        Animation shake = AnimationUtils.loadAnimation(getApplication(), R.anim.shake);
                        editText.startAnimation(shake);
                        editText.setText("");
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {
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
    public void getRandomQues (){
        progressBar.setProgress(i);
        i++;

        if (i>numberOfQues) {
            Toast.makeText(getApplicationContext(),counterTime+" ثانیه :)",Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor editor = G.preferences.edit();
            if (!superUser) {
                editor.putInt("DAY", day + 1);
                editor.putBoolean("TEST_TIME", false);
                editor.putInt("SECOND_DAY" + (day + 1), counterTime);
            }
            editor.putBoolean("SUPER_USER",false);
            editor.commit();
            if (!superUser) {
                if (counterTime<=120 & counterTime>90) {
                    Toast.makeText(G.context, "مدال برنز گرفتید!",Toast.LENGTH_LONG).show();
                }if (counterTime<=90 & counterTime>60) {
                    Toast.makeText(G.context, "آفرین ، مدال نقره گرفتید",Toast.LENGTH_LONG).show();
                }if (counterTime<=60){
                    Toast.makeText(G.context, "آفرین ، مدال طلا گرفتید :)",Toast.LENGTH_LONG).show();
                }
            }
            finish();
        }
        while (true) {
            int number1 = (int) (Math.random() * 15);
            int number2 = (int) (Math.random() * 15);
            int randomSymbol = (int) (Math.random() * 3);
            String symbol ="+";
            switch (randomSymbol) {
                case 0:
                    symbol = "+";
                    value= number1 + number2;
                    break;
                case 1:
                    symbol = "-";
                    if (number1 < number2) {
                        continue;
                    }
                    value= number1 - number2;
                    break;
                case 2:
                    symbol = "×";
                    if(number1>10 & number2>10){
                        continue;
                    }
                    value= number1 * number2;
                    break;
            }
           setQuesText(String.valueOf(number1) + " " + symbol + " " + String.valueOf(number2));
            break;
        }

    }

    private void setQuesText (String ques){
        txt_ques.setText(ques);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.abc_fade_in);
        txt_ques.startAnimation(animation);
        txt_ques.setTypeface(G.number);
        txt_ques.setTextSize(TypedValue.COMPLEX_UNIT_DIP,40);
    }





/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mohasebe, menu);
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
