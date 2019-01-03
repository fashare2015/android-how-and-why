package com.fashare.android_how_and_why.lib.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fashare.android_how_and_why.lib.lifecycle.Lifecycle;

public class BaseFragment extends Fragment {

    protected String getName() {
        return this.getClass().getSimpleName();
    }

    // ---- 生命周期 ----
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(Lifecycle.TAG, getName() + " onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Lifecycle.TAG, getName() + " onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(Lifecycle.TAG, getName() + " onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(Lifecycle.TAG, getName() + " onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(Lifecycle.TAG, getName() + " onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(Lifecycle.TAG, getName() + " onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(Lifecycle.TAG, getName() + " onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(Lifecycle.TAG, getName() + " onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(Lifecycle.TAG, getName() + " onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Lifecycle.TAG, getName() + " onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(Lifecycle.TAG, getName() + " onDetach");
    }
    // ---- 生命周期 ----

    // ---- 懒加载 ----
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(Lifecycle.TAG, getName() + " setUserVisibleHint " + isVisibleToUser);
    }
    // ---- 懒加载 ----

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(Lifecycle.TAG, getName() + " onSaveInstanceState");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(Lifecycle.TAG, getName() + " onHiddenChanged");
    }
}
