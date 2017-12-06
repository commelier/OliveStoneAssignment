package com.example.ryubomee.olivestoneassignment.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by RyuBomee on 2017. 12. 6..
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;


    protected abstract int getContentView();
    protected abstract void injectViews();          //ButterKnife를 사용할 메소드
    protected abstract void registerHandler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mContext = this;

        injectViews();
        registerHandler();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
