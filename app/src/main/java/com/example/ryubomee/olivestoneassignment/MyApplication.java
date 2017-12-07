package com.example.ryubomee.olivestoneassignment;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by RyuBomee on 2017. 12. 7..
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("realmHistory,realm").build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getDefaultInstance();
    }
}
