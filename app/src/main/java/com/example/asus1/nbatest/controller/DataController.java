package com.example.asus1.nbatest.controller;

import android.content.Context;

import com.example.asus1.nbatest.database.table.EntityModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public abstract class DataController{

    protected List<EntityModel> entitySet = new ArrayList<>();

    protected int itemLayoutID;
    protected int[] textViewIDs;
    protected String[] dataKeys;


    public void initEntitySet(List<EntityModel> entityModels){
        entitySet = entityModels;
    }

    public DataController(int itemLayoutID, String[] dateKeys, int[] textViewIDs){
        this.itemLayoutID = itemLayoutID;
        this.textViewIDs = textViewIDs;
        this.dataKeys = dateKeys;
    }

    public List<EntityModel> getEntitySet(){
        return entitySet;
    }

    public int getItemLayoutID(){
        return itemLayoutID;
    }

    public int[] getTextViewIDs(){
        return textViewIDs;
    }

    public String[] getDatakeys(){
        return dataKeys;
    }


    /**
     * The Controller is also the Listener of the view
     */
    public abstract void onItemClick(Context context,EntityModel entityModel, int position);
}
