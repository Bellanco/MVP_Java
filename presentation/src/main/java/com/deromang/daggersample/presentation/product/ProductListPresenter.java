package com.deromang.daggersample.presentation.product;

import com.deromang.daggersample.domain.data.Product;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 7/4/19.
 */
public interface ProductListPresenter {

    void setView(ProductListView view);

    void goToDetails(Product product);

    void requestData();

    void onTextChanged(CharSequence value);
}
