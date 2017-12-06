package com.example.ryubomee.olivestoneassignment.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.ryubomee.olivestoneassignment.Adapter.HistoryRecycleAdapter;
import com.example.ryubomee.olivestoneassignment.R;
import com.example.ryubomee.olivestoneassignment.base.BaseActivity;
import com.example.ryubomee.olivestoneassignment.data.HistoryData;
import com.example.ryubomee.olivestoneassignment.presenters.HistoryContract;
import com.example.ryubomee.olivestoneassignment.presenters.HistoryPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class HistoryActivity extends BaseActivity implements HistoryContract.View {

    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindView(R.id.text_top_title)
    TextView textTopTitle;
    @BindView(R.id.top_bar)
    LinearLayout topBar;
    @BindView(R.id.listView)
    RecyclerView listView;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    private HistoryPresenter historyPresenter;

    private RecyclerView recyclerView;
    private HistoryRecycleAdapter adapter;
    Realm realm;

    @Override
    protected int getContentView() {
        return R.layout.activity_history;
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
        historyPresenter = new HistoryPresenter();
        historyPresenter.attachView(this);
        realm = Realm.getDefaultInstance();
        try {
            setUpRecyclerView();
        } finally {
            realm.close();
        }

    }

    private void setUpRecyclerView() {
        adapter = new HistoryRecycleAdapter(realm.where(HistoryData.class).findAll(),true);
        listView.setLayoutManager(new LinearLayoutManager(mContext));
        listView.setAdapter(adapter);
        listView.setHasFixedSize(true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        historyPresenter.detachView();
    }
}
