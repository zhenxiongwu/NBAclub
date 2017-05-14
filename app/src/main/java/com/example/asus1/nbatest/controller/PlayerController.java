package com.example.asus1.nbatest.controller;

import android.content.Context;

import com.example.asus1.nbatest.activities.PlayerDetailActivity;
import com.example.asus1.nbatest.database.table.EntityModel;
import com.example.asus1.nbatest.database.table.model.Player;
import com.example.asus1.nbatest.database.util.Selector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public class PlayerController extends DataController implements SearchController{

    protected int currentItemsNum = 0;
    protected int loadItemsNumTimes = 20;

    protected boolean isSearching = false;
    protected String searchContent;

    public PlayerController(int itemLayoutID, String[] dateKeys, int[] textViewIDs) {
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
        List<Player> players = null;
        if (isSearching) {
            players = Selector.fuzzySelectPlayers(searchContent, loadItemsNumTimes, currentItemsNum);
        } else {
            players = Selector.selectPlayersInOrder(loadItemsNumTimes, currentItemsNum);
        }
        currentItemsNum += players.size();
        entitySet.addAll(players);
        return players.size();
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


    private List<EntityModel> getPlayerDataSet(String playerName) {
        List<Player> player_data_set = Selector.selectPlayerByName(playerName);
        List<EntityModel> entityModels = new ArrayList<>();
        entityModels.addAll(player_data_set);
        return entityModels;
    }

    @Override
    public void onItemClick(Context context, EntityModel entityModel, int position) {
        String player_name = entityModel.getBundle().getString(Player.NAME);
        PlayerDetailActivity.startActivity(context, player_name, getPlayerDataSet(player_name));
    }

}
