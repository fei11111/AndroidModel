package com.fei.androidmodel.http.manager;

import android.util.Log;

import com.fei.androidmodel.MyApplication;
import com.fei.androidmodel.utils.NetUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/28.
 */

public class RspNetInterceptor implements Interceptor {
    private final int maxAge = 60 * 60 * 24 * 7;
    private final int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetUtils.isConnected(MyApplication.getInstance())) {//如果网络不可用
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Log.d("OkHttp", "网络不可用请求拦截");
        } else {//网络可用
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_NETWORK)
                    .build();
            Log.d("OkHttp", "网络可用请求拦截");
        }
        Response response = chain.proceed(request);
        if (NetUtils.isConnected(MyApplication.getInstance())) {//如果网络可用
            Log.d("OkHttp", "网络可用响应拦截");
            response = response.newBuilder()
                    //覆盖服务器响应头的Cache-Control,用我们自己的,因为服务器响应回来的可能不支持缓存
                    .header("Cache-Control", "public,max-age=" + maxAge)
                    .removeHeader("Pragma")
                    .build();
        } else {
            Log.d("OkHttp", "网络不可用响应拦截");
            response = response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        }
        return response;
    }
}
