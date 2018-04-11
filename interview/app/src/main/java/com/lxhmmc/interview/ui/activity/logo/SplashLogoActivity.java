package com.lxhmmc.interview.ui.activity.logo;

import android.app.Dialog;
import android.widget.ImageView;

import com.lxhmmc.interview.R;
import com.lxhmmc.interview.business.gilde.GlideUtil;
import com.lxhmmc.interview.comm.LogHelper;
import com.lxhmmc.interview.domain.logo.SplashLogoHR;
import com.lxhmmc.interview.ui.activity.frame.FrameActivityMain;
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

        //test
        goactivity(FrameActivityMain.class);
//        loadInitData();
    }

    @Override
    protected void setUI() {

    }

    @Override
    protected void loadInitData() {

        if (splashPresenter == null)
            splashPresenter = new SplashPresent(SplashTask.getNewInstance(), this);

        splashPresenter.getSplash();
    }


    @Override
    public void hideProgress() {
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void error() {
        LogHelper.i(TAG + " error");
    }


    @Override
    public void setSplash(SplashLogoHR splash) {
        GlideUtil.display(ivLogo, splash.adUrl);

        baseHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                goactivity(FrameActivityMain.class);
                finish();

            }


        }, splash.splashDuration);

    }


    @OnClick(R.id.iv_logo)
    public void onViewClickedTest() {
        loadInitData();
    }

}
