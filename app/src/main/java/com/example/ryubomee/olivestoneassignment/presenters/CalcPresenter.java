package com.example.ryubomee.olivestoneassignment.presenters;

import com.example.ryubomee.olivestoneassignment.data.HistoryData;

import io.realm.Realm;

/**
 * Created by RyuBomee on 2017. 12. 7..
 *
 * show something while executing programs
 *
 */

public class CalcPresenter implements CalcContract.Presenter {

    private CalcContract.View view;
    HistoryData historyData = new HistoryData();
    Realm realm = Realm.getDefaultInstance();
    long result;

    @Override
    public void attachView(CalcContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void calcFibo(long num) {
        result = historyData.getCalcFibo(num);
    }

    @Override
    public long getFiboResult() {
        return result;
    }

    @Override
    public void saveHistory(long input, long result) {
        realm.beginTransaction();
        HistoryData historyDataS = realm.createObject(HistoryData.class);
        historyDataS.setInput(input);
        historyDataS.setResult(result);
        realm.commitTransaction();
    }

}
