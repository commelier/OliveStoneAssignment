package com.example.ryubomee.olivestoneassignment.presenters;

/**
 * Created by RyuBomee on 2017. 12. 7..
 */

public class CalcPresenter implements CalcContract.Presenter {

    private CalcContract.View view;



    @Override
    public void attachView(CalcContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
