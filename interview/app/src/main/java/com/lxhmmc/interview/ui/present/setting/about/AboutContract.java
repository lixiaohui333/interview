package com.lxhmmc.interview.ui.present.setting.about;

import com.lxhmmc.interview.ui.base.BaseNetView;
import com.lxhmmc.interview.ui.base.BasePresenter;

/**
 * Created by Administrator on 2018/3/29.
 */

public class AboutContract {

    public interface NetView extends BaseNetView {

        void setFeedbackSuccess(String info);

    }

    public interface Presenter extends BasePresenter<AboutContract.NetView>{
        void feedback(String feedInfo);
    }
}
