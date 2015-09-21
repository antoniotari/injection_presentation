package com.antoniotari.daggerexample;

import com.mokalab.injection.Injector;

import android.app.Application;

/**
 * Created by antonio on 21/09/15.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.init(this, new MyModule(this));
    }
}