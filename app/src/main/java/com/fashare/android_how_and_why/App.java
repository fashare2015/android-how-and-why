package com.fashare.android_how_and_why;

import android.app.Application;

import com.fashare.android_how_and_why.lib.lifecycle.SimpleActivityLifecycleCallbacks;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        registerActivityLifecycleCallbacks(new SimpleActivityLifecycleCallbacks());
    }
}
