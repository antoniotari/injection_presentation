package com.antoniotari.daggerexample;

import com.mokalab.injection.Injector;

/**
 * Created by antonio on 21/09/15.
 */
public abstract class MyReader {

    public MyReader(){
        Injector.inject(this);
    }

    public abstract String readText();
}
