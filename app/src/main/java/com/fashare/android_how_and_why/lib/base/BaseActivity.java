package com.fashare.android_how_and_why.lib.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.fashare.android_how_and_why.lib.lifecycle.Lifecycle;

/**
 * author : jinliangshan
 * e-mail : liangshan.jin@ximalaya.com
 * date   : 2018/12/29
 * desc   :
 */
public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(Lifecycle.TAG, this.getClass().getSimpleName() + "onRestoreInstanceState");
    }

    protected void start(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }
}
