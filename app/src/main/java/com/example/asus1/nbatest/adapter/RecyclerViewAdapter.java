package com.example.asus1.nbatest.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus1.nbatest.database.table.EntityModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS1 on 2017/5/12.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    protected class ViewHolder extends RecyclerView.ViewHolder {

        List<TextView> textViews = new ArrayList<>();

        public ViewHolder(View itemView) {
            super(itemView);
            for (int textViewID : textViewIDs) {
                textViews.add((TextView) itemView.findViewById(textViewID));
            }
        }
    }

    private Context context;
    private List<EntityModel> entityModels;
    private int itemLayoutId;
    private String[] keys;
    private int[] textViewIDs;

    public RecyclerViewAdapter(Context context, List<EntityModel> entityModels, int itemLayoutId,
                               String[] keys, int[] textViewIDs) {
        this.context = context;
        this.entityModels = entityModels;
        this.itemLayoutId = itemLayoutId;
        this.keys = keys;
        this.textViewIDs = textViewIDs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayoutId,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bundle bundle = entityModels.get(position).getBundle();
        int index = 0;
        for(TextView textView : holder.textViews){
            textView.setText(bundle.get(keys[index]).toString());
            index++;
        }
    }

    @Override
    public int getItemCount() {
        return entityModels.size();
    }
}
