package com.example.ngockhanh.mvpexample.Model.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 1/2/2018.
 */

public class Products {
    @SerializedName("id_product")
    @Expose
    private String idProduct;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("decription")
    @Expose
    private String decription;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("thumnail")
    @Expose
    private String thumnail;

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }
}
