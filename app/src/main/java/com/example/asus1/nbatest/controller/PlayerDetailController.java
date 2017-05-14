package com.example.asus1.nbatest.controller;

import android.content.Context;

import com.example.asus1.nbatest.database.table.EntityModel;

import java.util.List;

/**
 * Created by ASUS1 on 2017/5/13.
 */

public class PlayerDetailController extends DataController {

    public PlayerDetailController(int itemLayoutID, String[] dateKeys, int[] textViewIDs) {
        super(itemLayoutID, dateKeys, textViewIDs);
    }

    @Override
    public void initEntitySet(List<EntityModel> entityModels) {}


    @Override
    public void onItemClick(Context context, EntityModel entityModel, int position) {

    }

}
