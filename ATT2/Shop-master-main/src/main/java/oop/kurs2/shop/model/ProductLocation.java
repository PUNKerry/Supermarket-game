package oop.kurs2.shop.model;

import java.util.LinkedList;

public enum ProductLocation {
    warehouse(new LinkedList<>()),
    shoppingRoom(new LinkedList<>());

    private final LinkedList<ProductsType> amountProducts;

    ProductLocation(LinkedList<ProductsType> amountProducts) {
        this.amountProducts = amountProducts;
    }

    public LinkedList<ProductsType> getAmountProducts() {
        return amountProducts;
    }
}