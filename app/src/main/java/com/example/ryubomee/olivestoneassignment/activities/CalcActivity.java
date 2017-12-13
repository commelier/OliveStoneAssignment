package com.example.ryubomee.olivestoneassignment.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryubomee.olivestoneassignment.R;
import com.example.ryubomee.olivestoneassignment.Utils.NavigationUtils;
import com.example.ryubomee.olivestoneassignment.base.BaseActivity;
import com.example.ryubomee.olivestoneassignment.data.HistoryData;
import com.example.ryubomee.olivestoneassignment.presenters.CalcContract;
import com.example.ryubomee.olivestoneassignment.presenters.CalcPresenter;

import java.util.stream.Stream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;


public class CalcActivity extends BaseActivity implements CalcContract.View {

    @BindView(R.id.btn_back)
    ImageButton btnBack;
    private CalcPresenter calcPresenter;
    Realm realm = Realm.getDefaultInstance();
    @BindView(R.id.edit_input)
    EditText editInput;
    @BindView(R.id.btn_execution)
    Button btnExecution;
    @BindView(R.id.text_result)
    TextView textResult;

    @Override
    protected int getContentView() {
        return R.layout.activity_calc;
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

        //setting presenter

        calcPresenter = new CalcPresenter();
        calcPresenter.attachView(this);


    }

    @OnClick(R.id.btn_execution)
    public void onViewClicked() {
        long num = Integer.parseInt(editInput.getText().toString());
        try {
            textResult.setText(Long.toString(fibonacci(num))); //show result of execution
        }catch (Exception e){
            Log.d("bomee","error : "+e.getMessage());
            Toast.makeText(mContext,"계산 할 수 없는 수입니다. 음수와 표현할 수 없는 큰 수는 계산 불가",Toast.LENGTH_SHORT).show();
        }
    }

    public long fibonacci(long num) {
        calcPresenter.calcFibo(num);
        long result = calcPresenter.getFiboResult();

        try {
            Log.d("bomee", "add  - " + result);
            calcPresenter.saveHistory(num, result);

        } catch (Exception e) {
            Log.d("bomee", e.getMessage());
        }
        return result;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //detach the view
        calcPresenter.detachView();
    }

    @OnClick(R.id.btn_back)
    public void onBackBtnClicked() {

        //go to MainActivity
        NavigationUtils.goMainActivity(mContext);
    }
}
