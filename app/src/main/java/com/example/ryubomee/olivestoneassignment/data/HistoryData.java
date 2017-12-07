package com.example.ryubomee.olivestoneassignment.data;

import android.content.Context;

import io.realm.RealmObject;

/**
 * Created by RyuBomee on 2017. 12. 6..
 *
 * this models is about information what you have to save
 *
 */

public class HistoryData extends RealmObject{
    public int input;

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int result;

//    public void getList(Context context) {
//
//    }
}
