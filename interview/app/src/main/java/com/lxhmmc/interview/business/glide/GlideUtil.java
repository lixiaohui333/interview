//package com.lxhmmc.interview.business.glide;
//
//import android.content.Context;
//import android.graphics.drawable.Drawable;
//import android.widget.ImageView;
//
//import com.bumptech.glide.load.resource.bitmap.CircleCrop;
//import com.bumptech.glide.request.target.SimpleTarget;
//import com.bumptech.glide.request.transition.Transition;
//import com.kaixin.jianjiao.R;
//import com.kaixin.jianjiao.comm.tools.UiUtils;
//import com.kaixin.jianjiao.ui.activity.base.BaseFragmentActivity;
//
///**
// * Created by Administrator on 2017/9/13.
// */
//
//public class GlideUtil {
//
//    /*
//    <com.kaixin.jianjiao.comm.tools.glide.view.GlideImageView
//            xmlns:app="http://schemas.android.com/apk/res-auto"
//            android:id="@+id/iv_head"
//            android:layout_width="match_parent"
//            android:layout_height="match_parent"
//            android:scaleType="centerCrop"
//
//            //边框颜色
//            app:siv_border_color="@color/white"
//            app:siv_border_width="1dp"
//            app:siv_shape_type="circle"
//            //三种类型：默认是0:none、1:rectangle、2:circle
//            app:siv_pressed_alpha="0.3"
//            />
//     */
//
//
//    public static void display(ImageView iv, String imgUrl, int errorResId) {
//        basePlay(iv, imgUrl, errorResId, false);
//    }
//
//    public static void display(ImageView iv, String imgUrl) {
//        basePlay(iv, imgUrl, R.drawable.default_head, false);
//    }
//
//    public static void displayRound(ImageView iv, String imgUrl, int errorResId) {
//        basePlay(iv, imgUrl, errorResId, true);
//    }
//
//    public static void displayRound(ImageView iv, String imgUrl) {
//        basePlay(iv, imgUrl, R.drawable.hendpic, true);
//    }
//
//
//    private static void basePlay(ImageView iv, String imgUrl, int errorResId, boolean isRound) {
//
//
//
//        if (isRound) {
//            GlideApp
//                    .with(getContext())
//                    .load(imgUrl)
//                    .centerCrop()
//                    .transform(new CircleCrop())
//                    .placeholder(errorResId)
//                    .into(iv);
//        } else {
//            GlideApp
//                    .with(getContext())
//                    .load(imgUrl)
//                    .centerCrop()
//                    .placeholder(errorResId)
//                    .into(iv);
//        }
//
//    }
//
//    private static Context getContext() {
//        Context ct;
//        if (BaseFragmentActivity.activity != null) {
//            ct = BaseFragmentActivity.activity;
//        } else {
//            ct = UiUtils.getContext();
//        }
//        return ct;
//    }
//
//
//    public static void displayRes(ImageView imageView, int ResId) {
//
//        GlideApp
//                .with(getContext())
//                .load(ResId)
//                .into(imageView);
//
//    }
//
//    public static void displayCallBack(String imgUrl, final IGlideCallBack callBack) {
//
//        GlideApp
//                .with(getContext())
//                .load(imgUrl)
//                .into(new SimpleTarget<Drawable>() {
//                    @Override
//                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
//                        callBack.oncallBack(resource);
//                    }
//                });
//
//    }
//
//    public static void displayCallBackRound(String imgUrl, final IGlideCallBack callBack) {
//
//        GlideApp
//                .with(getContext())
//                .load(imgUrl)
//                .transform(new CircleCrop())
//                .into(new SimpleTarget<Drawable>() {
//                    @Override
//                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
//                        callBack.oncallBack(resource);
//                    }
//                });
//
//    }
//
//    public interface IGlideCallBack {
//        void oncallBack(Drawable drawable);
//    }
//}
