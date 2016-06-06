package com.malin.bilibili.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 类描述:
 * 创建人:malin.myemail@163.com
 * 创建时间:16-6-3
 * 备注:{@link } Thanks for  ,Her code is very good ! I made reference to his code,It saves me a lot of time!
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class LiveTabFragment extends Fragment implements View.OnClickListener {


    private TextView mTvCategoryPhoneLive;
    private TextView mTvCategoryPaint;
    private TextView mTvCategoryMengRecommand;
    private TextView mTvCategoryNetGame;
    private TextView mTvCategorySingleGame;
    private TextView mTvCategoryEGame;
    private TextView mTvCategoryAll;
    private TextView mTvCategoryAllLive;

    private RelativeLayout mRlLiveAddAttention;
    private RelativeLayout mRlLiveCenter;
    private RelativeLayout mRlLiveSearch;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.live_layout_header_layout, null);
        initView(view);
        initListener();
        return view;
    }


    private void initListener() {
        mTvCategoryPhoneLive.setOnClickListener(this);
        mTvCategoryPaint.setOnClickListener(this);
        mTvCategoryMengRecommand.setOnClickListener(this);
        mTvCategoryNetGame.setOnClickListener(this);
        mTvCategorySingleGame.setOnClickListener(this);
        mTvCategoryEGame.setOnClickListener(this);
        mTvCategoryAll.setOnClickListener(this);
        mTvCategoryAllLive.setOnClickListener(this);
        mRlLiveAddAttention.setOnClickListener(this);
        mRlLiveCenter.setOnClickListener(this);
        mRlLiveSearch.setOnClickListener(this);
    }

    private void initView(View view) {
        mTvCategoryPhoneLive = (TextView) view.findViewById(R.id.tv_category_phone_live);
        mTvCategoryPaint = (TextView) view.findViewById(R.id.tv_category_paint);
        mTvCategoryMengRecommand = (TextView) view.findViewById(R.id.tv_category_meng_recommand);
        mTvCategoryNetGame = (TextView) view.findViewById(R.id.tv_category_net_game);
        mTvCategorySingleGame = (TextView) view.findViewById(R.id.tv_category_single_game);
        mTvCategoryEGame = (TextView) view.findViewById(R.id.tv_category_e_game);
        mTvCategoryAll = (TextView) view.findViewById(R.id.tv_category_all);
        mTvCategoryAllLive = (TextView) view.findViewById(R.id.tv_category_all_live);

        mRlLiveAddAttention = (RelativeLayout) view.findViewById(R.id.rl_live_add_attention);
        mRlLiveCenter = (RelativeLayout) view.findViewById(R.id.rl_live_center);
        mRlLiveSearch = (RelativeLayout) view.findViewById(R.id.rl_live_search);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_category_phone_live: {
                Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.tv_category_paint: {
                Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.tv_category_meng_recommand: {
                Toast.makeText(getActivity(), "3", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.tv_category_net_game: {
                Toast.makeText(getActivity(), "4", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.tv_category_single_game: {
                Toast.makeText(getActivity(), "5", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.tv_category_e_game: {
                Toast.makeText(getActivity(), "6", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.tv_category_all: {
                Toast.makeText(getActivity(), "7", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.tv_category_all_live: {
                Toast.makeText(getActivity(), "8", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.rl_live_add_attention: {
                Toast.makeText(getActivity(), "关注直播", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.rl_live_center: {
                Toast.makeText(getActivity(), "直播中心", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.rl_live_search: {
                Toast.makeText(getActivity(), "搜索直播", Toast.LENGTH_SHORT).show();
                break;
            }

        }
    }
}
