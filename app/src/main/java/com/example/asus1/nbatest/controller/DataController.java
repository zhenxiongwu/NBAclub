package com.example.asus1.nbatest.controller;

import com.example.asus1.nbatest.database.table.EntityModel;

import java.util.List;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public interface DataController {

    public abstract List<EntityModel> initEntitySet();
    public abstract List<EntityModel> loadMore();
    public abstract List<EntityModel> getSearchResult(String searchContent);
}
