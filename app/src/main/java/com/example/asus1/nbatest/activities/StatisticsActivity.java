package com.example.asus1.nbatest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.fragment.PlayerGamesStatisticsFragment;
import com.example.asus1.nbatest.fragment.TeamWinTimesFragment;

import java.io.Serializable;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {
    
    public static final int TEAM_STATISTICS = 0;

    public static final int PLAYER_STATISTICS = 1;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        intent = getIntent();
        if (intent.getIntExtra("type", 0) == TEAM_STATISTICS) {
            replaceFragment(new TeamWinTimesFragment());
        } else if (intent.getIntExtra("type", 0) == PLAYER_STATISTICS) {
            replaceFragment(new PlayerGamesStatisticsFragment());
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    /**
     *
     * @param context 启动该Activity的Context
     * @param bundles 包含总出场、总得分、平均分、赛季信息
     * @param type 启动本Activity的类型
     * @param keys Bundle中的键的名称
     */
    public static void actionStart(Context context, List<Bundle> bundles, int type, String... keys) {
        Intent intent = new Intent(context, StatisticsActivity.class);
        intent.putExtra("bundles", (Serializable) bundles);
        intent.putExtra("type", type);

        Bundle bundle = new Bundle();
        bundle.putSerializable("keys", keys);
        intent.putExtras(bundle);

        context.startActivity(intent);
    }
}
