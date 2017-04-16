package com.example.asus1.nbatest.controller;

import android.content.Context;
import android.widget.ListView;

import com.example.asus1.nbatest.database.table.model.Player;
import com.example.asus1.nbatest.database.util.Selector;

import java.util.ArrayList;
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
        return Selector.getPlayers("2013-2014",20);
    }


    public static ArrayList<Map<String,Object>> getMappingPlayerList(List<Player> playerList){
        if(playerList==null)
            return null;
        ArrayList<Map<String,Object>> mappingPlayerList = new ArrayList<>();
        for(Player player:playerList){
            mappingPlayerList.add(player.mapping());
        }
        return mappingPlayerList;
    }


    public static void showDefaultPlayers(Context context, ListView listView){
    }

    public static void showDefaultTeams(){
    }

    public static void showDefaultAreans(){
    }

}
