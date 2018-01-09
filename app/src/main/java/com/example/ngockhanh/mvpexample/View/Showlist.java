package com.example.ngockhanh.mvpexample.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ngockhanh.mvpexample.Adapter.ProductAdapter;
import com.example.ngockhanh.mvpexample.Model.Products.Products;
import com.example.ngockhanh.mvpexample.Presenter.PresenterProducts.PresenterGetAllProducts;
import com.example.ngockhanh.mvpexample.Presenter.PresenterProducts.ViewProductListener;
import com.example.ngockhanh.mvpexample.R;


import java.util.ArrayList;


public class Showlist extends AppCompatActivity implements ViewProductListener {


    RecyclerView recyclerview;
    Button btnGetData;
    PresenterGetAllProducts presenterGetAllProducts;
    RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Products> productList;
    private ProductAdapter productAdapter;
    String URL_GET_PRODUCT = "http://dev.androidcoban.com/blog/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlist);
        productList = new ArrayList<>();
        recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        btnGetData = (Button) findViewById(R.id.button);

        presenterGetAllProducts = new PresenterGetAllProducts(this);
        //ButterKnife.bind(this);
        addControl();
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterGetAllProducts.receivedRequestGetAllProducts(URL_GET_PRODUCT, productList, productAdapter);
            }
        });
    }

    private void addControl() {
        recyclerview.setHasFixedSize(true);
        // Create 2 col
        mLayoutManager = new GridLayoutManager(Showlist.this, 2);
        recyclerview.setLayoutManager(mLayoutManager);
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(productList, Showlist.this);
        recyclerview.setAdapter(productAdapter);
    }

    @Override
    public void onGetAllProductsSuccess() {
        Toast.makeText(this, "Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetAllProductsFailed() {
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }


}
