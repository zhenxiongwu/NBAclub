package com.example.asus1.nbatest.application;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public class NBAApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePal.initialize(context);
    }

    public static Context getContext(){
        return context;
    }
}
