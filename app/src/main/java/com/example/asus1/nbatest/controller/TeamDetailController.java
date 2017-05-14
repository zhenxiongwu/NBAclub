package com.example.asus1.nbatest.controller;

import android.content.Context;

import com.example.asus1.nbatest.database.table.EntityModel;
import com.example.asus1.nbatest.database.table.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS1 on 2017/5/13.
 */

public class TeamDetailController extends DataController {


    public TeamDetailController(int itemLayoutID, String[] dateKeys, int[] textViewIDs) {
        super(itemLayoutID, dateKeys, textViewIDs);
    }

    private List<Team> teamDataSet = new ArrayList<>();

    @Override
    public void initEntitySet(List<EntityModel> entityModels) {
        super.initEntitySet(entityModels);
        teamDataSet.clear();
        for(EntityModel entityModel:entityModels){
            teamDataSet.add((Team)entityModel);
        }
    }

    public List<Team> getConvertedDataSet(){
        return teamDataSet;
    }

    @Override
    public void onItemClick(Context context, EntityModel entityModel, int position) {

    }
}
