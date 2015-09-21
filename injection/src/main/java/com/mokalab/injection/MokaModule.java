package com.mokalab.injection;

/**
 * Created by antonio on 14/05/15.
 */


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Injection for Activities. You need to add the activity name here if you ever call ObjectGraph.inject(this) from an Activity or you will get an exception.
 * <p/>
 */
@Module (
        // Note: we can get rid of injects= when dagger 2.0 is released.
        injects = {
        },
        includes = {
        },
        complete = false,
        library = true
)
public class MokaModule {
    private final Context mContext;

    public MokaModule(Application application) {
        mContext = application.getApplicationContext();
    }

    /**
     * Allow the application context to be injected but require that it be annotated with {@link ForApplication @ForApplication} to explicitly differentiate it
     * from an activity context.
     */
    @Provides
    @Singleton @ForApplication
    Context provideApplicationContext() {
        return mContext;
    }
}
