package com.antoniotari.daggerexample;

import com.mokalab.injection.Injector;

import android.content.Context;

/**
 * Created by anthony on 9/19/15.
 */
public class TemplateSingleton {

    private Context mApplicationContext;

    private static int sInstanceCounter=0;

    public TemplateSingleton(Context context) {
        Injector.inject(this);
        if(++sInstanceCounter > 1)throw new RuntimeException("this is a singleton, please inject or use getInstance");
        mApplicationContext = context;
    }

    public static TemplateSingleton getInstance() {
        return Injector.fromInject(TemplateSingleton.class); //ApplicationGraph.getObjectGraph().get(TemplateSingleton.class);
    }

    public String getPackageName(){
        return mApplicationContext.getPackageName();
    }
}
