package oop.kurs2.shop.model;

import java.util.HashMap;
import java.util.Map;

public class ShopWork {
    private final Map<ProductsType, Integer> warehousProducts = new HashMap<>();
    private final Map<ProductsType, Integer> shopRoomProducts = new HashMap<>();
    private int day;
    private int workDays = 14;

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public Map<ProductsType, Integer> getWarehousProducts() {
        return warehousProducts;
    }

    public Map<ProductsType, Integer> getShopRoomProducts() {
        return shopRoomProducts;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getWorkDays() {
        return workDays;
    }
}
