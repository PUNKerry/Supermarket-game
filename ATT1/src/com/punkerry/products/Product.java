package com.punkerry.products;

import com.punkerry.auxiliarytypes.MyDate;
import com.punkerry.auxiliarytypes.TypeOfProduct;
import java.util.Date;
import java.util.HashMap;

public class Product {

    private  static HashMap<Product, TypeOfProduct> prTypes;

    public static HashMap<Product, TypeOfProduct> getPrTypes() {
        return prTypes;
    }

    public static void generateTypes() {
        prTypes = new HashMap<>();
    }

    private double cost;
    private MyDate expirationDate;
    private TypeOfProduct type;
    private String productName;

    private double saleRatio;

    public Product(String name, double cost, MyDate expirationDate, TypeOfProduct type) {
        this.productName = name;
        this.cost = cost;
        this.expirationDate = expirationDate;
        this.type = type;
    }
    @Override
    public Product clone() {
        return new Product(this.productName, this.cost, this.expirationDate,
                this.type);
    }

    public String getProductName() {
        return productName;
    }
    public TypeOfProduct getType() {
        return type;
    }
    public double getCost() {
        return cost * saleRatio;
    }
    public double getSaleRatio() {
        return saleRatio;
    }
    public MyDate checkExpirationDate() {
        return expirationDate;
    }
    public void changeSale(double sellValue) {
        saleRatio = sellValue;
    }


}
