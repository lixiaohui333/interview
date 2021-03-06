package com.lxhmmc.interview.ui.present.logo.splash;

import com.lxhmmc.interview.business.net.LoadTaskCallBack;
import com.lxhmmc.interview.business.net.NetTaskModel;
import com.lxhmmc.interview.comm.LogHelper;
import com.lxhmmc.interview.domain.base.BaseHR;
import com.lxhmmc.interview.domain.logo.SplashLogoHR;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/3/29.
 */
public class SplashPresent implements SplashContract.Presenter, LoadTaskCallBack<SplashLogoHR> {

    protected NetTaskModel netTask;

    protected SplashContract.NetView addview;

    protected List<Disposable> disposables = new ArrayList<>();


    public SplashPresent() {
        LogHelper.i("SplashPresent init");
    }



    @Override
    public void onSuccess(SplashLogoHR data) {
        if (addview != null) {
            addview.setSplash(data);
            addview.hideProgress();
        }

    }

    @Override
    public void onFinish() {
        if (addview != null) {
            addview.hideProgress();
        }
    }

    @Override
    public void onFailed() {
        if (addview != null) {
            addview.error();
            addview.hideProgress();
        }
    }

    @Override
    public void onSysError(BaseHR baseHR) {
        if (addview != null) {
            addview.apiError(baseHR);
        }
    }

    @Override
    public void onStart() {
        if (addview != null) {
            addview.showProgress();
        }
    }

    @Override
    public void getSplashByNet() {


        Disposable disposable = netTask.execute(null, this);
        disposables.add(disposable);
    }

    @Override
    public void bindTaskAndView(NetTaskModel netTask, SplashContract.NetView baseNetView) {
        this.netTask = netTask;
        this.addview = baseNetView;

        LogHelper.i("SplashPresent bindTaskAndView "+netTask +" " +baseNetView);
    }

    @Override
    public void onDestroy() {
        for (Disposable disposable :
                disposables) {
            if (!disposable.isDisposed())
                disposable.dispose();
        }
        disposables.clear();
        addview = null;
        netTask = null;
    }
}
