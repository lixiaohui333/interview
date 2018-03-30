package com.lxhmmc.interview.business.net;

import com.lxhmmc.interview.domain.base.BaseHR;

/**
 * Created by lxh on 2018/3/29.
 */

public interface LoadTaskCallBack<T> {

    void onSuccess(T data);

    void onFinish();

    //接口请求错误
    void onFailed();

    void onSysError(BaseHR baseHR);

    void onStart();


}


