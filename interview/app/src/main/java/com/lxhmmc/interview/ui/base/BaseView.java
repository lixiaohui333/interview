package com.lxhmmc.interview.ui.base;

import com.lxhmmc.interview.domain.base.BaseHR;

/**
 * Created by Administrator on 2018/3/29.
 */

public interface BaseView {

    void hideProgress();

    void showProgress();

    void error();

    void apiError(BaseHR baseHR);
}
