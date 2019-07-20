package com.bravostudio.mandiriwth2019.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jouvyalifpradewo on 2019-07-20.
 */
public class Product {

    @SerializedName("productTitle")
    @Expose
    private String productTitle;

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

}
