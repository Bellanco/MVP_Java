package com.deromang.daggersample.navigation;

import com.deromang.daggersample.domain.data.Product;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 7/4/19.
 */
public interface Navigator {

    void goToHomeScreen(Product product);

    void goBack();

    void goToProductScreen();

    void onBackPressed();
}