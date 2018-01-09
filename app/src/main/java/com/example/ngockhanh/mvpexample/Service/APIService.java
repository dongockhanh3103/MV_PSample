package com.example.ngockhanh.mvpexample.Service;

import com.example.ngockhanh.mvpexample.Model.Products.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ngoc Khanh on 1/2/2018.
 */


public interface APIService {
    @GET("getallproducts.php")
    Call<List<Products>> getAllProduct();
}