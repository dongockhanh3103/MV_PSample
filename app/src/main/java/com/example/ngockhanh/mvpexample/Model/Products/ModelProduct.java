package com.example.ngockhanh.mvpexample.Model.Products;

import android.util.Log;

import com.example.ngockhanh.mvpexample.Adapter.ProductAdapter;
import com.example.ngockhanh.mvpexample.Service.APIService;
import com.example.ngockhanh.mvpexample.Utilites.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ngoc Khanh on 1/3/2018.
 */

public class ModelProduct {
    String TAG="onModel Class";
    ModelResponeAllProductsToPresenter callback;
    public  ModelProduct(ModelResponeAllProductsToPresenter callback){
        this.callback=callback;
    }
    public  void getAllProductsFromNetwork(String URL_GET_PRODUCT, final ArrayList<Products> productList, final ProductAdapter productAdapter){
        Retrofit retrofit = RetrofitClient.getClient(URL_GET_PRODUCT);
        APIService apiService = retrofit.create(APIService.class);
        Call<List<Products>> call = apiService.getAllProduct();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                List<Products> productsList = response.body();
                for (int i = 0; i<productsList.size() ; i++) {
                    productList.add(productsList.get(i));
                    Log.d(TAG, "onResponse" + productsList.get(i).toString());
                }
                productAdapter.notifyDataSetChanged();
                callback.onGetAllProductsSuccess();

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                callback.onGetAllProductsFailed();
            }
        });

    }
}
