package com.example.asus1.nbatest.adapter.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus1.nbatest.controller.DataController;
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

    private List<EntityModel> entityModels;
    private int itemLayoutId;
    private String[] keys;
    private int[] textViewIDs;

    private Context context;

    private DataController dataController;

    public RecyclerViewAdapter(DataController dataController) {
        this.dataController = dataController;
        this.entityModels = dataController.getEntitySet();
        this.itemLayoutId = dataController.getItemLayoutID();
        this.keys = dataController.getDatakeys();
        this.textViewIDs = dataController.getTextViewIDs();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(itemLayoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Bundle bundle = entityModels.get(position).getBundle();
        int index = 0;
        for (TextView textView : holder.textViews) {
            textView.setText(bundle.get(keys[index]).toString());
            index++;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataController.onItemClick(v.getContext(),entityModels.get(position),position);
                Log.i("zhenxiongwu", "item click " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return entityModels.size();
    }
}
