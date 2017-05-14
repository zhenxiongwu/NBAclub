package com.example.asus1.nbatest.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.adapter.pagerview.Fragment2PagerAdapter;
import com.example.asus1.nbatest.controller.MasterController;

public class HomeActivity extends AppCompatActivity {

    private SearchView searchView;

    private Fragment2PagerAdapter mFragment2PagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchView = (SearchView)findViewById(R.id.home_page_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(!MasterController.querySubmit(query,mViewPager.getCurrentItem())){
                    Toast.makeText(HomeActivity.this,"无搜索结果",Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                MasterController.closeQuery();
                Log.i("zhenxiongwu","search view close");
                return false;
            }
        });

        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mTabLayout = (TabLayout)findViewById(R.id.tablayout);

//        MasterController.initData();
        mFragment2PagerAdapter = MasterController.
                createFragmentPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mFragment2PagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("zhenxiongwu","onTabSelected " + tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.i("zhenxiongwu","onTabUnselected" + tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.i("zhenxiongwu","onTabReselected" + tab.getPosition());
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("zhenxiongwu","on pageselected " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        progressBar = (ProgressBar)findViewById(R.id.prograessBar_loadmore);
        progressBar.setVisibility(View.GONE);

    }

    public void startProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void entProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
}
