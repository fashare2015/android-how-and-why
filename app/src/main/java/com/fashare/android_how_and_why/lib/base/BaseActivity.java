package com.fashare.android_how_and_why.lib.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.fashare.android_how_and_why.lib.lifecycle.Lifecycle;

public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(Lifecycle.TAG, this.getClass().getSimpleName() + " onRestoreInstanceState");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(Lifecycle.TAG, this.getClass().getSimpleName() + " onNewIntent");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d(Lifecycle.TAG, this.getClass().getSimpleName() + " onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.d(Lifecycle.TAG, this.getClass().getSimpleName() + " onTrimMemory");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(Lifecycle.TAG, this.getClass().getSimpleName() + " onConfigurationChanged");
    }

    protected void start(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }
}
