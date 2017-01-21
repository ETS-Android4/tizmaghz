package com.app.sherafat.ali.tizmaghz.app.preferences;

import android.content.Context;

import com.app.sherafat.ali.tizmaghz.app.utils.TinyDB;

import java.io.Serializable;
import java.lang.ref.WeakReference;


public class UserPrefs implements Serializable{
    private Context context;
    private TinyDB tinyDB;

    private UserPrefs(Context context) {
        this.context = context;
        tinyDB = TinyDB.getInstance(context);
    }

    private static WeakReference<UserPrefs> instance;

    public static UserPrefs getInstance(Context context) {
        if (instance == null || instance.get() == null) {
            instance = new WeakReference<>(new UserPrefs(context));
        }
        return instance.get();
    }

}
