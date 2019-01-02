package com.fashare.android_how_and_why.demos.support.fragment.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fashare.android_how_and_why.R;
import com.fashare.android_how_and_why.lib.base.BaseFragment;

public class ViewPagerFragment extends BaseFragment {
    private int mNum = 10;

    private TabLayout mTab;
    private ViewPager mViewPager;

    public static ViewPagerFragment newInstance(int num) {
        Bundle args = new Bundle();
        args.putInt("num", num);
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            mNum = getArguments().getInt("num", mNum);
        }
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return LayoutInflater.from(getContext()).inflate(R.layout.fra_viewpager, container, false);
    }

    @Override
    public void onViewCreated(View parent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(parent, savedInstanceState);

        mTab = parent.findViewById(R.id.tab);
        mViewPager = parent.findViewById(R.id.vp);

        mViewPager.setOffscreenPageLimit(3);

        mViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return SubFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return mNum;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position + "";
            }
        });

        mTab.setupWithViewPager(mViewPager);
    }
}
