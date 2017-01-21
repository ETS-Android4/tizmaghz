package com.app.sherafat.ali.tizmaghz.app;

import android.app.Application;
import android.content.Context;

import com.app.sherafat.ali.tizmaghz.app.preferences.UserPrefs;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MyApp extends Application {

    private RefWatcher refWatcher;
    private UserPrefs userPrefs;
    private static MyApp instance;

    public RefWatcher getRefWatcher() {
        return refWatcher;
    }

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        instance = this;
        userPrefs = UserPrefs.getInstance(this);
        refWatcher = LeakCanary.install(this);

    }
}
