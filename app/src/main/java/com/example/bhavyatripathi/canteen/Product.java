package com.example.bhavyatripathi.canteen;

import org.json.JSONObject;

/**
 * Created by Bhavya Tripathi on 15/04/2018.
 */
public class Product {
    String ProductName;
    Double ProductPrice;
    int    ProductImage;
    int    CartQuantity=0;

    public Product(String productName, Double productPrice, int productImage) {
        ProductName = productName;
        ProductPrice = productPrice;
        ProductImage = productImage;
    }

    public String getJsonObject() {
        JSONObject cartItems = new JSONObject();
        try
        {
            cartItems.put("ProductName", ProductName);
            cartItems.put("ProductPrice", ProductPrice);
            cartItems.put("ProductImage",ProductImage);
            cartItems.put("CartQuantity",CartQuantity);
        }
        catch (Exception e) {}
        return cartItems.toString();
    }

}