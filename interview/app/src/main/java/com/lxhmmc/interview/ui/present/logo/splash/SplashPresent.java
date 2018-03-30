package com.lxhmmc.interview.ui.present.logo.splash;

import com.lxhmmc.interview.business.net.LoadTaskCallBack;
import com.lxhmmc.interview.business.net.NetTask;
import com.lxhmmc.interview.domain.base.BaseHR;
import com.lxhmmc.interview.domain.logo.SplashLogoHR;

/**
 * Created by Administrator on 2018/3/29.
 */

public class SplashPresent implements SplashContract.Presenter, LoadTaskCallBack<SplashLogoHR> {

    protected NetTask netTask;

    protected SplashContract.View addview;

    public SplashPresent(NetTask netTask, SplashContract.View addview) {
        this.netTask = netTask;
        this.addview = addview;
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
    public void getSplash() {
        netTask.execute(null, this);
    }
}
