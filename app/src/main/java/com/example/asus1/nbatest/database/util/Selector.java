package com.example.asus1.nbatest.database.util;

import com.example.asus1.nbatest.database.table.model.Arena;
import com.example.asus1.nbatest.database.table.model.Player;
import com.example.asus1.nbatest.database.table.model.Team;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by ASUS1 on 2017/4/15.
 * The Selector provides some interface methods to select in table Player,Team and Arena
 * ,which make the select operations more convenient
 */

public class Selector {

    public static List<Player> selectPlayers(String...conditions){
        return DataSupport.where(conditions).find(Player.class);
    }

    public static List<Team> selectTeams(String...conditions){
        return DataSupport.where(conditions).find(Team.class);
    }

    public static List<Arena> selectArenas(String...conditions){
        return DataSupport.where(conditions).find(Arena.class);
    }

    public static Player selectPlayerById(int id){
        return DataSupport.find(Player.class,id);
    }

    public static Team selectTeamById(int id){
        return DataSupport.find(Team.class,id);
    }

    public static Arena selectArenaById(int id){
        return DataSupport.find(Arena.class,id);
    }

    public static List<Player> selectPlayerByName(String name){
        String[] conditions = {"name = ?",name};
        return selectPlayers(conditions);
    }

    public static List<Team> selectTeamByName(String name){
        String[] conditions = {"name = ?",name,};
        return selectTeams(conditions);
    }

    public static List<Arena> selectArenaByName(String name){
        String[] conditions = {"name = ?",name};
        return selectArenas(conditions);
    }


    public static List<Player> getPlayers(String season, int rank){
        String[] conditions = {"season=?",season};
        List<Player> playerList = DataSupport.where(conditions).order(Player.POINTS+" desc").find(Player.class);
        return playerList.subList(0,rank);
    }
}
