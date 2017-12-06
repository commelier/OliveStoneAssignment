package com.example.ryubomee.olivestoneassignment.presenters;

import android.content.Context;


/**
 * Created by RyuBomee on 2017. 12. 6..
 */

public class BasePresenter{

//    protected T1 view;
    protected Context mContext;

    public void onDestroy()
    {
//        this.view = null;
        mContext = null;
    }
}
