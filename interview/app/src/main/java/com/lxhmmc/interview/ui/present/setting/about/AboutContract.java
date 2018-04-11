package com.lxhmmc.interview.ui.present.setting.about;

import com.lxhmmc.interview.ui.base.BaseView;

/**
 * Created by Administrator on 2018/3/29.
 */

public class AboutContract {

    public interface View extends BaseView{

        void setFeedbackSuccess(String info);

    }

    public interface Presenter {
        void feedback(String feedInfo);
    }
}
