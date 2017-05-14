package com.example.asus1.nbatest.controller;

import android.content.Context;

import com.example.asus1.nbatest.activities.TeamDetailActivity;
import com.example.asus1.nbatest.database.table.EntityModel;
import com.example.asus1.nbatest.database.table.model.Team;
import com.example.asus1.nbatest.database.util.Selector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public class TeamController extends DataController implements SearchController{

    protected int currentItemsNum = 0;
    protected int loadItemsNumTimes = 20;

    protected boolean isSearching = false;
    protected String searchContent;

    public TeamController(int itemLayoutID, String[] dateKeys, int[] textViewIDs) {
        super(itemLayoutID, dateKeys, textViewIDs);
    }


    @Override
    public void initEntitySet(List<EntityModel> entityModels) {
        currentItemsNum = 0;
        isSearching = false;
        entitySet.clear();
        loadMore();
    }


    @Override
    public int loadMore() {
        List<Team> teams = null;
        if(isSearching){
            teams = Selector.fuzzySelectTeams(searchContent,loadItemsNumTimes,currentItemsNum);
        }
        else {
            teams = Selector.selectTeamsInOrder(loadItemsNumTimes, currentItemsNum);
        }
        currentItemsNum += teams.size();
        entitySet.addAll(teams);
        return teams.size();
    }

    @Override
    public boolean startSearch(String content) {
        isSearching = true;
        searchContent = content;
        entitySet.clear();
        currentItemsNum =0;
        return loadMore()!=0;
    }

    @Override
    public boolean isSearching() {
        return isSearching;
    }

    @Override
    public void endSearch() {
        initEntitySet(null);
        isSearching = false;
    }


    private List<EntityModel> getTeamDataSet(EntityModel entityModel){
        List<EntityModel> teamDataSet = new ArrayList<>();
        List<Team> teams = Selector.selectTeamByName(entityModel.getBundle().getString(Team.NAME));
        teamDataSet.addAll(teams);
        return teamDataSet;
    }

    @Override
    public void onItemClick(Context context, EntityModel entityModel, int position) {
        TeamDetailActivity.startActivity(context,getTeamDataSet(entityModel));
    }

}
