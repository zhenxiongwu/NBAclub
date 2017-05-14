package com.example.asus1.nbatest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.adapter.recyclerview.RecyclerViewAdapter;
import com.example.asus1.nbatest.controller.ControllerManager;
import com.example.asus1.nbatest.controller.DataController;
import com.example.asus1.nbatest.database.table.EntityModel;
import com.example.asus1.nbatest.database.table.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerDetailActivity extends AppCompatActivity {

    private static String PLAYER_DATA_SET = "player_data_set";

    private DataController playerDetailController;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private TextView player_textView_name;

    private String playerName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.player_detail_toolbar);
        setSupportActionBar(toolbar);

        player_textView_name = (TextView)findViewById(R.id.player_detail_textView_name);
        playerName = getIntent().getStringExtra(Player.NAME);
        player_textView_name.setText(playerName);

        playerDetailController = ControllerManager.
                getController(ControllerManager.PLAYER_DETAIL_CONTROLLER);

        recyclerView = (RecyclerView)findViewById(R.id.player_detail_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new RecyclerViewAdapter(playerDetailController);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.player_statistics_icon:
                List<Bundle> bundles = new ArrayList<>();
                List<EntityModel> entityModels = playerDetailController.getEntitySet();
                for(EntityModel entityModel : entityModels){
                    bundles.add(entityModel.getBundle());
                }
                StatisticsActivity.actionStart(this,bundles
                        ,StatisticsActivity.PLAYER_STATISTICS,Player.POINTS,
                        Player.GAMES,Player.AVERAGE,Player.SEASON);
                break;
            default:
        }
        return true;
    }

    public static void startActivity(Context context,String playerNmae, List<EntityModel> playerDataSet){
        Intent intent = new Intent(context, PlayerDetailActivity.class);
        DataController playerDetailController = ControllerManager.
                        getController(ControllerManager.PLAYER_DETAIL_CONTROLLER);

        playerDetailController.initEntitySet(playerDataSet);

        intent.putExtra(Player.NAME,playerNmae);
        Log.i("zhenxiongwu","playerDataset size "+playerDataSet.size());
        context.startActivity(intent);
    }
}
