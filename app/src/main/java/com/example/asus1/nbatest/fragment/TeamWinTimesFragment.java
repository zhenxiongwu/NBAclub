package com.example.asus1.nbatest.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.util.DataSetter;
import com.example.asus1.nbatest.util.HorizontalBarChartStyleSetter;
import com.github.mikephil.charting.charts.HorizontalBarChart;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamWinTimesFragment extends Fragment {

    private HorizontalBarChart mTeamWinsRateBarChart;

    private List<Bundle> mBundleList = new ArrayList<>();

    private List<String> mTeamNames = new ArrayList<>();

    private List<Float> mWinRate = new ArrayList<>();

    private static final String TEAM_TOTAL_WIN_RATE = "球队总胜率";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DataSetter.setType(TEAM_TOTAL_WIN_RATE);

        parseTeamActionStartData();

        View v = inflater.inflate(
                R.layout.fragment_team_win_times,
                container,
                false);

        mTeamWinsRateBarChart = (HorizontalBarChart) v.findViewById(R.id.team_total_win_rate);
        HorizontalBarChartStyleSetter.setHorizontalBarChartStyle(mTeamWinsRateBarChart, mTeamNames);
        DataSetter.setBarData(mTeamWinsRateBarChart, mTeamNames, mWinRate);

        return v;
    }

    private void parseTeamActionStartData() {
        Intent intent = getActivity().getIntent();
        String[] keys = intent.getStringArrayExtra("keys");
        mBundleList = (List<Bundle>) intent.getSerializableExtra("bundles");
        for (int i = 0; i < mBundleList.size(); i++) {
            Bundle bundle = mBundleList.get(i);
            mTeamNames.add(bundle.getString(keys[0]));
            mWinRate.add(bundle.getFloat(keys[1]));
        }
    }

}
