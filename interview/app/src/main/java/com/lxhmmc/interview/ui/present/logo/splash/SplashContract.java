package com.lxhmmc.interview.ui.present.logo.splash;

import com.lxhmmc.interview.domain.logo.SplashLogoHR;
import com.lxhmmc.interview.ui.base.BaseNetView;
import com.lxhmmc.interview.ui.base.BasePresenter;

/**
 * Created by Administrator on 2018/3/29.
 */

public class SplashContract {

    public interface NetView extends BaseNetView {

        void setSplash(SplashLogoHR splash);

    }

    public interface Presenter extends BasePresenter<NetView> {
        void getSplashByNet();
    }

}
