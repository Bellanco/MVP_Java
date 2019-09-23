package com.deromang.daggersample.presentation.product;

import com.deromang.daggersample.domain.data.Product;

import java.util.List;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 7/4/19.
 */
public interface ProductListView {

    void notifyDataSetChanged(List<Product> productList);
}
