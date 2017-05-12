package com.example.asus1.nbatest.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.database.util.DatabaseCreater;

import java.io.IOException;

public class LaunchActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;
    ImageView imageView;
    Thread thread;

    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private static String READY ="ready";
    private static String PLAYBACK = "playback";
    private static boolean END = false;

    private static final int INTERVAL_TIME = 3000;  //3 second

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_launch);

        END = false;

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchActivity.this, FunctionActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imageView.setClickable(false);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction(READY);
        intentFilter.addAction(PLAYBACK);
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);

        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                DatabaseCreater databaseCreater = new DatabaseCreater(LaunchActivity.this);
                try {
                    databaseCreater.createDatabase();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(READY);
                localBroadcastManager.sendBroadcast(intent);
                while (!END) {
                    try {
                        Thread.sleep(INTERVAL_TIME);
                        intent.setAction(PLAYBACK);
                        localBroadcastManager.sendBroadcast(intent);
                        Log.i("zhenxiongwu","running");
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        localBroadcastManager.unregisterReceiver(localReceiver);
        END = true;
        super.onDestroy();
    }

    private class LocalReceiver extends BroadcastReceiver{

        int[] pictureId = {R.drawable.nba1, R.drawable.nab2, R.drawable.nba3};
        int index = 0;

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction()==READY) {
                progressBar.setVisibility(View.GONE);
                imageView.setClickable(true);
                textView.setVisibility(View.VISIBLE);
            }else{
                index = index%3;
                imageView.setImageResource(pictureId[index]);
                index++;
            }
        }
    }
}
