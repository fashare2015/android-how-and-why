package com.fashare.android_how_and_why.demos.app.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fashare.android_how_and_why.R;
import com.fashare.android_how_and_why.demos.app.activity.lifecycle.Test1Activity;
import com.fashare.android_how_and_why.lib.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup root = this.<ViewGroup>findViewById(R.id.layout_root);
        addView(root, "lifecycle", view -> start(Test1Activity.class));
    }

    public static void addView(ViewGroup viewGroup, String btnText, View.OnClickListener onClickListener) {
        Button btn = new Button(viewGroup.getContext());
        btn.setText(btnText);
        btn.setOnClickListener(onClickListener);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        lp.topMargin = 60;
        viewGroup.addView(btn, lp);
    }
}
