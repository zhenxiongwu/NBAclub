package com.example.asus1.nbatest.database.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.litepal.LitePal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by ASUS1 on 2017/4/15.
 */

public class DatabaseCreater {
    private static String DB_PATH = "/data/data/com.example.asus1.nbatest/databases/";
    private static String DB_NAME = "nba.db";

    private static String DB_PREFERENCE = "nba";
    private static String DB_EXISTS = "databaseExists";

    private Context context;

    public DatabaseCreater(Context context){
        this.context = context;
    }

    public void createDatabase() throws IOException{


        SharedPreferences sharedPreferences =
                context.getSharedPreferences(DB_PREFERENCE,context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("databaseExists",false))
            return;

        Log.i("zhenxiongwu", "checkDatabase is equal to false");

        /**
         * LitePal.getDatabase() get the initial database as nba.db in DB_PATH
         * and then copy the nba.db in assets folder into the nba.db in DB_PATH
         */
        LitePal.getDatabase();

        InputStream inputStream = context.getResources().getAssets().open("nba.db");
        String outFileName = DB_PATH + DB_NAME;

        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while((length=inputStream.read(buffer))>0){
            myOutput.write(buffer,0,length);
        }

        myOutput.flush();
        myOutput.close();
        inputStream.close();

        sharedPreferences.edit().putBoolean(DB_EXISTS,true).apply();
    }

}
