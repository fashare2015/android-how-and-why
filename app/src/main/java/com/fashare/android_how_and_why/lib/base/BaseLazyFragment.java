package com.fashare.android_how_and_why.lib.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.fashare.android_how_and_why.lib.lifecycle.Lifecycle;

public class BaseLazyFragment extends BaseFragment {
    private boolean mUserVisibleHint = true;

    private boolean mIsViewPrepared;
    private boolean mIsInited;

    public void setInited(boolean inited) {
        mIsInited = inited;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        mIsViewPrepared = true;
        mIsInited = false;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mUserVisibleHint = isVisibleToUser;
        if (isVisibleToUser) {
            lazyLoad();
        }
    }

    /**
     * 这个接口有Bug，有时候不准确
     */
    @Override
    public boolean getUserVisibleHint() {
//        return super.getUserVisibleHint();
        return mUserVisibleHint;
    }

    private void lazyLoad() {
        Log.d(Lifecycle.TAG, getName() + " lazyLoad() " + "isVisibleToUser = " + getUserVisibleHint()
                + ", mIsViewPrepared = " + mIsViewPrepared + ", mIsInited = " + mIsInited);
        if (getUserVisibleHint() && mIsViewPrepared && !mIsInited) {
            loadData();
        }
    }

    protected void initView() {

    }

    protected void loadData() {

    }
}
