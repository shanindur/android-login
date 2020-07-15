package com.spacebar.login.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPreference {
    private static final String LOG_TAG = SharedPreference.class.getSimpleName();

    private Context context;
    private SharedPreferences pref;
    private static SharedPreference sharedPref;

    public static SharedPreference getInstance(Context context) {
        if (sharedPref == null) {
            sharedPref = new SharedPreference(context);
        }

        return sharedPref;
    }


    public SharedPreference(Context context) {
        this.context = context;
        pref = context.getSharedPreferences("APP", Context.MODE_PRIVATE);

    }

    public void setIsLogged(boolean login) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("IS_LOGGED", login);
        editor.commit();
    }

    public boolean getIsLogged() {
        return pref.getBoolean("IS_LOGGED", false);
    }

    public void clearIsLogged() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("IS_LOGGED", false);
        editor.commit();
    }


    public void clear_shared_pref() {

        pref.edit().clear().commit();

    }


}
