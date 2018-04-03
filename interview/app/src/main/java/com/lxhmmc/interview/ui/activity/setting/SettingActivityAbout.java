package com.lxhmmc.interview.ui.activity.setting;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lxhmmc.interview.R;
import com.lxhmmc.interview.ui.base.BaseFragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivityAbout extends BaseFragmentActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected boolean intentData() {
        return true;
    }

    @Override
    protected void initView() {
        setContentView(R.layout.setting_activity_about);
    }

    @Override
    protected void initUI() {

        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
