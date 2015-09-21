package com.mokalab.injection;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;

import dagger.ObjectGraph;

/**
 * Created by antonio on 21/09/15.
 * helper class for the application graph
 */
public class Injector {
    public static void init(Application application, Object... daggerModules){
        ArrayList<Object> modulesList=new ArrayList<Object>(Arrays.asList(daggerModules));
        modulesList.add(new MokaModule(application));
        ObjectGraph graph = ObjectGraph.create(modulesList.toArray());
        graph.inject(application);
        graph.injectStatics();
        ApplicationGraph.setObjectGraph(graph);
    }

    public static void inject(Object toInject){
        ApplicationGraph.getObjectGraph().inject(toInject);
    }

    public static <T> T fromInject(Class<T> classOfT){
        return ApplicationGraph.getObjectGraph().get(classOfT);
    }
}
