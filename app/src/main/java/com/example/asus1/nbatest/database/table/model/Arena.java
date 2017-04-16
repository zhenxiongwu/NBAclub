package com.example.asus1.nbatest.database.table.model;

import com.example.asus1.nbatest.database.table.TableModel;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS1 on 2017/4/14.
 * The Arena class is the model of table Arena in LitePal
 * The column of the table Player is "name,team,startToEnd,location,capacity"
 */

public class Arena extends DataSupport implements TableModel{
//    ArenaTeam,ArenaStart-End,Arena,ArenaLocation,ArenaCapacity
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

    /**
     * mapping the arena information
     * @return
     */
    @Override
    public Map<String, Object> mapping() {
        return null;
    }
}
