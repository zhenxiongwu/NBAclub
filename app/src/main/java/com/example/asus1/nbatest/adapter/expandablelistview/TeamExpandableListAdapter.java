package com.example.asus1.nbatest.adapter.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.database.table.model.Player;
import com.example.asus1.nbatest.database.table.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS1 on 2017/5/14.
 */

public class TeamExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Team> teamDataSet;
    private List<List<Player>> playerDataSet = new ArrayList<>();

    public TeamExpandableListAdapter(Context context,List<Team> teamDataSet){
        this.context = context;
        this.teamDataSet = teamDataSet;
        initPlayerSet();
    }

    private void initPlayerSet(){
        for(Team team:teamDataSet){
            playerDataSet.add(team.getPlayerList());
        }
    }


    @Override
    public int getGroupCount() {
        return teamDataSet.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return playerDataSet.get(groupPosition).size()+1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return teamDataSet.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return playerDataSet.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;

        if(convertView == null){
            convertView = (View) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.expandable_item_group_layout,null);
            groupHolder = new GroupHolder();
            groupHolder.season_textView = (TextView)convertView.findViewById(R.id.expandable_item_group_season);
            convertView.setTag(groupHolder);
        }
        else {
            groupHolder = (GroupHolder)convertView.getTag();
        }
        groupHolder.season_textView.setText(teamDataSet.get(groupPosition).getSeason());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder;
        if(convertView == null){
            convertView = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.player_in_team_list_item, null);
            childHolder = new ChildHolder();
            childHolder.player_name_textView = (TextView) convertView.findViewById(R.id.player_in_team_textView_name);
            childHolder.player_games_textView = (TextView) convertView.findViewById(R.id.player_in_team_textView_games);
            childHolder.player_points_textView = (TextView) convertView.findViewById(R.id.player_in_team_textView_points);
            childHolder.player_average_textView = (TextView) convertView.findViewById(R.id.player_in_team_textView_average);
            convertView.setTag(childHolder);
        }
        else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        if(childPosition==0){
            childHolder.player_name_textView.setText("球员");
            childHolder.player_games_textView.setText("出场");
            childHolder.player_points_textView.setText("得分");
            childHolder.player_average_textView.setText("平均得分");
        }
        else{
            childHolder.player_name_textView.setText(playerDataSet.get(groupPosition).get(childPosition-1).getName());
            childHolder.player_games_textView.setText(
                    String.valueOf(playerDataSet.get(groupPosition).get(childPosition-1).getGames()));
            childHolder.player_points_textView.setText(
                    String.valueOf(playerDataSet.get(groupPosition).get(childPosition-1).getPoints()));
            childHolder.player_average_textView.setText(String.valueOf(playerDataSet.get(groupPosition).get(childPosition-1).getAverage()));
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupHolder{
        TextView season_textView;
    }

    class ChildHolder{
        TextView player_name_textView;
        TextView player_games_textView;
        TextView player_points_textView;
        TextView player_average_textView;
    }
}
