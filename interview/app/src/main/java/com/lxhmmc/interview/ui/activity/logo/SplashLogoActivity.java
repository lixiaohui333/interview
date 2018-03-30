package com.lxhmmc.interview.ui.activity.logo;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.lxhmmc.interview.R;
import com.lxhmmc.interview.comm.LogHelper;
import com.lxhmmc.interview.domain.logo.SplashLogoHR;
import com.lxhmmc.interview.ui.base.BaseFragmentActivity;
import com.lxhmmc.interview.ui.present.logo.splash.SplashContract;
import com.lxhmmc.interview.ui.present.logo.splash.SplashPresent;
import com.lxhmmc.interview.ui.present.logo.splash.SplashTask;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashLogoActivity extends BaseFragmentActivity implements SplashContract.View {


    SplashContract.Presenter splashPresenter;

    Dialog dialog;

    @Override
    protected boolean intentData() {
        return true;
    }

    @Override
    protected void initView() {
        setContentView(R.layout.logo_activity_splash);
    }

    @Override
    protected void initUI() {

        dialog = new ProgressDialog(ct);
        dialog.setTitle("请稍后....");

        SplashTask splashTask = SplashTask.getNewInstance();
        SplashPresent presenter = new SplashPresent(splashTask, this);
        setPresenter(presenter);

        loadInitData();
    }

    @Override
    protected void setUI() {

    }

    @Override
    protected void loadInitData() {
        splashPresenter.getSplash();
    }


    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        splashPresenter = presenter;
    }

    @Override
    public void hideProgress() {
        if (dialog.isShowing())
            dialog.dismiss();
    }

    @Override
    public void showProgress() {
        if (!dialog.isShowing())
            dialog.show();
    }

    @Override
    public void error() {
        LogHelper.i(TAG + " error");
    }



    @Override
    public void setSplash(SplashLogoHR splash) {

        LogHelper.i(TAG + " setSplash " + splash.toString());
    }


    @OnClick(R.id.btn_test)
    public void onViewClickedTest() {
        loadInitData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
