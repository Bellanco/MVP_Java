package com.deromang.daggersample.ui;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.deromang.daggersample.R;
import com.deromang.daggersample.deromang.modules.base.ActivityComponent;
import com.deromang.daggersample.presentation.BaseView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;

/**
 *
 * @author deromang.
 * @version 1.0.
 * @since 8/4/19.
 */
public abstract class BaseFragment extends Fragment implements BaseView {

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResId(), container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        prepareInjection();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    protected abstract int getLayoutResId();

    protected abstract void prepareInjection();

    public final ActivityComponent getActivityComponent() {
        ActivityComponent component = null;
        if (getActivity() instanceof BaseActivity) {
            component = ((BaseActivity) getActivity()).getActivityComponent();
        }
        return component;
    }
}
