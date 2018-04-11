package com.lxhmmc.interview.ui.present.setting.about;

import com.lxhmmc.interview.business.net.LoadTaskCallBack;
import com.lxhmmc.interview.business.net.NetTask;
import com.lxhmmc.interview.domain.base.BaseHR;

/**
 * Created by Administrator on 2018/3/29.
 */

public class AboutPresent implements AboutContract.Presenter, LoadTaskCallBack<String> {

    protected NetTask netTask;

    protected AboutContract.View addview;

    public AboutPresent(NetTask netTask, AboutContract.View addview) {
        this.netTask = netTask;
        this.addview = addview;
    }

    @Override
    public void onSuccess(String info) {
        if (addview != null) {
            addview.setFeedbackSuccess(info);
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
    public void feedback(String feedInfo) {
        netTask.execute(feedInfo, this);
    }

}
