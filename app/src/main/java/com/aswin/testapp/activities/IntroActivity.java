package com.aswin.testapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.aswin.testapp.R;
import com.aswin.testapp.base.BaseActivity;

public class IntroActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }
}
