package com.example.asus1.nbatest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.controller.Controller;

/**
 * Created by ASUS1 on 2017/5/11.
 */

public class MyFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int pageNum;
    private RecyclerView recyclerView;

    public static MyFragment newInstance(int pageNum) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE,pageNum);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNum = getArguments().getInt(ARG_PAGE,0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(Controller.getRecyclerViewAdapter(pageNum));

    }

    public int getPageNum(){
        return pageNum;
    }
}
