package com.example.asus1.nbatest.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.controller.Controller;

import java.util.ArrayList;
import java.util.Map;

public class FunctionActivity extends AppCompatActivity {

    ListView listView;
    SearchView searchView;
    Button button_search;
    ImageButton button_player;
    ImageButton button_team;
    ImageButton button_coach;
    ImageButton button_arena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("zhenxiongwu","onCreate");
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_function);

        listView = (ListView) findViewById(R.id.listView);
        searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Log.i("zhenxiongwu","searchView onClose");
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("zhenxiongwu","on query text submit");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("zhenxiongwu","on query text change");
                return false;
            }
        });

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("zhenxiongwu","onSearchClick");
            }
        });

        button_search = (Button) findViewById(R.id.button_search);
        button_player = (ImageButton) findViewById(R.id.button_player);
        button_team = (ImageButton) findViewById(R.id.button_team);
        button_coach = (ImageButton) findViewById(R.id.button_coach);
        button_arena = (ImageButton) findViewById(R.id.button_arena);

        ArrayList<Map<String, Object>> mappingPlayerList =
                Controller.getMappingPlayerList(Controller.getDefaultPlayers());

/*        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this, mappingPlayerList,
                R.layout.player_list_item,
                new String[]{Player.NAME, Player.SEASON, Player.AGE, Player.TEAMABBER,
                        Player.LEAGUE, Player.GAMES, Player.POINTS},
                new int[]{R.id.list_item_textView_player, R.id.list_item_textView_season,
                        R.id.list_item_textView_age, R.id.list_item_textView_teamAbbr,
                        R.id.list_item_textView_league, R.id.list_item_textView_games,
                        R.id.list_item_textView_points}
        );

        listView.setAdapter(mSimpleAdapter);//为ListView绑定适配器*/

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("zhenxiongwu","onConfigurationChanged");
    }
}
