package com.lxhmmc.interview.ui.activity.frame;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.lxhmmc.interview.R;
import com.lxhmmc.interview.business.gilde.GlideUtil;
import com.lxhmmc.interview.ui.activity.setting.SettingActivityAbout;
import com.lxhmmc.interview.ui.activity.setting.SettingActivityMain;
import com.lxhmmc.interview.ui.base.BaseFragmentActivity;
import com.lxhmmc.interview.ui.base.UiUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FrameActivityMain extends BaseFragmentActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.nav_view)
    NavigationView navView;

    @BindView(R.id.rg_main)
    RadioGroup rgMain;

    @Override
    protected boolean intentData() {
        return true;
    }

    @Override
    protected void initView() {
        setContentView(R.layout.frame_activity_main);
    }

    @Override
    protected void initUI() {

        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_launcher_round);


        ImageView ivHead = navView.getHeaderView(0).findViewById(R.id.iv_head);


        GlideUtil.displayCircle(ivHead, R.drawable.icon_myhead);


        selectFragment(R.id.rb_interview);

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectFragment(checkedId);
            }
        });


    }

    private void selectFragment(int checkedId) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment fragment = supportFragmentManager.findFragmentById(R.id.fl_frame);
        switch (checkedId) {
            case R.id.rb_interview:
                if (fragment == null || !(fragment instanceof FrameFragmentInterview)) {
                    UiUtil.addFragmentToActivity(supportFragmentManager,new FrameFragmentInterview(),R.id.fl_frame);
                }
                break;
            case R.id.rb_block:
                if (fragment == null || !(fragment instanceof FrameFragmentBlock)) {
                    UiUtil.addFragmentToActivity(supportFragmentManager,new FrameFragmentBlock(),R.id.fl_frame);
                }
                break;
            case R.id.rb_msg:
                if (fragment == null || !(fragment instanceof FrameFragmentMsg)) {
                    UiUtil.addFragmentToActivity(supportFragmentManager,new FrameFragmentMsg(),R.id.fl_frame);
                }
                break;
            case R.id.rb_profile:
                if (fragment == null || !(fragment instanceof FrameFragmentProfile)) {
                    UiUtil.addFragmentToActivity(supportFragmentManager,new FrameFragmentProfile(),R.id.fl_frame);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tollbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:

                drawerlayout.openDrawer(GravityCompat.START);

                break;

            case R.id.toolbar_about:

                goactivity(SettingActivityAbout.class);
                break;
            case R.id.toolbar_settings:
                goactivity(SettingActivityMain.class);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void setUI() {

    }

    @Override
    protected void loadInitData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
