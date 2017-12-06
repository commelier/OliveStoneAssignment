package com.example.ryubomee.olivestoneassignment.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ryubomee.olivestoneassignment.R;
import com.example.ryubomee.olivestoneassignment.Utils.NavigationUtils;
import com.example.ryubomee.olivestoneassignment.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * 1. 텍스트 입력창에서 임의의 수를 입력 받을 것 //
 * 2. 입력받은 수에 대한 피보나치 수의 결과를 출력할 것
 * 3. 결과값이 숫자형태로 표현될 것 오류값 나오지 않게 하기
 * 4. 입력 및 결과 히스토리를 내부DB에 적재하고 메뉴를 통해 볼수 있을 것
 * 5. strings, colors,styles 활용 (styles 활용 아직 안 함)
 * 6. 소스 내 주석 설명 혹은 깃 로그 메세지 (한글 사용금지)
 * 7. 깃플로우 활용
 * 8. java8의 기능 활용 (stream, lamda)
 * 9. mvp모델 사용
 * 10.junit을 활용한 testcode작성
 * <p>
 * Created by BomeeRyu on 2017.12.06
 */
public class MainActivity extends BaseActivity {


    @InjectView(R.id.btn_go_to_cal)
    Button btnGoToCal;
    @InjectView(R.id.btn_cal_history)
    Button btnCalHistory;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
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

    @OnClick({R.id.btn_go_to_cal, R.id.btn_cal_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_go_to_cal:
                NavigationUtils.goCalcActivity(mContext);
                break;
            case R.id.btn_cal_history:
                NavigationUtils.goHistoryActivity(mContext);
                break;
        }
    }
}
