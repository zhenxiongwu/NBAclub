package com.example.asus1.nbatest.database.table.model;

import android.os.Bundle;

import com.example.asus1.nbatest.database.table.EntityModel;

import org.litepal.crud.DataSupport;

/**
 * Created by ASUS1 on 2017/4/5.
 * The Player class is the model of table Player in LitePal
 * The column of the table Player is "name,season,age,teamAbbr,Lg,G,PTS" and a Team object
 */

public class Player extends DataSupport implements EntityModel {

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


    private Bundle bundle;
    /**
     * mapping the player information
     * put the attributes of the player into the bundle
     * @return Bundle
     */

    @Override
    public Bundle getBundle() {
        if(bundle == null){
            bundle = new Bundle();
            bundle.putInt(Player.ID, id);
            bundle.putString(Player.NAME,name);
            bundle.putInt(Player.AGE,age);
            bundle.putInt(Player.GAMES,games);
            bundle.putString(Player.LEAGUE,league);
            bundle.putInt(Player.POINTS,points);
            bundle.putString(Player.SEASON,season);
            bundle.putString(Player.TEAMABBER,teamAbbr);
            bundle.putInt(Player.TEAM_ID,team_id);
        }
        return bundle;
    }
}
