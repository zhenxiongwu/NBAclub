package com.example.asus1.nbatest.adapter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.database.table.EntityModel;

import java.util.List;

/**
 * Created by ASUS1 on 2017/5/11.
 */

public class PlayerRecyclerViewAdapter extends RecyclerView.Adapter<PlayerRecyclerViewAdapter.ViewHolder> {

    private List<EntityModel> players;

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_name;
        TextView textView_season;
        TextView textView_age;
        TextView textView_team;
        TextView textView_league;
        TextView textView_games;
        TextView textView_points;

        public ViewHolder(View itemView) {
            super(itemView);
            textView_name = (TextView) itemView.findViewById(R.id.player_list_item_textView_name);
            textView_season = (TextView) itemView.findViewById(R.id.player_list_item_textView_season);
            textView_age = (TextView) itemView.findViewById(R.id.player_list_item_textView_age);
            textView_team = (TextView) itemView.findViewById(R.id.player_list_item_textView_teamAbbr);
            textView_league = (TextView) itemView.findViewById(R.id.player_list_item_textView_league);
            textView_games = (TextView) itemView.findViewById(R.id.player_list_item_textView_games);
            textView_points = (TextView) itemView.findViewById(R.id.player_list_item_textView_points);
        }
    }

    public PlayerRecyclerViewAdapter(List<EntityModel> players) {
        this.players = players;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.player_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bundle bundle = players.get(position).getBundle();
//        holder.textView_name.setText(contents.get(position));
    }


    @Override
    public int getItemCount() {
        return players.size();
    }
}
