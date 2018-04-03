package com.lxhmmc.interview.business.gilde;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.request.target.SimpleTarget;
import com.lxhmmc.interview.ui.base.BaseFragmentActivity;
import com.lxhmmc.interview.ui.base.UiUtil;

/**
 * Created by Administrator on 2018/4/3.
 */

public class GlideUtil {

    public static void display(ImageView view, String url) {

        Context ct = BaseFragmentActivity.activity;
        if (ct == null) {
            ct = UiUtil.getContext();
        }
        GlideApp
                .with(ct)
                .load(url)
                .dontAnimate()
                .centerCrop()
                .placeholder(view.getDrawable())
                .into(view);
    }



    public static void display( String url,SimpleTarget<Drawable> lisener) {

        Context ct = BaseFragmentActivity.activity;
        if (ct == null) {
            ct = UiUtil.getContext();
        }

        GlideApp
                .with(ct)
                .load(url)
                .into(lisener);
    }


}
