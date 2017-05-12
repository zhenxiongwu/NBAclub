package com.example.asus1.nbatest.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;

import com.example.asus1.nbatest.adapter.Fragment2PagerAdapter;
import com.example.asus1.nbatest.adapter.PlayerRecyclerViewAdapter;
import com.example.asus1.nbatest.database.table.EntityModel;
import com.example.asus1.nbatest.fragment.MyFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public class ViewController {

    private static String[] playersName = new String[]{
            "Lebron James",
            "James Hardon",
            "zhenxiongwu",
            "liuyubin",
            "zhouzebin",
            "wenghongbiao"
    };

    private static String[] tabTitles = new String[]{
            "球员",
            "球队",
            "教练",
            "球场"
    };

    public static PlayerRecyclerViewAdapter getPlayersAdapter(){

        return new PlayerRecyclerViewAdapter(new ArrayList<EntityModel>());
    }

    public static RecyclerView.Adapter getRecyclerViewAdapter(int page){
        switch(page) {
            case 1:
                return new PlayerRecyclerViewAdapter(new ArrayList<EntityModel>());
            case 2:
                return new PlayerRecyclerViewAdapter(new ArrayList<EntityModel>());
            case 3:
                return new PlayerRecyclerViewAdapter(new ArrayList<EntityModel>());
            case 4:
                return new PlayerRecyclerViewAdapter(new ArrayList<EntityModel>());
            default:
                return null;
        }
    }

    private static List<Fragment> fragments = new ArrayList<>();

    public static void creatFragment(){
        for(int i=1; i<5; i++){
            fragments.add(MyFragment.newInstance(i));
        }
    }

    public static Fragment2PagerAdapter createFragmentPagerAdapter(FragmentManager fm){
        creatFragment();
        return new Fragment2PagerAdapter(fm,fragments,Arrays.asList(tabTitles));
    }
}
