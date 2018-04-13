package com.lxhmmc.interview.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxhmmc.interview.business.net.NetTaskModel;
import com.lxhmmc.interview.comm.LogHelper;
import com.lxhmmc.interview.comm.util.TUtil;
import com.lxhmmc.interview.domain.base.BaseHR;
import com.lxhmmc.interview.domain.eventbus.EventMessage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/29.
 */

public abstract class BaseFragment<T extends BasePresenter, E extends NetTaskModel> extends Fragment {

    protected String TAG;

    protected String TAG_OBERVETASK = "OberveTaskSJYT";

    protected Context ct;

    protected View viewRoot;

    protected T mPresenter;
    protected E mModel;


    @Override
    public void onResume() {
        super.onResume();

        checkNotNetWork();
    }

    private void checkNotNetWork() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        LogHelper.i(this.getClass().getName() + " : onCreate");
        ct = getActivity();

        TAG = this.getClass().getName();

        //EventBus register
        EventBus.getDefault().register(this);

        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LogHelper.i(this.getClass().getName() + " : onCreateView");

        viewRoot = initView(inflater);

        return viewRoot;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogHelper.i(this.getClass().getName() + " : onActivityCreated");


        bundle = getArguments();

        initMvp();

        initUI();

    }

    protected Bundle bundle = null;

    /**
     * @param key
     * @param value void
     * @author lxh
     * @Desc: 用bundle传递值
     */
    public void addParams(String key, Object value) {
        if (bundle == null) {
            bundle = new Bundle();
        }

        if (value instanceof String) {
            bundle.putString(key, (String) value);
        } else if (value instanceof Integer) {
            bundle.putSerializable(key, (Integer) value);
        } else if (value instanceof Serializable) {
            bundle.putSerializable(key, (Serializable) value);
        }
        setArguments(bundle);

    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true, priority = 100)
    public void eventMessage(EventMessage message) {
        LogHelper.i(TAG, "eventMessage:----->" + message.toString());
        if (TAG.equals(message.rel)) {
            getEventMessage(message);
            LogHelper.i(TAG, message.toString());
        }
    }

    protected void getEventMessage(EventMessage message) {
        LogHelper.i(TAG, message.toString());
    }

    protected void sendEventBus(EventMessage message) {

        if (BaseFragmentActivity.activity == null)
            return;

        BaseFragmentActivity.activity.sendEventBus(message);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    private void initMvp() {

        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);

        if (mPresenter == null || mModel == null)
            return;

        if (this instanceof BaseNetView)
            mPresenter.bindTaskAndView(mModel, (BaseNetView) this);
    }

    public void apiError(BaseHR baseHR) {
        if (baseHR.sysStatus != BaseHR.HTTP_OK || baseHR.apiStatus != BaseHR.HTTP_OK) {
            showToastError(baseHR.info);
        }
    }

    protected void showToast(String info) {
        if (BaseFragmentActivity.activity == null)
            return;
        BaseFragmentActivity.activity.showToast(info);
    }


    protected void showToastError(String info) {
        if (BaseFragmentActivity.activity == null)
            return;
        BaseFragmentActivity.activity.showToastError(info);
    }


    /**
     * 初始化view，自动调用
     */
    protected abstract View initView(LayoutInflater inflater);

    /**
     * 初始化UI，自动调用
     */
    protected abstract void initUI();


    /**
     * 数据请求 需手动调用。 若首次进入界面可实现生命周期onCreateView以后的方法，然后手动调用。
     */
    protected abstract void loadInitData();


}
