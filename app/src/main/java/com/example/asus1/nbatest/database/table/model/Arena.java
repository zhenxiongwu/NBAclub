package com.example.asus1.nbatest.database.table.model;

import android.os.Bundle;

import com.example.asus1.nbatest.database.table.EntityModel;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS1 on 2017/4/14.
 * The Arena class is the model of table Arena in LitePal
 * The column of the table Player is "name,team,startToEnd,location,capacity"
 */

public class Arena extends DataSupport implements EntityModel {

    public static String ID = "id";
    public static String NAME = "name";
    public static String TEAM = "team";
    public static String START_TO_END = "start2end";
    public static String LOCATION = "location";
    public static String CAPACITY = "capacity";

    private int id;
    private String name;
    private String team;
    private String startToEnd;
    private String location;
    private int capacity;
    private List<Team> teamList = new ArrayList<>();

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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getStartToEnd() {
        return startToEnd;
    }

    public void setStartToEnd(String startToEnd) {
        this.startToEnd = startToEnd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }


    private Bundle bundle;

    /**
     * mapping the arena information
     * put the attributes of the arena into the bundle
     *
     * @return
     */
    @Override
    public Bundle getBundle() {
        if (bundle == null) {
            bundle = new Bundle();
            bundle.putInt(Arena.ID, id);
            bundle.putString(Arena.NAME, name);
            bundle.putString(Arena.TEAM, team);
            bundle.putString(Arena.START_TO_END, startToEnd);
            bundle.putString(Arena.LOCATION, location);
            bundle.putInt(Arena.CAPACITY, capacity);
        }
        return bundle;
    }
}
