package com.example.myapplication_mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity {
    protected Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setView());
        bind = ButterKnife.bind(this);
        BaseApp.list.add(this);
        init();
    }

    //初始化的方法
    protected abstract void init();

    //加载布局
    protected abstract int setView();

    //监听返回键

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        BaseApp.exit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null){
            bind.unbind();
            bind = null;
        }
        BaseApp.clearActivity();
    }
}
