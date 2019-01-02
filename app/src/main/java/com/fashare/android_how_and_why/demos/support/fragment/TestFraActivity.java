package com.fashare.android_how_and_why.demos.support.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fashare.android_how_and_why.R;
import com.fashare.android_how_and_why.lib.base.BaseFragment;
import com.fashare.android_how_and_why.lib.util.ViewUtil;

public class TestFraActivity extends AppCompatActivity {

    private static final String FRA_TAG_ROOT = "FRA_TAG_ROOT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fra);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fra_container, new RootFragment(), FRA_TAG_ROOT)
//                .addToBackStack("")
                .commit();
    }

    public static class RootFragment extends BaseFragment {
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
                        .add(R.id.fra_container, NumFragment.newInstance(0), FRA_TAG_ROOT)
                        .addToBackStack("")
                        .commit();
            });
        }
    }
}
