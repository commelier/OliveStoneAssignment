package com.example.ryubomee.olivestoneassignment.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ryubomee.olivestoneassignment.R;
import com.example.ryubomee.olivestoneassignment.Utils.NavigationUtils;
import com.example.ryubomee.olivestoneassignment.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by BomeeRyu on 2017.12.06
 */

public class MainActivity extends BaseActivity{



    @BindView(R.id.btn_go_to_cal)
    Button btnGoToCal;
    @BindView(R.id.btn_cal_history)
    Button btnCalHistory;


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void injectViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void registerHandler() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.btn_go_to_cal, R.id.btn_cal_history})
    public void onViewClicked(View view) {
        //if you click go to calcution btn, goCalcActivity will appears the other one is for historyActivity.
        switch (view.getId()) {
            case R.id.btn_go_to_cal:
                NavigationUtils.goCalcActivity(mContext);
                break;
            case R.id.btn_cal_history:
                NavigationUtils.goHistoryActivity(mContext);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
