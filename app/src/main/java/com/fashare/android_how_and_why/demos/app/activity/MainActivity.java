package com.fashare.android_how_and_why.demos.app.activity;

import android.os.Bundle;
import android.view.ViewGroup;

import com.fashare.android_how_and_why.R;
import com.fashare.android_how_and_why.demos.app.activity.lifecycle.Test1Activity;
import com.fashare.android_how_and_why.demos.support.fragment.TestFraActivity;
import com.fashare.android_how_and_why.lib.base.BaseActivity;
import com.fashare.android_how_and_why.lib.util.ViewUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup root = this.findViewById(R.id.layout_root);
        ViewUtil.addView(root, "activity lifecycle", view -> start(Test1Activity.class));
        ViewUtil.addView(root, "fragment lifecycle", view -> start(TestFraActivity.class));
    }
}
