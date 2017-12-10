package com.example.ryubomee.olivestoneassignment.presenters;

import android.content.Context;

import com.example.ryubomee.olivestoneassignment.data.HistoryData;

/**
 * Created by RyuBomee on 2017. 12. 7..
 *
 * this class is for making presenter & view interface
 *
 *
 */

public interface HistoryContract {
    interface View{

    }

    interface Presenter{

        void attachView (View view);

        void detachView ();

    }
}
