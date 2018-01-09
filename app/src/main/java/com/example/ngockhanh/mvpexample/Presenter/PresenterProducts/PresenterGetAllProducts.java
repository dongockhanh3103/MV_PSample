package com.example.ngockhanh.mvpexample.Presenter.PresenterProducts;

import com.example.ngockhanh.mvpexample.Adapter.ProductAdapter;
import com.example.ngockhanh.mvpexample.Model.Products.ModelProduct;
import com.example.ngockhanh.mvpexample.Model.Products.ModelResponeAllProductsToPresenter;
import com.example.ngockhanh.mvpexample.Model.Products.Products;

import java.util.ArrayList;

/**
 * Created by Ngoc Khanh on 1/3/2018.
 */

public class PresenterGetAllProducts implements ModelResponeAllProductsToPresenter{
    ModelProduct modelProduct;
    ViewProductListener callback;
    public PresenterGetAllProducts(ViewProductListener callback){
        this.callback=callback;
    }
    public void receivedRequestGetAllProducts(String baseURL, ArrayList<Products> productList,ProductAdapter productAdapter ){
        modelProduct=new ModelProduct(this);
        modelProduct.getAllProductsFromNetwork(baseURL,productList,productAdapter);
    }


    @Override
    public void onGetAllProductsSuccess() {
        callback.onGetAllProductsSuccess();
    }

    @Override
    public void onGetAllProductsFailed() {
        callback.onGetAllProductsFailed();
    }
}
