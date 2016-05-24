/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.malin.bilibili.design;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * http://www.zhihu.com/question/35422150/answer/62695696
 */
public class CheeseListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private SimpleStringRecyclerViewAdapter mAdapter;
    private  View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.fragment_cheese_list, container, false);
        setupRecyclerView(rootView);

//        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                rootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                mSwipeRefreshLayout.setRefreshing(true);
//                getData();
//            }
//        });

        return rootView;
    }






    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


//    @Override
//    public void onResume() {
//        super.onResume();
//        if (mSwipeRefreshLayout!=null){
//            if (mSwipeRefreshLayout.isRefreshing()){
//                mSwipeRefreshLayout.setRefreshing(false);
//            }
//        }
//    }

    private void setupRecyclerView(View view) {

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.parseColor("#FB7299"));

        mRecyclerView= (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));

        mAdapter = new SimpleStringRecyclerViewAdapter(getActivity(),new ArrayList<String>());
        mRecyclerView.setAdapter(mAdapter);



        mSwipeRefreshLayout.setOnRefreshListener(mRefreshListener);
        mSwipeRefreshLayout.post(new Runnable() {

            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                getData();
            }
        });
//        mRefreshListener.onRefresh();

    }

    private  SwipeRefreshLayout.OnRefreshListener mRefreshListener = new SwipeRefreshLayout.OnRefreshListener(){
        @Override
        public void onRefresh() {
            getData();
        }
    };


    private void getData(){
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mAdapter.setData(getRandomSublist(Cheeses.sCheeseStrings, 30));
                //停止刷新动画
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }


    private List<String> getRandomSublist(String[] array, int amount) {
        ArrayList<String> list = new ArrayList<>(amount);
        Random random = new Random();
        while (list.size() < amount) {
            list.add(array[random.nextInt(array.length)]);
        }
        return list;
    }


}
