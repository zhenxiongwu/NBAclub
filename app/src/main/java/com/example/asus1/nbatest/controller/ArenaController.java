package com.example.asus1.nbatest.controller;

import android.content.Context;

import com.example.asus1.nbatest.database.table.EntityModel;
import com.example.asus1.nbatest.database.table.model.Arena;
import com.example.asus1.nbatest.database.util.Selector;

import java.util.List;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public class ArenaController extends DataController implements SearchController{

    protected int currentItemsNum = 0;
    protected int loadItemsNumTimes = 20;

    protected boolean isSearching = false;
    protected String searchContent;

    public ArenaController(int itemLayoutID, String[] dateKeys, int[] textViewIDs) {
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
        List<Arena> arenas = null;
        if(isSearching){
            arenas = Selector.fuzzySelectArenas(searchContent,loadItemsNumTimes,currentItemsNum);
        }
        else {
            arenas = Selector.selectArenasInOrder(loadItemsNumTimes, currentItemsNum);
        }
        currentItemsNum += arenas.size();
        entitySet.addAll(arenas);
        return arenas.size();
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

    @Override
    public void onItemClick(Context context, EntityModel entityModel, int position) {

    }

}
