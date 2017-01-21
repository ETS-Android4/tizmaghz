package com.app.sherafat.ali.tizmaghz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import android.widget.Toast;

public class MemorizeActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;
    TextView textView14;
    TextView textView15;
    TextView textView16;
    TextView textView17;
    TextView textView18;
    TextView textView19;
    TextView textView20;
    TextView textView21;
    TextView textView22;
    TextView textView23;
    TextView textView24;
    TextView textView25;
    TextView textView26;
    TextView textView27;
    TextView textView28;
    TextView textView29;
    TextView textView30;
    TextView textTimer;
    public int i;
    int day;
    boolean superUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorize);

        TextView txtMemorizeTitle = (TextView) findViewById(R.id.txtMemorizeTitle);
        txtMemorizeTitle.setText("آزمون حفظ لغت");
        txtMemorizeTitle.setTypeface(G.yekan);


        superUser = G.preferences.getBoolean("SUPER_USER",false);
if (!superUser) {
    day = G.preferences.getInt("DAY", 0);
}else {
    try {
    while (true){
        day= (int) (Math.random()*61);
        if (day%5==0) {
            break;
        }
    }

    }catch (Exception e){
        day=55;
    }

}


        int resourceTextsID = R.array.dayPre;
        switch (day){
            case 0:
                resourceTextsID=R.array.dayPre;
                break;
            case 5:
                resourceTextsID=R.array.day5;
                break;
            case 10:
                resourceTextsID=R.array.day10;
                break;
            case 15:
                resourceTextsID=R.array.day15;
                break;
            case 20:
                resourceTextsID=R.array.day20;
                break;
            case 25:
                resourceTextsID=R.array.day25;
                break;
            case 30:
                resourceTextsID=R.array.day30;
                break;
            case 35:
                resourceTextsID=R.array.day35;
                break;
            case 40:
                resourceTextsID=R.array.day40;
                break;
            case 45:
                resourceTextsID=R.array.day45;
                break;
            case 50:
                resourceTextsID=R.array.day50;
                break;
            case 55:
                resourceTextsID=R.array.day55;
                break;
            case 60:
                resourceTextsID=R.array.day60;
                break;
        }
        final String[] texts = getResources().getStringArray(resourceTextsID);

// Timer start
        textTimer = (TextView) findViewById(R.id.textTimer);
        new CountDownTimer(120000, 1000) {

            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished / 1000 <= 15) {
                    textTimer.setTextColor(Color.parseColor("#7f1010"));
                }
                textTimer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textTimer.setText("وقت تموم شد!");
                Intent intent = new Intent(MemorizeActivity.this, TestMemorize.class);
                Bundle bundle = new Bundle();
                bundle.putStringArray("ARRAY", texts);
                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                MemorizeActivity.this.finish();
            }
        }
                .start();
 // Timer End

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 = (TextView) findViewById(R.id.textView15);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView17 = (TextView) findViewById(R.id.textView17);
        textView18 = (TextView) findViewById(R.id.textView18);
        textView19 = (TextView) findViewById(R.id.textView19);
        textView20 = (TextView) findViewById(R.id.textView20);
        textView21 = (TextView) findViewById(R.id.textView21);
        textView22 = (TextView) findViewById(R.id.textView22);
        textView23 = (TextView) findViewById(R.id.textView23);
        textView24 = (TextView) findViewById(R.id.textView24);
        textView25 = (TextView) findViewById(R.id.textView25);
        textView26 = (TextView) findViewById(R.id.textView26);
        textView27 = (TextView) findViewById(R.id.textView27);
        textView28 = (TextView) findViewById(R.id.textView28);
        textView29 = (TextView) findViewById(R.id.textView29);
        textView30 = (TextView) findViewById(R.id.textView30);


        final TextView[] txtArrays = {textView1, textView2, textView3, textView4, textView5,
                textView6, textView7, textView8, textView9, textView10, textView11, textView12
                , textView13, textView14, textView15, textView16, textView17, textView18, textView19
                , textView20, textView21, textView22, textView23, textView24, textView25, textView26,
                textView27, textView28, textView29, textView30};


        new Thread(new Runnable() {

            public void run() {
                for (i = -1; i < 29; i++) {
                    try {
                        Thread.sleep(90);
                        runOnUiThread(new Runnable() {
                            /*
                            final Animation fadeIn = new AlphaAnimation(0, 1);
                            fadeIn.setInterpolator(new LinearInterpolator());
                            fadeIn.setDuration(1500);
*/
                            @Override
                            public void run() {
                                Animation fadeIn = new AlphaAnimation(0, 1);
                                fadeIn.setInterpolator(new LinearInterpolator());
                                fadeIn.setDuration(1500);
                                txtArrays[i].setAnimation(fadeIn);
                                txtArrays[i].setText(texts[i]);
                                txtArrays[i].setTypeface(G.mitra);
                                txtArrays[i].setTextSize(TypedValue.COMPLEX_UNIT_DIP,17);
                            }
                        });
                    } catch (InterruptedException e) {
                        Toast.makeText(G.context,"خطایی رخ داد!!!",Toast.LENGTH_LONG).show();
                    }
                }

            }
        }).start();

    }
}
