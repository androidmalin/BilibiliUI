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

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Bilibili 主页面
 * @author malin.myemail@163.com
 * @date 2016-05-24 17:13
 */
public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private DrawerLayout mDrawerLayout;
    private LinearLayout mToolbarNavigationLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolBar();
        initToolBarNavigationIcon();
        initNavigationView();
        initViewPager();
        initTabLayout();
        initFloatingActionButton();
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.bilibili_toolbar_menu);
        toolbar.setTitle("");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.transparent));//标题颜色
        toolbar.setSubtitle("");
        toolbar.setSubtitleTextColor(getResources().getColor(android.R.color.transparent));//副标题颜色
        toolbar.setLogo(null);//logo
        toolbar.setNavigationIcon(null);//导航图标,最左边的图标
        setSupportActionBar(toolbar);
    }

    private void initToolBarNavigationIcon() {
        mToolbarNavigationLayout = (LinearLayout) findViewById(R.id.ll_toolbar_navigation);
        mToolbarNavigationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void initNavigationView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int drawerWidth = displayMetrics.widthPixels * 3 / 4;
            DrawerLayout.LayoutParams params = new DrawerLayout.LayoutParams(drawerWidth, DrawerLayout.LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.START;
            navigationView.setLayoutParams(params);
            View headerView = navigationView.getHeaderView(0);
            initNavigationViewHeadView(headerView);
            setupDrawerContent(navigationView);
        }
    }


    private void initNavigationViewHeadView(View headerView){
        if (headerView != null) {
            ImageView headImageView = (ImageView) headerView.findViewById(R.id.user_avatar);
            headImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "去登录....", Toast.LENGTH_SHORT).show();
                    mDrawerLayout.closeDrawers();//关闭抽屉
                }
            });

            TextView nickName = (TextView) headerView.findViewById(R.id.user_nick_text);
            nickName.setText("Bilibili");
        }
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        if (mViewPager != null) {
            setupViewPager(mViewPager);
        }

    }

    private void initTabLayout() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (tabLayout != null && mViewPager != null) {
            tabLayout.setupWithViewPager(mViewPager);
        }
    }

    private void initFloatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bilibili_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.toolbar_game_center:
                Toast.makeText(MainActivity.this, "游戏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_menu_download:
                Toast.makeText(MainActivity.this, "下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_menu_search:
                Toast.makeText(MainActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new CheeseListFragment(), "直播");
        adapter.addFragment(new CheeseListFragment(), "推荐");
        adapter.addFragment(new CheeseListFragment(), "番剧");
        adapter.addFragment(new CheeseListFragment(), "分区");
        adapter.addFragment(new CheeseListFragment(), "关注");
        adapter.addFragment(new CheeseListFragment(), "发现");
        viewPager.setAdapter(adapter);
    }

    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home: {
                        Toast.makeText(MainActivity.this, "首页", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_offline_manager: {
                        Toast.makeText(MainActivity.this, "离线缓存", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_favorites: {
                        Toast.makeText(MainActivity.this, "我的收藏", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_histories: {
                        Toast.makeText(MainActivity.this, "历史记录", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_following: {
                        Toast.makeText(MainActivity.this, "关注的人", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_pay: {
                        Toast.makeText(MainActivity.this, "我的钱包", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_theme: {
                        Toast.makeText(MainActivity.this, "主题选择", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    case R.id.nav_app_wall: {
                        Toast.makeText(MainActivity.this, "应用推荐", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_settings: {
                        Toast.makeText(MainActivity.this, "设置与帮助", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    default: {
                        break;
                    }
                }
                item.setChecked(true);//点击了把它设为选中状态
                mDrawerLayout.closeDrawers();//关闭抽屉
                return true;
            }
        });
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

}
