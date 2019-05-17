package com.example.smartconnect;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 声明 ViewPager
    private ViewPager mViewpager;

    // 声明四个Tab
    private LinearLayout    mTabWeixin;
    private LinearLayout    mTabFrd;
    private LinearLayout    mTabAddress;
    private LinearLayout    mTabSetting;

    // 声明四个 ImageButton
    private ImageButton     mWeixinImg;
    private ImageButton     mFrdImg;
    private ImageButton     mAddressImg;
    private ImageButton     mSettingImg;

    // 声明 ViewPager 的适配器
    private PagerAdapter    mAdapter;
    // 用于装载四个Tab的List
    private List<View> mTabs   =   new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        initViews();//初始化控件
        initDatas();//初始化数据
        initEvents();//初始化事件
    }

    //初始化控件
    private void initViews() {
        mViewpager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);

        mWeixinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_setting_img);

    }

    private void initDatas() {
        // 初始化 viewPager 的适配器
        mAdapter    =   new PagerAdapter() {
            @Override
            public int getCount() {
                return mTabs.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @Override
            public Object instantiateItem(ViewGroup containter, int position) {
                View view = mTabs.get(position);
                containter.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup containter, int position, Object object) {
                containter.removeView(mTabs.get(position));
            }
        };

        // 设置 viewPager 的适配器
        mViewpager.setAdapter(mAdapter);
    }

    private void    initEvents() {
        // 设置四个Tab的点击事件
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

        // 添加 viewPager 的切换 Tab 的监听事件
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 获取 ViewPager 的当前 Tab
                int currentItem = mViewpager.getCurrentItem();
                // 将所有的 ImageButton 设置成灰色
                resetImgs();
                // 将当前 Tab 对应的 ImageButton 设置成绿色
                switch(currentItem) {
                    case 0:
                        mWeixinImg.setImageResource(R.mipmap.tab_weixin_pressed);
                        break;
                    case 1:
                        mFrdImg.setImageResource(R.mipmap.tab_find_frd_pressed);
                        break;
                    case 2:
                        mAddressImg.setImageResource(R.mipmap.tab_address_pressed);
                        break;
                    case 3:
                        mSettingImg.setImageResource(R.mipmap.tab_settings_pressed);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        // 先将四个ImageButton 都设置成灰色
        resetImgs();
        switch(v.getId()) {
            case R.id.id_tab_weixin:
                // 设置viewPager 的当前 Tab
                mViewpager.setCurrentItem(0);
                // 将当前 Tab 对应的 ImageButton 设置成绿色
                mWeixinImg.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case R.id.id_tab_frd:
                mViewpager.setCurrentItem(1);
                mFrdImg.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                mViewpager.setCurrentItem(2);
                mAddressImg.setImageResource(R.mipmap.tab_address_pressed);
                break;
            case R.id.id_tab_setting:
                mViewpager.setCurrentItem(3);
                mSettingImg.setImageResource(R.mipmap.tab_settings_pressed);
                break;
        }
    }

    // 将四个 ImageButton 设置成灰色
    private void resetImgs() {
        mWeixinImg.setImageResource(R.mipmap.tab_weixin_normal);
        mFrdImg.setImageResource(R.mipmap.tab_find_frd_normal);
        mAddressImg.setImageResource(R.mipmap.tab_address_normal);
        mSettingImg.setImageResource(R.mipmap.tab_settings_normal);
    }

}
