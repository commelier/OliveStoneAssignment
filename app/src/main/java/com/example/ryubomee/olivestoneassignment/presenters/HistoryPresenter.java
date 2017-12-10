package com.example.ryubomee.olivestoneassignment.presenters;

import android.content.Context;

import com.example.ryubomee.olivestoneassignment.data.HistoryData;

/**
 * Created by RyuBomee on 2017. 12. 6..
 */

public class HistoryPresenter implements HistoryContract.Presenter {

    private HistoryContract.View view;

    @Override
    public void attachView(HistoryContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

        view = null;

    }

}
