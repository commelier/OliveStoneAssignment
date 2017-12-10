package com.example.ryubomee.olivestoneassignment.presenters;

/**
 * Created by RyuBomee on 2017. 12. 7..
 *
 * this class is for making presenter & view interface
 *
 */

public interface CalcContract {

    interface  View{

    }

    interface Presenter {

        void attachView(CalcContract.View view);

        void detachView();

        void calcFibo(long num);

        long getFiboResult();

        void saveHistory(long input, long result);
    }
}
