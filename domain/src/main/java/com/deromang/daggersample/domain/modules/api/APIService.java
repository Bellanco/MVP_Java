package com.deromang.daggersample.domain.modules.api;

import com.deromang.daggersample.domain.data.Product;
import com.deromang.daggersample.domain.data.ProductList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @POST("api/")
    Call<ProductList> showInformation(@Query("i") String product);

}
