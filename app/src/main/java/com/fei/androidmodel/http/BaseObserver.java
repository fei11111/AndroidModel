package com.fei.androidmodel.http;

import android.content.Context;

import com.fei.androidmodel.entity.BaseEntity;
import com.fei.androidmodel.http.exceptiion.ExceptionEngine;
import com.fei.androidmodel.utils.LogUtils;
import com.fei.androidmodel.utils.Utils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/12.
 */

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {

    private static final String TAG = "BaseObserver";
    private Context mContext;

    protected BaseObserver(Context context) {
        this.mContext = context;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseEntity<T> value) {
        if (value.isState()) {
            T t = value.getData();
            onHandleSuccess(t);
        } else {
            onHandleError(value.getMessage());
        }
    }

    @Override
    public void onError(Throwable e) {
        Utils.showToast(mContext, ExceptionEngine.handleException(e).getMessage());
    }

    @Override
    public void onComplete() {
        LogUtils.d(TAG, "onComplete");
    }


    protected abstract void onHandleSuccess(T t);

    protected void onHandleError(String msg) {
        Utils.showToast(mContext, msg);
    }
}
