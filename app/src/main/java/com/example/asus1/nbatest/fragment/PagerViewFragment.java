package com.example.asus1.nbatest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus1.nbatest.R;
import com.example.asus1.nbatest.activities.HomeActivity;
import com.example.asus1.nbatest.controller.MasterController;

/**
 * Created by ASUS1 on 2017/5/11.
 */

public class PagerViewFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int pageNum;
    private RecyclerView recyclerView;

    public static PagerViewFragment newInstance(int pageNum) {

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE,pageNum);
        PagerViewFragment fragment = new PagerViewFragment();
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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int previousTotal = 0;
//            boolean loading = true;
            int firstVisibleItem , visibleItemCount, totalItemCount;
            LinearLayoutManager linearLayoutManager;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = recyclerView.getChildCount();
                linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
                totalItemCount = linearLayoutManager.getItemCount();
                firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                if(totalItemCount > previousTotal){
                    Log.i("zhenxiongwu","totalItemCount>previousTotal");
//                    loading = false;
                    previousTotal = totalItemCount;
                }
//                if(loading){
//                    Log.i("zhenxiongwu","visibleItemCount is " + visibleItemCount
//                    +"\ttotalItemCount is "+ totalItemCount + "\tfirstVisibleItem is "+firstVisibleItem);
//
//                }
                if(/*!loading && */(totalItemCount - visibleItemCount)<= firstVisibleItem){
//                    recyclerView.getAdapter()
                    Log.i("zhenxiongwu","到底了");
                    if(getActivity() instanceof HomeActivity){
                        Log.i("zhenxiongwu","getActivity is Home----------------------");
                    }
                    MasterController.loadMore(getActivity(),pageNum,totalItemCount);
//                    loading = true;
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(MasterController.getRecyclerViewAdapter(pageNum));
    }

    public int getPageNum(){
        return pageNum;
    }
}
