package com.example.asus1.nbatest.controller;

/**
 * Created by ASUS1 on 2017/5/13.
 */

public interface SearchController {

    int loadMore();
    boolean startSearch(String content);
    boolean isSearching();
//    List<EntityModel> getSearchResult();
    void endSearch();

}
