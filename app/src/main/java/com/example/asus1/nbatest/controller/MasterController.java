package com.example.asus1.nbatest.controller;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.asus1.nbatest.activities.HomeActivity;
import com.example.asus1.nbatest.adapter.pagerview.Fragment2PagerAdapter;
import com.example.asus1.nbatest.adapter.recyclerview.RecyclerViewAdapter;
import com.example.asus1.nbatest.fragment.PagerViewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public class MasterController {

    private MasterController() {
    }

    private static DataController playerController;
    private static DataController teamController;
    private static DataController coachController;
    private static DataController arenaController;

    private static boolean HAVE_INITIALIZED = false;
    public static boolean isInitialized(){
        return HAVE_INITIALIZED;
    }

    /**
     * Initialize the data that will be displayed in the home page
     */
    public static void initData() {
        if(HAVE_INITIALIZED) return;
        playerController = ControllerManager.getController(ControllerManager.PLAYERS_CONTROLLER);
        teamController = ControllerManager.getController(ControllerManager.TEAMS_CONTROLLER);
//        coachController = ControllerManager.getController(ControllerManager.COACHES_CONTROLLER);
        arenaController = ControllerManager.getController(ControllerManager.ARENAS_CONTROLLER);

        playerController.initEntitySet(null);
        teamController.initEntitySet(null);
//        coachController.initEntitySet(null);
        arenaController.initEntitySet(null);

        createFragments();
        HAVE_INITIALIZED = true;
    }


    private static List<String> tabTitles = new ArrayList<>();

    private static List<RecyclerViewAdapter> recyclerViewAdapters =
            new ArrayList<>();

    private static List<Fragment> fragments = new ArrayList<>();


    private static void createFragments() {


        RecyclerViewAdapter playerRecyclerViewAdapter =
                new RecyclerViewAdapter(playerController);

        tabTitles.add("球员");
        recyclerViewAdapters.add(playerRecyclerViewAdapter);


        RecyclerViewAdapter teamRecyclerViewAdapter =
                new RecyclerViewAdapter(teamController);

        tabTitles.add("球队");
        recyclerViewAdapters.add(teamRecyclerViewAdapter);


        RecyclerViewAdapter arenaRecyclerViewAdapter =
                new RecyclerViewAdapter(arenaController);

        tabTitles.add("球场");
        recyclerViewAdapters.add(arenaRecyclerViewAdapter);


        for (int i = 0; i < tabTitles.size(); i++) {
            fragments.add(PagerViewFragment.newInstance(i));
        }
    }

    public static RecyclerView.Adapter getRecyclerViewAdapter(int page) {
        return recyclerViewAdapters.get(page);
    }

    public static Fragment2PagerAdapter createFragmentPagerAdapter(FragmentManager fm) {
        return new Fragment2PagerAdapter(fm, fragments, tabTitles);
    }


    private static int current_page = 0;

    public static void pageChange(int page) {
        current_page = page;
    }

    public static int getCurrentPage() {
        return current_page;
    }

    public static boolean querySubmit(String regex, int page){
        boolean queryResult = false;
        switch (page) {
            case 0:
                queryResult = ((SearchController) playerController).startSearch(regex);
                recyclerViewAdapters.get(0).notifyDataSetChanged();
                return queryResult;
            case 1:
                queryResult = ((SearchController) teamController).startSearch(regex);
                recyclerViewAdapters.get(1).notifyDataSetChanged();
                return queryResult;
            case 2:
                queryResult = ((SearchController) arenaController).startSearch(regex);
                recyclerViewAdapters.get(2).notifyDataSetChanged();
                return queryResult;
            default:
                Log.e("zhenxiongwu", "invalid page number");
        }
        return false;
    }

    public static void closeQuery(){
        if(((SearchController) playerController).isSearching()) {
            ((SearchController) playerController).endSearch();
            recyclerViewAdapters.get(0).notifyDataSetChanged();
        }
        if(((SearchController) teamController).isSearching()) {
            ((SearchController) teamController).endSearch();
            recyclerViewAdapters.get(1).notifyDataSetChanged();
        }
        if(((SearchController) arenaController).isSearching()){
            ((SearchController) arenaController).endSearch();
            recyclerViewAdapters.get(2).notifyDataSetChanged();
        }
    }


    private static Toast toast;

    public static void loadMore(Activity activity, int page, int position) {
        HomeActivity homeActivity = (HomeActivity) activity;
        homeActivity.startProgressBar();
        for(int i =0 ; i<10000000;i++);
        int insertCount = 0;
        switch (page) {
            case 0:
                insertCount = ((SearchController) playerController).loadMore();
                break;
            case 1:
                insertCount = ((SearchController) teamController).loadMore();
                break;
            case 2:
                insertCount = ((SearchController) arenaController).loadMore();
                break;
            default:
                Log.e("zhenxiongwu", "invalid page number");
        }
        if (insertCount != 0)
            recyclerViewAdapters.get(page).notifyItemRangeInserted(position, insertCount);
        else{
            if(toast == null)
                toast = Toast.makeText(homeActivity,"无更多",Toast.LENGTH_SHORT);
            toast.show();
        }
        homeActivity.entProgressBar();
    }
}
