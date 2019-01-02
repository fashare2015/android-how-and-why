package com.fashare.android_how_and_why.demos.support.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fashare.android_how_and_why.R;
import com.fashare.android_how_and_why.lib.base.BaseFragment;
import com.fashare.android_how_and_why.lib.util.ViewUtil;

public class TestFraActivity extends AppCompatActivity {

    private static final String FRA_TAG_ROOT = "FRA_TAG_ROOT";
    private static final String FRA_TAG_SHOW_HIDE = "FRA_TAG_SHOW_HIDE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fra);

        // 判空，内存重启时防止视图重叠
        if (getSupportFragmentManager().findFragmentByTag(FRA_TAG_ROOT) == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fra_container, new RootFragment(), FRA_TAG_ROOT)
//                .addToBackStack("")
                    .commit();
        }
    }

    public static class RootFragment extends BaseFragment {
        private Fragment mShowHideFragment;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            return LayoutInflater.from(getContext()).inflate(R.layout.fra_test_root, container, false);
        }

        @Override
        public void onViewCreated(View parent, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(parent, savedInstanceState);

            ViewGroup root = parent.findViewById(R.id.layout_root);
            ViewUtil.addView(root, "start NumFragment by add", view -> {
                getFragmentManager().beginTransaction()
                        .add(R.id.fra_container, NumFragment.newInstance(0, false))
                        .addToBackStack("")
                        .commit();
            });

            ViewUtil.addView(root, "start NumFragment by replace", view -> {
                getFragmentManager().beginTransaction()
                        .replace(R.id.fra_container, NumFragment.newInstance(0, true))
                        .addToBackStack("")
                        .commit();
            });

            mShowHideFragment = getChildFragmentManager().findFragmentByTag(FRA_TAG_SHOW_HIDE);
            if (mShowHideFragment == null) {
                mShowHideFragment = new ShowHideFragment();
                getChildFragmentManager().beginTransaction()
                        .add(R.id.container_show_hide, mShowHideFragment, FRA_TAG_SHOW_HIDE)
                        .commit();
            }

            ViewUtil.addView(root, "show showHideFragment", view -> {
                if (mShowHideFragment == null)
                    return;
                getChildFragmentManager().beginTransaction()
                        .show(mShowHideFragment)
                        .commit();
            });

            ViewUtil.addView(root, "hide showHideFragment", view -> {
                if (mShowHideFragment == null)
                    return;
                getChildFragmentManager().beginTransaction()
                        .hide(mShowHideFragment)
                        .commit();
            });
        }
    }


    public static class ShowHideFragment extends BaseFragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            View view = new View(getContext());
            view.setBackgroundResource(R.color.colorAccent);
            return view;
        }
    }
}
