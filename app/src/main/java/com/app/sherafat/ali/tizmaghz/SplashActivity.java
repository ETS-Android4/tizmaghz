package com.app.sherafat.ali.tizmaghz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.app.sherafat.ali.tizmaghz.main.MainActivity;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        String[] splash = {"یه مغز تیز با تیز مغز!", "مغزتو اینجا تیز کن !"};
        TextView txtSplash = (TextView) findViewById(R.id.txtSplash);
        int i = (int) (Math.random()*2);
        txtSplash.setText(splash[i]);
        txtSplash.setTypeface(G.kamran);
        txtSplash.setTextColor(Color.parseColor("#414338"));

        G.HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, 3200);


    }
}
