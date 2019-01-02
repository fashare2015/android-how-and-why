package com.fashare.android_how_and_why.lib.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ViewUtil {

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
