package com.fashare.android_how_and_why.demos.support.fragment.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fashare.android_how_and_why.R;
import com.fashare.android_how_and_why.lib.base.BaseLazyFragment;

public class SubFragment extends BaseLazyFragment {
    private int mIndex = 5;

    private SwipeRefreshLayout mRefreshLayout;
    private TextView mTvNum;

    // Log 调试用
    public void setIndex(int index) {
        mIndex = index;
    }

    public static SubFragment newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        SubFragment fragment = new SubFragment();
        fragment.setArguments(args);
        fragment.setIndex(index);   // Log 调试用
        return fragment;
    }

    @Override
    protected String getName() {
        return "SubFragment #" + mIndex;
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
    protected void initView() {
        super.initView();
        mRefreshLayout = getView().findViewById(R.id.layout_root);
        mTvNum = getView().findViewById(R.id.tv_num);

        mRefreshLayout.setOnRefreshListener(this::loadData);
    }

    @Override
    protected void loadData() {
        super.loadData();
        mRefreshLayout.setRefreshing(true);
        mRefreshLayout.postDelayed(() -> {
            setInited(true);
            mRefreshLayout.setRefreshing(false);
            mTvNum.setText(String.valueOf(mIndex));
        }, 500);
    }
}
