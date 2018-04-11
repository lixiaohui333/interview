package com.lxhmmc.interview.ui.present.logo.splash;

import com.lxhmmc.interview.domain.base.BaseHR;
import com.lxhmmc.interview.domain.logo.SplashLogoHR;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/3/29.
 */

public interface SplashService {

    @GET("/api/api.interview.logo.splap")
    Observable<BaseHR<SplashLogoHR>> getSplash();


}
