package com.lxhmmc.interview.ui.activity.logo;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.widget.ImageView;

import com.lxhmmc.interview.R;
import com.lxhmmc.interview.business.gilde.GlideApp;
import com.lxhmmc.interview.comm.LogHelper;
import com.lxhmmc.interview.domain.logo.SplashLogoHR;
import com.lxhmmc.interview.ui.base.BaseFragmentActivity;
import com.lxhmmc.interview.ui.present.logo.splash.SplashContract;
import com.lxhmmc.interview.ui.present.logo.splash.SplashPresent;
import com.lxhmmc.interview.ui.present.logo.splash.SplashTask;

import butterknife.BindView;
import butterknife.OnClick;

public class SplashLogoActivity extends BaseFragmentActivity implements SplashContract.View {


    SplashContract.Presenter splashPresenter;

    Dialog dialog;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;

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


        //test
//        GlideApp.with(ct).load(R.drawable.guide_1).into(ivLogo);

//        loadInitData();
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
//        if (!dialog.isShowing())
//            dialog.show();
    }

    @Override
    public void error() {
        LogHelper.i(TAG + " error");
    }


    @Override
    public void setSplash(SplashLogoHR splash) {

//        LogHelper.i(TAG + " setSplash " + splash.toString());
        GlideApp
                .with(ct)
                .load(splash.adUrl)
                .centerCrop()
                .into(ivLogo);

    }


    @OnClick(R.id.iv_logo)
    public void onViewClickedTest() {
        loadInitData();
    }

}
