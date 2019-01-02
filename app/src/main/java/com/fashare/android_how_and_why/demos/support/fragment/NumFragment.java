package com.fashare.android_how_and_why.demos.support.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fashare.android_how_and_why.R;
import com.fashare.android_how_and_why.lib.base.BaseFragment;
import com.fashare.android_how_and_why.lib.util.ViewUtil;

public class NumFragment extends BaseFragment {
    private int mNum = -1;
    private boolean mIsReplace = false;

    public static NumFragment newInstance(int num, boolean isReplace) {
        Bundle args = new Bundle();
        args.putInt("num", num);
        args.putBoolean("isReplace", isReplace);
        NumFragment fragment = new NumFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected String getName() {
        return String.valueOf(mNum);
    }

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            mNum = getArguments().getInt("num", -1);
            mIsReplace = getArguments().getBoolean("isReplace", false);
        }
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return LayoutInflater.from(getContext()).inflate(R.layout.fra_num, container, false);
    }

    @Override
    public void onViewCreated(View parent, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(parent, savedInstanceState);

        parent.<TextView>findViewById(R.id.tv_num).setText(getName());

        ViewGroup root = parent.findViewById(R.id.layout_root);
        if (!mIsReplace) {
            ViewUtil.addView(root, "add next by add", view -> {
                getFragmentManager().beginTransaction()
                        .add(R.id.fra_container, newInstance(mNum + 1, mIsReplace))
                        .addToBackStack("")
                        .commit();
            });

//            ViewUtil.addView(root, "remove this by remove", view -> {
//                getFragmentManager().beginTransaction()
//                        .remove(this)
//                        .addToBackStack("")
//                        .commit();
//            });

            ViewUtil.addView(root, "remove this by popBackStack", view -> {
                getFragmentManager().popBackStack();
            });

        } else {
            ViewUtil.addView(root, "add next by replace", view -> {
                getFragmentManager().beginTransaction()
                        .replace(R.id.fra_container, newInstance(mNum + 1, mIsReplace))
                        .addToBackStack("")
                        .commit();
            });

            ViewUtil.addView(root, "remove this by popBackStack", view -> {
                getFragmentManager().popBackStack();
            });
        }
    }
}
