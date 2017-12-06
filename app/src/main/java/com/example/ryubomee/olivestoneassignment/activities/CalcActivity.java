package com.example.ryubomee.olivestoneassignment.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ryubomee.olivestoneassignment.R;
import com.example.ryubomee.olivestoneassignment.base.BaseActivity;

import java.util.stream.Stream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CalcActivity extends BaseActivity {


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

    }

    @OnClick(R.id.btn_execution)
    public void onViewClicked() {
//        Log.d("sherry test","clicked go buton");
//        Log.d("sherry test",editInput.getText().toString());
        long num = Long.parseLong(editInput.getText().toString());
        textResult.setText(Long.toString(fibonacci(num))); //show result of execution
    }

    public long fibonacci(long num) {
        long result = Stream.iterate(new long[] {1, 1}, f -> new long[] {f[1], f[0] + f[1]})
                .limit(num)
                .reduce((a, b) -> b)
                .get()[0];

        return result;
    }
}
