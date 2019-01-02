package com.fashare.android_how_and_why.demos.support.fragment.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fashare.android_how_and_why.R;
import com.fashare.android_how_and_why.lib.base.BaseFragment;

public class SubFragment extends BaseFragment {
    private int mIndex = 5;

    private TextView mTvNum;

    public static SubFragment newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        SubFragment fragment = new SubFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            mIndex = getArguments().getInt("index", mIndex);
        }
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return LayoutInflater.from(getContext()).inflate(R.layout.fra_sub, container, false);
    }

    @Override
    public void onViewCreated(View parent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(parent, savedInstanceState);

        mTvNum = parent.findViewById(R.id.tv_num);
        mTvNum.setText(String.valueOf(mIndex));
    }
}
