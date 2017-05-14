package com.example.asus1.nbatest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.adapter.expandablelistview.TeamExpandableListAdapter;
import com.example.asus1.nbatest.controller.ControllerManager;
import com.example.asus1.nbatest.controller.TeamDetailController;
import com.example.asus1.nbatest.database.table.EntityModel;
import com.example.asus1.nbatest.database.table.model.Team;

import java.util.List;

public class TeamDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView team_detail_textView_name;
    private TextView team_detail_textView_league;
    private TextView team_detail_textView_from;
    private TextView team_detail_textView_to;
    private TextView team_detail_textView_years;
    private TextView team_detail_textView_games;
    private TextView team_detail_textView_wins;
    private TextView team_detail_textView_loses;
    private TextView team_detail_textView_champ;

    private ExpandableListView expandableListView;
    private TeamExpandableListAdapter teamExpandableListAdapter;

    private TeamDetailController teamDetailController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        toolbar = (Toolbar) findViewById(R.id.team_detail_toolbar);
        setSupportActionBar(toolbar);

        teamDetailController = (TeamDetailController) ControllerManager
                .getController(ControllerManager.TEAM_DETAIL_CONTROLLER);

        List<Team> teamDataSet = teamDetailController.getConvertedDataSet();
        Team team = teamDataSet.get(0);

        team_detail_textView_name = (TextView) findViewById(R.id.team_detail_textView_name);
        team_detail_textView_name.setText(team.getName());

        team_detail_textView_league = (TextView) findViewById(R.id.team_detail_textView_league);
        team_detail_textView_league.setText(team.getLeague());

        team_detail_textView_from = (TextView) findViewById(R.id.team_detail_textView_from);
        team_detail_textView_from.setText(String.valueOf(team.getFromYear()));

        team_detail_textView_to = (TextView) findViewById(R.id.team_detail_textView_to);
        team_detail_textView_to.setText(String.valueOf(team.getToYear()));

        team_detail_textView_years = (TextView) findViewById(R.id.team_detail_textView_years);
        team_detail_textView_years.setText(String.valueOf(team.getYears()));

        team_detail_textView_games = (TextView) findViewById(R.id.team_detail_textView_games);
        team_detail_textView_games.setText(String.valueOf(team.getGames()));

        team_detail_textView_wins = (TextView) findViewById(R.id.team_detail_textView_wins);
        team_detail_textView_wins.setText(String.valueOf(team.getWins()));

        team_detail_textView_loses = (TextView) findViewById(R.id.team_detail_textView_loses);
        team_detail_textView_loses.setText(String.valueOf(team.getLoses()));

        team_detail_textView_champ = (TextView) findViewById(R.id.team_detail_textView_champ);
        team_detail_textView_champ.setText(String.valueOf(team.getChampionships()));

        expandableListView = (ExpandableListView) findViewById(R.id.team_detail_expandableListView);
        teamExpandableListAdapter = new TeamExpandableListAdapter(this,teamDataSet);

        expandableListView.setAdapter(teamExpandableListAdapter);

    }


    /**
     * 添加菜单按钮，点击响应显示统计所有球队胜率的统计图
     */
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.player_statistics_icon:
                List<Bundle> bundles = new ArrayList<>();
                List<Team> entityModels = Selector.selectTeams();
                int pointer = 0;
                while (pointer != entityModels.size()){

                }
                for(EntityModel entityModel : entityModels){
                    bundles.add(entityModel.getBundle());
                }
                StatisticsActivity.actionStart(this,bundles
                        ,StatisticsActivity.PLAYER_STATISTICS, Player.POINTS,
                        Player.GAMES,Player.AVERAGE,Player.SEASON);
                break;
            default:
        }
        return true;
    }*/

    public static void startActivity(Context context, List<EntityModel> teamsDataSet){
        TeamDetailController teamDetailController =
                (TeamDetailController) ControllerManager.getController(ControllerManager.TEAM_DETAIL_CONTROLLER);
        teamDetailController.initEntitySet(teamsDataSet);

        Intent intent = new Intent(context,TeamDetailActivity.class);
        context.startActivity(intent);
    }
}
