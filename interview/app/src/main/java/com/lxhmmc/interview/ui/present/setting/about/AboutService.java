package com.lxhmmc.interview.ui.present.setting.about;

import com.lxhmmc.interview.domain.base.BaseHR;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/3/29.
 */

public interface AboutService {

    @GET("/api/api.base")
    Observable<BaseHR> feedback();


}
