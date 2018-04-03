package com.lxhmmc.interview.ui.present.logo.splash;

import com.lxhmmc.interview.business.net.LoadTaskCallBack;
import com.lxhmmc.interview.business.net.NetTask;
import com.lxhmmc.interview.business.net.SplashService;
import com.lxhmmc.interview.comm.LogHelper;
import com.lxhmmc.interview.domain.base.BaseHR;
import com.lxhmmc.interview.domain.logo.SplashLogoHR;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/3/29.
 */

public class SplashTask implements NetTask<String> {

    public static final String HOST = "http://192.168.33.144/";

    private SplashTask() {

        createRetrofit();

    }

    private static SplashTask INSTANCE = null;

    public static SplashTask getNewInstance() {

        if (INSTANCE == null) {

            synchronized (SplashTask.class) {
                if (INSTANCE == null)
                    INSTANCE = new SplashTask();
            }

        }

        return INSTANCE;
    }

    private Retrofit retrofit;

    private void createRetrofit() {

        retrofit = new Retrofit.Builder().baseUrl(HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

    }

    @Override
    public Disposable execute(String data, final LoadTaskCallBack taskCallback) {

        SplashService weatherService = retrofit.create(SplashService.class);
        Disposable disposable = weatherService.getSplash().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseHR<SplashLogoHR>>() {
                    @Override
                    public void accept(BaseHR<SplashLogoHR> splashLogoHRBaseHR) throws Exception {

                        LogHelper.i("Consumer accept BaseHR:"+splashLogoHRBaseHR.toString());
                        if (splashLogoHRBaseHR.sysStatus != BaseHR.HTTP_OK || splashLogoHRBaseHR.apiStatus != BaseHR.HTTP_OK) {
                            taskCallback.onSysError(splashLogoHRBaseHR);
                        } else {
                            taskCallback.onSuccess(splashLogoHRBaseHR.data);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        taskCallback.onFailed();
                        LogHelper.i("Consumer accept onFailed:"+throwable.getMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        taskCallback.onFinish();
                        LogHelper.i("Action run onFinish");
                    }
                }, new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        taskCallback.onStart();
                        LogHelper.i("Consumer accept onStart");
                    }
                });

        return disposable;
    }
}
