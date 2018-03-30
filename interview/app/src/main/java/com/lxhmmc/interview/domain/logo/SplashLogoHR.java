package com.lxhmmc.interview.domain.logo;

import com.lxhmmc.interview.domain.base.BaseHR;

/**
 * Created by Administrator on 2018/3/29.
 */

public class SplashLogoHR extends BaseHR {

    public int version;
    public String adUrl;
    public int splashDuration;

    @Override
    public String toString() {
        return "SplashLogoHR{" +
                "version=" + version +
                ", adUrl='" + adUrl + '\'' +
                ", splashDuration=" + splashDuration +
                '}';
    }
}
