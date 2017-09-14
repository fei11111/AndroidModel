package com.fei.androidmodel.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

/**
 * Created by Fei on 2017/8/23.
 * 没有头部,内容是RecyclerView,支持上拉加载，下拉刷新
 */

public abstract class BaseListFragment extends BaseFragment {

    protected int currentPage = 1;

    @Override
    public void init(Bundle savedInstanceState) {
        initData();
    }

    public void setRecycleViewSetting(RecyclerView recycleViewSetting) {
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(activity, LinearLayout.VERTICAL);
        recycleViewSetting.setLayoutManager(manager);
        recycleViewSetting.addItemDecoration(dividerItemDecoration);
    }

    public abstract void initData();
}
