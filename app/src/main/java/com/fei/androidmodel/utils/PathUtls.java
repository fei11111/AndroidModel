package com.fei.androidmodel.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 2017/7/28.
 */

public class PathUtls {

    private static String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    private static String appPath = rootPath + File.separator + "fei";
    private static String imgPath = appPath + File.separator + "image";
    private static String cachePath = appPath + File.separator + "cache";
    private static String logPath = appPath + File.separator + "log";

    public static String getRootPath() {
        return rootPath;
    }

    public static String getAppPath() {
        return appPath;
    }

    public static String getImgPath() {
        return imgPath;
    }

    public static String getLogPath() {
        return logPath;
    }

    public static String getCachePath() {
        return cachePath;
    }
}
