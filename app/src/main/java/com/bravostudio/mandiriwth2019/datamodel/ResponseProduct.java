package com.bravostudio.mandiriwth2019.datamodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jouvyalifpradewo on 2019-07-20.
 */

public class ResponseProduct {

    @SerializedName("Exception")
    @Expose
    private Exception exception;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}