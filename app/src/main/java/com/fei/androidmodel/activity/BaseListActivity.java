package com.fei.androidmodel.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

/**
 * Created by Fei on 2017/8/23.
 * 有头部且可自定义,内容是RecyclerView,支持上拉加载，下拉刷新
 */

public abstract class BaseListActivity extends BaseActivity {

    protected int currentPage = 1;

    @Override
    public void init(Bundle savedInstanceState) {
        initView();
    }

    private void setRecycleViewSetting(RecyclerView recycleViewSetting) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayout.VERTICAL);
        recycleViewSetting.setLayoutManager(manager);
        recycleViewSetting.addItemDecoration(dividerItemDecoration);
    }

    //设置头部
    public abstract void initView();

}
