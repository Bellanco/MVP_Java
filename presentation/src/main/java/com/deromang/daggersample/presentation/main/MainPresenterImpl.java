package com.deromang.daggersample.presentation.main;

import com.deromang.daggersample.domain.data.Product;
import com.deromang.daggersample.domain.data.ProductList;
import com.deromang.daggersample.domain.modules.api.APIClient;
import com.deromang.daggersample.domain.modules.api.APIService;
import com.deromang.daggersample.navigation.Navigator;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 7/4/19.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView view;

    private Navigator navigator;

    @Inject
    public MainPresenterImpl(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void setView(MainView view) {
        this.view = view;
    }

    @Override
    public void initialize() {
        navigator.goToProductScreen();
    }

    @Override
    public void onBackPressed() {
        navigator.onBackPressed();
    }

}
