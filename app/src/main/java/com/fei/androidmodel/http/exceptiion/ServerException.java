package com.fei.androidmodel.http.exceptiion;

/**
 * Created by Administrator on 2017/9/22.
 */

public class ServerException extends RuntimeException {
    public int code;
    public String message;
}
