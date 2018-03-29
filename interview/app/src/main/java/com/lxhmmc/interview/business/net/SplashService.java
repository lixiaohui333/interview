package com.lxhmmc.interview.business.net;

import com.lxhmmc.interview.domain.logo.SplashLogoHR;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/3/29.
 */

public interface SplashService {

    @GET("api/api.interview.logo.splap")
    Observable<SplashLogoHR> getSplash();


}
