package com.example.ryubomee.olivestoneassignment.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ryubomee.olivestoneassignment.R;
import com.example.ryubomee.olivestoneassignment.base.BaseActivity;

import butterknife.ButterKnife;

public class HistoryActivity extends BaseActivity{

    @Override
    protected int getContentView() {
        return R.layout.activity_history;
    }

    @Override
    protected void injectViews() {
        ButterKnife.inject(this);
    }

    @Override
    protected void registerHandler() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
