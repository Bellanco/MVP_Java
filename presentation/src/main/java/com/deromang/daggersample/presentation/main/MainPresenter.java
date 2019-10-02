package com.deromang.daggersample.presentation.main;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 7/4/19.
 */
public interface MainPresenter {

    void setView(MainView view);

    void initialize();

    void onBackPressed();
}
