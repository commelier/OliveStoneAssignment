package com.example.ryubomee.olivestoneassignment.data;

import android.content.Context;

import java.util.stream.Stream;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by RyuBomee on 2017. 12. 6..
 *
 * this models is about information what you have to save
 *
 */

public class HistoryData extends RealmObject{
    public long input;

    public long getInput() {
        return input;
    }

    public void setInput(long input) {
        this.input = input;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    public long result;

    public static long getCalcFibo(long num){
        long longResult = Stream.iterate(new long[]{1, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .limit(num)
                .reduce((a, b) -> b)
                .get()[0];
        long result = Integer.parseInt(Long.toString(longResult));
        return result;
    }



}
