package com.lxhmmc.interview.ui.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Administrator on 2018/3/29.
 */

public class UiUtil {


    /**
     *  @desc fragment 绑定到view上
     *  @author lxh  2018/3/29 11:53
     */
    public static void addFragmentToActivity(FragmentManager supportFragmentManager, Fragment fragment, int frameId){

        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(frameId,fragment);
        fragmentTransaction.commit();
    }

}
