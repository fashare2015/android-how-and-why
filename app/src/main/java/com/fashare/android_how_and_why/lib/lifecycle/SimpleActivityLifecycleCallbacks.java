package com.fashare.android_how_and_why.lib.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * author : jinliangshan
 * e-mail : liangshan.jin@ximalaya.com
 * date   : 2018/12/29
 * desc   :
 */
public class SimpleActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks{
    private static final String TAG = Lifecycle.TAG;

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.d(TAG, activity.getClass().getSimpleName() + "onCreate");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.d(TAG, activity.getClass().getSimpleName() + "onStart");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.d(TAG, activity.getClass().getSimpleName() + "onResume");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.d(TAG, activity.getClass().getSimpleName() + "onPause");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.d(TAG, activity.getClass().getSimpleName() + "onStop");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.d(TAG, activity.getClass().getSimpleName() + "onSaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.d(TAG, activity.getClass().getSimpleName() + "onDestroyed");
    }
}
