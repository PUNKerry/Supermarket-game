package com.punkerry.shop;

import com.punkerry.products.Product;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Product> savedProducts;

    public Storage() {
        this.savedProducts = new ArrayList<>();
    }

    public void addProduct(Product inserted) {
        savedProducts.add(inserted);
    }

    public Product getProduct(String searchable) {
        for (int i = 0; i < savedProducts.size(); i++) {
            if(savedProducts.get(i).getProductName().equals(searchable)) {
                Product returnable = savedProducts.get(i).clone();
                savedProducts.remove(i);
                return returnable;
            }
        }
        return null;
    }

}
