package com.example.asus1.nbatest.controller;

import android.content.Context;

import com.example.asus1.nbatest.database.table.EntityModel;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public class CoachController extends DataController implements SearchController{


    public CoachController(int itemLayoutID, String[] dateKeys, int[] textViewIDs) {
        super(itemLayoutID, dateKeys, textViewIDs);
    }

    @Override
    public void onItemClick(Context context, EntityModel entityModel, int position) {

    }

    @Override
    public int loadMore() {
        return 0;
    }

    @Override
    public boolean startSearch(String content) {
        return false;
    }

    @Override
    public boolean isSearching() {
        return false;
    }

    @Override
    public void endSearch() {

    }
}
