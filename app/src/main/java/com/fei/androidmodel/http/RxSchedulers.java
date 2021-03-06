package com.fei.androidmodel.http;

import android.content.Context;

import com.fei.androidmodel.utils.NetUtils;
import com.trello.rxlifecycle2.LifecycleTransformer;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/12.
 */

public class RxSchedulers {
    public static <T> ObservableTransformer<T, T> compose(final Context mContext, final LifecycleTransformer<T> lifecycle, final OnConnectError onConnectError) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                // 可添加网络连接判断等
                                if (!NetUtils.isConnected(mContext)) {
                                    onConnectError.onError();
                                }
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(lifecycle);
            }
        };
    }

    public interface OnConnectError {
        void onError();
    }
}
