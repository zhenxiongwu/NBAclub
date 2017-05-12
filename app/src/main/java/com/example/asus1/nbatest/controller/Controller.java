package com.example.asus1.nbatest.controller;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.adapter.Fragment2PagerAdapter;
import com.example.asus1.nbatest.adapter.PlayerRecyclerViewAdapter;
import com.example.asus1.nbatest.application.NBAApplication;
import com.example.asus1.nbatest.database.table.EntityModel;
import com.example.asus1.nbatest.database.table.model.Player;
import com.example.asus1.nbatest.database.util.Selector;
import com.example.asus1.nbatest.fragment.MyFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS1 on 2017/4/16.
 */

public class Controller {

    /**
     * In version 1.0 show the top-twenty players in 2013-2014 season as default
     * @return
     */
    public static List<Player> getDefaultPlayers(){
        return Selector.getPlayersInSeason("2013-2014",20);
    }


    public static ArrayList<Map<String,Object>> getMappingPlayerList(List<Player> playerList){
        if(playerList==null)
            return null;
        ArrayList<Map<String,Object>> mappingPlayerList = new ArrayList<>();
        for(Player player:playerList){
//            mappingPlayerList.add(player.mapping());
        }
        return mappingPlayerList;
    }


    public static void showDefaultPlayers(Context context, ListView listView){
    }

    public static void showDefaultTeams(){
    }

    public static void showDefaultAreans(){
    }



    private static String[] playersName = new String[]{
            "Lebron James",
            "James Hardon",
            "zhenxiongwu",
            "liuyubin",
            "zhouzebin",
            "wenghongbiao"
    };

    private static String[] tabTitles = NBAApplication.getContext().
            getResources().getStringArray(R.array.tab_title);

    public static PlayerRecyclerViewAdapter getPlayersAdapter(){
        return new PlayerRecyclerViewAdapter(new ArrayList<EntityModel>());
    }

    public static RecyclerView.Adapter getRecyclerViewAdapter(int page){
        switch(page) {
            case 1:
                return new PlayerRecyclerViewAdapter(new ArrayList<EntityModel>());
            case 2:
                return new PlayerRecyclerViewAdapter(new ArrayList<EntityModel>());
            case 3:
                return new PlayerRecyclerViewAdapter(new ArrayList<EntityModel>());
            case 4:
                return new PlayerRecyclerViewAdapter(new ArrayList<EntityModel>());
            default:
                return null;
        }
    }

    private static List<Fragment> fragments = new ArrayList<>();

    public static void creatFragment(){
        for(int i=1; i<5; i++){
            fragments.add(MyFragment.newInstance(i));
        }
    }

    public static Fragment2PagerAdapter createFragmentPagerAdapter(FragmentManager fm){
        creatFragment();
        return new Fragment2PagerAdapter(fm,fragments,Arrays.asList(tabTitles));
    }
}
