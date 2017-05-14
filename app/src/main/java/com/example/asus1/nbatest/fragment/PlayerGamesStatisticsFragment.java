package com.example.asus1.nbatest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.util.BarChartSytleSetter;
import com.example.asus1.nbatest.util.DataSetter;
import com.example.asus1.nbatest.util.LineChartStyleSetter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerGamesStatisticsFragment extends Fragment {

    private static final String PLAYER_GAMES = "出场次数";

    private static final String PLAYER_TOTAL_POINTS = "赛季总得分";

    private static final String PLAYER_AVERAGE_POINTS = "赛季平均得分";

    private RecyclerView mAnalysisRecyclerView;

    private Button mPlayerGamesAnalysis;

    private Button mPlayerTotalPointsAnalysis;

    private Button mPlayerAveragePointsAnalysis;

    private List<Bundle> mBundleList = new ArrayList<>();

    private List<Float> mPlayerPoints = new ArrayList<>();

    private List<Float> mPlayerGames = new ArrayList<>();

    private List<Float> mPlayerAveragePoints = new ArrayList<>();

    private List<String> mPlayerSeasons = new ArrayList<>();

    private List<Float> mPlayerDatas = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parsePlayerActionStartData();
        mPlayerDatas = mPlayerGames;
        DataSetter.setType(PLAYER_GAMES);

        View v = inflater.inflate(
                R.layout.fragment_player_games_statistics,
                container,
                false);

        mAnalysisRecyclerView = (RecyclerView) v.findViewById(R.id.analysis_recycler_view);
        mAnalysisRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final AnalysisAdapter adapter = new AnalysisAdapter();
        mAnalysisRecyclerView.setAdapter(adapter);

        mPlayerGamesAnalysis = (Button) v.findViewById(R.id.player_games_analysis);
        mPlayerGamesAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayerDatas = mPlayerGames;
                DataSetter.setType(PLAYER_GAMES);
                adapter.notifyDataSetChanged();
            }
        });

        mPlayerTotalPointsAnalysis = (Button) v.findViewById(R.id.player_total_points_analysis);
        mPlayerTotalPointsAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayerDatas = mPlayerPoints;
                DataSetter.setType(PLAYER_TOTAL_POINTS);
                adapter.notifyDataSetChanged();
            }
        });

        mPlayerAveragePointsAnalysis = (Button) v.findViewById(R.id.player_average_points_analysis);
        mPlayerAveragePointsAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayerDatas = mPlayerAveragePoints;
                DataSetter.setType(PLAYER_AVERAGE_POINTS);
                adapter.notifyDataSetChanged();
            }
        });

        return v;
    }

    private class BarChartAnalysisHolder extends RecyclerView.ViewHolder {

        private BarChart mBarChart;

        public BarChartAnalysisHolder(View itemView) {
            super(itemView);

            mBarChart = (BarChart) itemView.findViewById(R.id.player_games_bar_chart);
        }
    }

    private class LineChartAnalysisHolder extends RecyclerView.ViewHolder {

        private LineChart mLineChart;

        public LineChartAnalysisHolder(View itemView) {
            super(itemView);

            mLineChart = (LineChart) itemView.findViewById(R.id.player_games_line_chart);
        }
    }

    private class AnalysisAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private static final int TYPE_BAR_CHART = 0;

        private static final int TYPE_LINE_CHART = 1;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == TYPE_BAR_CHART) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_bar_chart, parent, false);
                BarChartAnalysisHolder barChartAnalysisHolder = new BarChartAnalysisHolder(view);
                return barChartAnalysisHolder;
            }
            if (viewType == TYPE_LINE_CHART) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_line_chart, parent, false);
                LineChartAnalysisHolder lineChartAnalysisHolder = new LineChartAnalysisHolder(view);
                return lineChartAnalysisHolder;
            }
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof BarChartAnalysisHolder) {
                BarChart chart = ((BarChartAnalysisHolder) holder).mBarChart;
                BarChartSytleSetter.setBarChartStyle(chart, mPlayerSeasons);
                DataSetter.setBarData(chart, mPlayerSeasons, mPlayerDatas);
            }
            if (holder instanceof LineChartAnalysisHolder) {
                LineChart chart = ((LineChartAnalysisHolder) holder).mLineChart;
                LineChartStyleSetter.setLineChartStyle((((LineChartAnalysisHolder) holder).mLineChart), mPlayerSeasons);
                DataSetter.setLineData(chart, mPlayerSeasons, mPlayerDatas);
            }
        }

        @Override
        public int getItemViewType(int position) {
            return position % 2 == 0 ? TYPE_BAR_CHART : TYPE_LINE_CHART;
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

    private void parsePlayerActionStartData() {
        Intent intent = getActivity().getIntent();
        String[] keys = intent.getStringArrayExtra("keys");
        mBundleList = (List<Bundle>) intent.getSerializableExtra("bundles");
        for (int i = 0; i < mBundleList.size(); i++) {
            Bundle bundle = mBundleList.get(i);
            mPlayerPoints.add(bundle.getFloat(keys[0]));
            mPlayerGames.add(bundle.getFloat(keys[1]));
            mPlayerAveragePoints.add(bundle.getFloat(keys[2]));
            mPlayerSeasons.add(bundle.getString(keys[3]));
        }
    }
}
