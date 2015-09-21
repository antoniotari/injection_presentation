package com.antoniotari.daggerexample;

import com.mokalab.injection.ForApplication;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anthony on 9/19/15.
 */

@Module (
        injects = {
                MyApplication.class,
                MainActivity.class,
                TemplateSingleton.class
        },
        includes = {
        },
        complete = false,
        library=true
)
public class MyModule {

    private final Application mApplication;

    public MyModule(Application application) {
        mApplication = application;
    }

    @Provides @Singleton @ForApplication
    Application provideApplication() {
        return mApplication;
    }

    @Provides @Singleton
    TemplateSingleton provideTemplateSingleton(@ForApplication Context context){
        return new TemplateSingleton(context);
    }
}