package com.example.asus1.nbatest.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.adapter.Fragment2PagerAdapter;
import com.example.asus1.nbatest.controller.ViewController;

public class HomeActivity extends AppCompatActivity {

    private Fragment2PagerAdapter mFragment2PagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mTabLayout = (TabLayout)findViewById(R.id.tablayout);

        mFragment2PagerAdapter = ViewController.createFragmentPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mFragment2PagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
