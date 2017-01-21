package com.app.sherafat.ali.tizmaghz.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.sherafat.ali.tizmaghz.CalcActivity;
import com.app.sherafat.ali.tizmaghz.R;
import com.app.sherafat.ali.tizmaghz.app.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private  static  long  back_pressed = 0;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*

        day=G.preferences.getInt("DAY",0);

        if (!(G.preferences.getBoolean("WELLCOMED_MAIN",false))){

            final AlertDialog.Builder builder =
                    new AlertDialog.Builder(Main.this, R.style.AppCompatAlertDialogStyle);
            builder.setTitle("به تیزمغز خوش اومدی :)");
            builder.setMessage("برای اینکه بیشتر با نرم افزار آشنا بشی و بدونی که قراره تو این شصت روز چه اتفاق هایی بیفته تیزمغز رو فشار بده !");
            builder.setPositiveButton("  تیز مغز  ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = G.preferences.edit();
                    editor.putBoolean("WELLCOMED_MAIN",true);
                    editor.putBoolean("HELP",false);
                    editor.commit();
                    Intent intent = new Intent(Main.this,tizMaghz.class);
                    startActivity(intent);
                    dialog.dismiss();
                }
            });

            builder.setCancelable(false);
            builder.show();
        }

// slide start
        listView = (ListView) findViewById(R.id.lstMenuItems);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
      // WIDTH OF DRAWER
        int width = getResources().getDisplayMetrics().widthPixels/4*3;
        DrawerLayout.LayoutParams params = (android.support.v4.widget.DrawerLayout.LayoutParams) listView.getLayoutParams();
        params.width = width;
        listView.setLayoutParams(params);
    // END WIDTH
        addDrawerItems();
        setupDrawer();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
//slide end

*/

        ImageView imgStart = (ImageView) findViewById(R.id.imgStart);
        imgStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CalcActivity.class));
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
           // drawerLayout.openDrawer(Gravity.LEFT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
/*
        if (!(G.preferences.getBoolean("STAR",false)) & day >2){
            final AlertDialog.Builder builder =
                    new AlertDialog.Builder(Main.this, R.style.AppCompatAlertDialogStyle);

            builder.setTitle("ستاره و نظر ...");
            builder.setMessage("میخای یه نظر با چند تا ستاره ی تپل به تیز مغز بدی ؟");
            builder.setPositiveButton(" بله :) ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String url = "bazaar://details?id=" + getPackageName();
                    Intent comment = new Intent(Intent.ACTION_EDIT);
                    try {
                        comment.setData(Uri.parse(url));
                        startActivity(comment);
                        SharedPreferences.Editor editor = G.preferences.edit();
                        editor.putBoolean("STAR", true);
                        editor.commit();
                    } catch (Exception e) {
                        comment.setData(Uri.parse("http://cafebazaar.ir/"));
                        startActivity(comment);
                    }
                }
            });
            builder.setNegativeButton("بیخیال!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                finish();
                }
            });
            builder.setCancelable(true);
            builder.show();
        }
        */
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            AppExit();
        }
        else {
            if (day!=3) {
                Toast.makeText(this, "برای خروج کلید بازگشت را مجددا فشار دهید", Toast.LENGTH_SHORT).show();
            }
        back_pressed =  System.currentTimeMillis();
        }
    }

    public void AppExit(){
        MainActivity.this.finish();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MainActivity.this.startActivity(intent);

        System.exit(0);
    }

}
