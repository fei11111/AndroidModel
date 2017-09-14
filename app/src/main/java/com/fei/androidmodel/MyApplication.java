package com.fei.androidmodel;

import android.app.Application;

/**
 * Created by Administrator on 2017/7/28.
 */

public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {
        initCrashHandler();
    }

    private void initCrashHandler() {
        CrashHandler.getInstance().init();
    }

    public static MyApplication getInstance() {
        return instance;
    }

}
