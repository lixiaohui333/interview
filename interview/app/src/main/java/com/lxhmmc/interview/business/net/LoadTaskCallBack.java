package com.lxhmmc.interview.business.net;

/**
 * Created by lxh on 2018/3/29.
 */

public interface LoadTaskCallBack<T> {

    void onSuccess(T data);

    void onFinish();

    void onFailed();

    void onStart();


}


