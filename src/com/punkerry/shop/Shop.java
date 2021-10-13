package com.punkerry.shop;

import com.punkerry.Main;
import com.punkerry.auxiliarytypes.ShopCalendar;
import com.punkerry.persons.Buyer;
import com.punkerry.products.Product;

import java.util.ArrayList;

public class Shop {
    ShopCalendar dateCheckerNineThousand;

    private ArrayList<Product> productsToSell;

    public ArrayList<Product> getProductsToSell() {
        return productsToSell;
    }

    public void insertProduct(Product insertable) {
        productsToSell.add(insertable);
    }
    public void insertProduct(ArrayList<Product> insertable) {
        productsToSell.addAll(insertable);
    }

    public Product buyProduct(String name, Buyer buyer) {
        for (int i = 0; i < productsToSell.size(); i++) {
            Product product = productsToSell.get(i);
            if (product.getProductName().equals(name) && buyer.getMoney() > product.getCost()) {
                buyer.setMoney((int) (buyer.getMoney() - product.getCost()));
                //System.out.println("Product: " + product.getProductName() + " bought by: ");
                return product;
            }
        }

        //attempt to manager
        Main.events.manager.iCantFind(name);

        return null;
    }

    public Shop() {
        this.productsToSell = new ArrayList<>();

    }
}
