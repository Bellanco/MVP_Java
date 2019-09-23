package com.deromang.daggersample.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.deromang.daggersample.R;
import com.deromang.daggersample.deromang.modules.presentation.main.MainComponent;
import com.deromang.daggersample.deromang.modules.presentation.main.MainModule;
import com.deromang.daggersample.presentation.main.MainPresenter;
import com.deromang.daggersample.presentation.main.MainView;
import com.deromang.daggersample.ui.BaseActivity;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter presenter;

    private MainComponent mainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponent() {
        mainComponent = getActivityComponent()
                .mainComponent()
                .mainModule(new MainModule())
                .build();

        mainComponent.inject(this);

        presenter.setView(this);

        presenter.initialize();

    }

    @Override
    public void onBackPressed() {
        presenter.onBackPressed();
    }
}
