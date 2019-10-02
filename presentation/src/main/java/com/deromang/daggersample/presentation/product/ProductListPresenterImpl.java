package com.deromang.daggersample.presentation.product;

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
public class ProductListPresenterImpl implements ProductListPresenter {

    private ProductListView view;

    private Navigator navigator;

    private APIService mApiService;

    private List<Product> productList;

    @Inject
    public ProductListPresenterImpl(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void setView(ProductListView view) {
        this.view = view;

    }

    public void goToDetails(Product product) {
        navigator.goToHomeScreen(product);
    }

    @Override
    public void requestData() {
        mApiService = APIClient.getAPIService();
    }

    @Override
    public void onTextChanged(CharSequence value) {
        mApiService.showInformation(String.valueOf(value)).enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                productList = response.body().getProducts();
                view.notifyDataSetChanged(productList);
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable throwable) {

            }
        });

    }
}
