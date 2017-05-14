package com.example.asus1.nbatest.adapter.pagerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by ASUS1 on 2017/5/11.
 */

public class Fragment2PagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> mFragments;
    List<String> mTitles;

    public Fragment2PagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {

        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        Log.i("zhenxiongwu","tab count : "+mFragments.size());
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.i("zhenxiongwu","getTitle in position : "+ position);
        return mTitles.get(position);
//        return super.getPageTitle(position);
    }
}
