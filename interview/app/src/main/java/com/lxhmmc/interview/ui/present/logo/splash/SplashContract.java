package com.lxhmmc.interview.ui.present.logo.splash;

import com.lxhmmc.interview.domain.base.BaseHR;
import com.lxhmmc.interview.domain.logo.SplashLogoHR;
import com.lxhmmc.interview.ui.base.BaseView;

/**
 * Created by Administrator on 2018/3/29.
 */

public class SplashContract {

    public interface View extends BaseView<Presenter>{

        void hideProgress();

        void showProgress();

        void error();

        void apiError(BaseHR baseHR);

        void setSplash(SplashLogoHR splash);

    }

    public interface Presenter {
        void getSplash();
    }
}
