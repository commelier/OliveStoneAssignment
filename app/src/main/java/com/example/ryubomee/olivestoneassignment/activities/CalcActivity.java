package com.example.ryubomee.olivestoneassignment.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ryubomee.olivestoneassignment.R;
import com.example.ryubomee.olivestoneassignment.base.BaseActivity;
import com.example.ryubomee.olivestoneassignment.data.HistoryData;
import com.example.ryubomee.olivestoneassignment.presenters.CalcContract;
import com.example.ryubomee.olivestoneassignment.presenters.CalcPresenter;

import java.util.stream.Stream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;


public class CalcActivity extends BaseActivity implements CalcContract.View{

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
        calcPresenter = new CalcPresenter();
        calcPresenter.attachView(this);



    }

    @OnClick(R.id.btn_execution)
    public void onViewClicked() {
//        Log.d("sherry test","clicked go buton");
//        Log.d("sherry test",editInput.getText().toString());
        int num = Integer.parseInt(editInput.getText().toString());
        textResult.setText(Long.toString(fibonacci(num))); //show result of execution
    }

    public int fibonacci(int num) {
        long longResult = Stream.iterate(new long[] {1, 1}, f -> new long[] {f[1], f[0] + f[1]})
                .limit(num)
                .reduce((a, b) -> b)
                .get()[0];
        int result = Integer.parseInt(Long.toString(longResult));
        try{
            Log.d("bomee","add  - "+result);
        realm.beginTransaction();
        HistoryData historyData = realm.createObject(HistoryData.class);
        historyData.setInput(num);
        historyData.setResult(result);
        realm.commitTransaction();

        }
        catch (Exception e)
        {
            Log.d("bomee",e.getMessage());
        }
        return result;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        calcPresenter.detachView();
    }
}
