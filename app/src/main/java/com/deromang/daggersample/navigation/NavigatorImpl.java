package com.deromang.daggersample.navigation;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.deromang.daggersample.R;
import com.deromang.daggersample.domain.data.Product;
import com.deromang.daggersample.ui.detail.DetailFragment;
import com.deromang.daggersample.ui.activity.MainActivity;
import com.deromang.daggersample.ui.product.ProductListFragment;


/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 7/4/19.
 */
public class NavigatorImpl implements Navigator {

    public final static int CONTAINER_ID = R.id.container;


    private AppCompatActivity activity;

    public NavigatorImpl(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void goToHomeScreen(Product product) {

        activity.getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        replaceFragment(DetailFragment.newInstance(product), true);


    }

    @Override
    public void goBack() {
        Intent intent = new Intent(activity, MainActivity.class);

        activity.startActivity(intent);

    }

    @Override
    public void goToProductScreen() {
        activity.getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        replaceFragment(ProductListFragment.newInstance(), false);

    }

    @Override
    public void onBackPressed() {
        activity.getSupportFragmentManager().popBackStackImmediate();
    }

    private void replaceFragment(Fragment fragment, boolean addToBack) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (addToBack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.replace(CONTAINER_ID, fragment);
        fragmentTransaction.commit();
    }


}