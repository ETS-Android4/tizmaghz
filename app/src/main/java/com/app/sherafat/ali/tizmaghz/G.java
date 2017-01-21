package com.app.sherafat.ali.tizmaghz;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.preference.PreferenceManager;



public class G extends Application {

    public static Context       context;
    public static SharedPreferences preferences;
    public static final Handler HANDLER = new Handler();
    public static Typeface yekan;
    public static Typeface mitra;
    public static Typeface mehr;
    public static Typeface kamran;
    public static Typeface number;



    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        yekan=Typeface.createFromAsset(getAssets(), "fonts/yekan.ttf");
        mitra=Typeface.createFromAsset(getAssets(), "fonts/mitra.ttf");
        mehr=Typeface.createFromAsset(getAssets(), "fonts/mehr.ttf");
        kamran=Typeface.createFromAsset(getAssets(), "fonts/kamran.ttf");
        number=Typeface.createFromAsset(getAssets(), "fonts/comic.ttf");
    }
}