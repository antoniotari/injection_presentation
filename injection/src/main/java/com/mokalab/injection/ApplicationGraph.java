package com.mokalab.injection;

import dagger.ObjectGraph;

/**
 * ObjectGraph set by the Application on app start.
 *
 * Created by Antonio Tari
 */
public class ApplicationGraph {

    private static ObjectGraph mObjectGraph;

    public static ObjectGraph getObjectGraph() {
        if (mObjectGraph == null) {
            throw new IllegalStateException("ObjectGraph has not been set");
        }
        return mObjectGraph;
    }

    public static void setObjectGraph(ObjectGraph objectGraph) {
        mObjectGraph = objectGraph;
    }
}
