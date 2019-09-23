package com.deromang.daggersample.domain.data;

import java.util.List;

public class ProductList {

    private List<Product> results;

    public ProductList(List<Product> products) {
        this.results = products;
    }

    public List<Product> getProducts() {
        return results;
    }

    public void setProducts(List<Product> products) {
        this.results = products;
    }
}
