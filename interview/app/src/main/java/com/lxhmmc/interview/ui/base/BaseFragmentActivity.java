package com.lxhmmc.interview.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/3/29.
 */

public abstract class BaseFragmentActivity extends AppCompatActivity {

    protected String TAG;

    protected String TAG_OBERVETASK = "OberveTaskSJYT";

    //当前运行的activity
    public static BaseFragmentActivity activity;

    protected Context ct;

    protected Intent preIntent;

    protected final Handler baseHandler = new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        TAG = getClass().getName();

        ct = this;

        initView();

        if (intentData()) {
            initUI();
        }

    }

    /**
     * 初始化数据，主要是针对intent过来的data 如果返回true 继续执行下面的initUI,false反之.
     */
    protected abstract boolean intentData();

    /**
     * 初始化view，自动调用
     */
    protected abstract void initView();

    /**
     * 初始化UI，自动调用
     */
    protected abstract void initUI();


    /**
     * 设置请求数据后的UI，需手动调用。
     */
    protected abstract void setUI();

    /**
     * 数据请求 需手动调用。 若首次进入界面可实现生命周期onCreateView以后的方法，然后手动调用。
     */
    protected abstract void loadInitData();

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ct = null;
        TAG = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
