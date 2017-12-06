package com.example.ryubomee.olivestoneassignment.Utils;

import android.content.Context;
import android.content.Intent;

import com.example.ryubomee.olivestoneassignment.activities.CalcActivity;
import com.example.ryubomee.olivestoneassignment.activities.HistoryActivity;
import com.example.ryubomee.olivestoneassignment.activities.MainActivity;

/**
 * Created by RyuBomee on 2017. 12. 7..
 */

public class NavigationUtils {

    public static void goHistoryActivity(Context context){
        Intent intent = new Intent (context, HistoryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void goCalcActivity(Context context){
        Intent intent = new Intent (context, CalcActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void goMainActivity(Context context){
        Intent intent = new Intent (context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
