package com.wuzch.broadcastpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/9/20.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    //当活动被创建时，加入到集合中
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollecter.addActivity(this);
    }

    @Override
    //当活动被销毁时，从集合中去除
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollecter.removeActivity(this);
    }
}
