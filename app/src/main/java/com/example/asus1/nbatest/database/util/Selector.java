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

    public static List<Player> fuzzySelectPlayers(String regex){
        return DataSupport.where("name LIKE ? OR name LIKE ?",regex+" %","% "+regex).find(Player.class);
    }

    public static List<Player> selectPlayers(String... conditions) {
        return DataSupport.where(conditions).find(Player.class);
    }

    public static List<Team> selectTeams(String... conditions) {
        return DataSupport.where(conditions).find(Team.class);
    }

    public static List<Arena> selectArenas(String... conditions) {
        return DataSupport.where(conditions).find(Arena.class);
    }

    public static Player selectFirstPlayer(String... conditions) {
        return DataSupport.where(conditions).findFirst(Player.class);
    }

    public static Team selectFirstTeam(String... conditions) {
        return DataSupport.where(conditions).findFirst(Team.class);
    }

    public static Arena selectFirstArena(String... conditions) {
        return DataSupport.where(conditions).findFirst(Arena.class);
    }

    public static Player selectPlayerById(int id) {
        return DataSupport.find(Player.class, id);
    }

    public static Team selectTeamById(int id) {
        return DataSupport.find(Team.class, id);
    }

    public static Arena selectArenaById(int id) {
        return DataSupport.find(Arena.class, id);
    }

    public static List<Player> selectPlayerByName(String name) {
        String[] conditions = {"name = ?", name};
        return selectPlayers(conditions);
    }

    public static List<Team> selectTeamByName(String name) {
        String[] conditions = {"name = ?", name,};
        return selectTeams(conditions);
    }

    public static List<Arena> selectArenaByName(String name) {
        String[] conditions = {"name = ?", name};
        return selectArenas(conditions);
    }


    /**
     * Player specific select
     */

    public static int selectPlayerPoints(String name, String season) {
        String[] conditions = {"name = ? and season = ?", name, season};
        Player player = selectFirstPlayer(conditions);
        if (player != null)
            return player.getPoints();
        else
            return -1;
    }


    public static List<Player> getPlayersInSeason(String season, int rank) {
        String[] conditions = {"season=?", season};
        List<Player> playerList = DataSupport.where(conditions).order(Player.POINTS + " desc").find(Player.class);
        return playerList.subList(0, rank);
    }


    /**
     * Team specific select
     */

    public static int selectTeamChampionships(String teamName) {
        Team team = selectFirstTeam("name = ?", teamName);
        if (team != null)
            return team.getChampionships();
        else
            return -1;
    }


    /**
     * Arena specific select
     */
    public static String selectArenaTeam(String arenaName) {
        Arena arena = selectFirstArena("name = ?", arenaName);
        if (arena != null)
            return arena.getTeam();
        else
            return null;
    }
}
