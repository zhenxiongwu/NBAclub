package com.example.asus1.nbatest.database.table.model;

import com.example.asus1.nbatest.database.table.TableModel;

import org.litepal.crud.DataSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS1 on 2017/4/5.
 * The Player class is the model of table Player in LitePal
 * The column of the table Player is "name,season,age,teamAbbr,Lg,G,PTS" and a Team object
 */

public class Player extends DataSupport implements TableModel{

    public static String ID = "id";
    public static String NAME = "name";
    public static String SEASON = "season";
    public static String AGE = "age";
    public static String TEAMABBER = "teamAbbr";
    public static String LEAGUE = "league";
    public static String GAMES = "games";
    public static String POINTS = "points";
    public static String TEAM_ID = "team_id";

    private int id;
    private String name;
    private String season;
    private int age;
    private String teamAbbr;
    private String league;
    private int games;
    private int points;
    private int team_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeamAbbr() {
        return teamAbbr;
    }

    public void setTeamAbbr(String teamAbbr) {
        this.teamAbbr = teamAbbr;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }


    private Map<String , Object> playerMap;
    /**
     * mapping the player information
     * @return
     */
    @Override
    public Map<String, Object> mapping() {

        if(playerMap == null){
            playerMap = new HashMap<>();
            playerMap.put(Player.NAME,name);
            playerMap.put(Player.AGE,age);
            playerMap.put(Player.GAMES,games);
            playerMap.put(Player.LEAGUE,league);
            playerMap.put(Player.POINTS,points);
            playerMap.put(Player.SEASON,season);
            playerMap.put(Player.TEAMABBER,teamAbbr);
        }
        return playerMap;
    }
}
