package com.fashare.android_how_and_why.demos.app.activity.lifecycle;

import android.os.Bundle;
import android.widget.TextView;

import com.fashare.android_how_and_why.R;
import com.fashare.android_how_and_why.lib.base.BaseActivity;

public class Test2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        this.<TextView>findViewById(R.id.tv_test).setText("test2");
    }
}
