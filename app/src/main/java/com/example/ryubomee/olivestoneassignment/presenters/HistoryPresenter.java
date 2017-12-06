package com.example.ryubomee.olivestoneassignment.presenters;

import android.content.Context;

import com.example.ryubomee.olivestoneassignment.data.HistoryData;

/**
 * Created by RyuBomee on 2017. 12. 6..
 */

public class HistoryPresenter implements HistoryContract.Presenter {

    private HistoryContract.View view;
    private HistoryData historyData;
    @Override
    public void attachView(HistoryContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        view = null;

    }

    @Override
    public void setHistoryData(HistoryData historyData) {
        this.historyData = historyData;
    }

    @Override
    public void loadHistory(Context context) {
//        historyData.getList(context);
    }
}
