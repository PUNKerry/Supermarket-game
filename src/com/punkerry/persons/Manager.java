package com.punkerry.persons;

import com.punkerry.Main;
import com.punkerry.auxiliarytypes.MyDate;
import com.punkerry.auxiliarytypes.ShopCalendar;
import com.punkerry.products.Product;
import java.util.ArrayList;
public class Manager {

    public ShopCalendar getCalendar() {
        return calendar;
    }

    public Manager(double sellRatio) {
        this.sellRatio = sellRatio;
        calendar = new MyDate(2002,9,1);
    }

    private ShopCalendar calendar;

    private double sellRatio;

    public void checkDate(ArrayList<Product> toCheck) {
        for (int i = 0; i < toCheck.size(); i++) {
            Product current = toCheck.get(i);
            boolean oneDayTime = current.checkExpirationDate().getMonth()==calendar.getMonth() &&
                    current.checkExpirationDate().getYear()==calendar.getYear() &&
                    current.checkExpirationDate().getDay()-calendar.getDay() == 1;

            if(current.checkExpirationDate().equals(calendar)) {
                removeProduct(current, toCheck);
            } else if (oneDayTime) {
                makeSale(current);
            }
        }
    }

    private void makeSale(Product lowExpiration) {
        lowExpiration.changeSale(sellRatio);
    }

    private void removeProduct(Product toRemove, ArrayList<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(toRemove)) {
                list.remove(i);
                break;
            }
        }
    }

    public Product iCantFind(String name) {
        ArrayList<Product> toAdd = new ArrayList<>();
        Product currentProduct = Main.events.storage.getProduct(name);
        if(currentProduct!=null) {
            for (int i = 0; i < 5 || currentProduct != null; i++) {
                toAdd.add(currentProduct);
                currentProduct = Main.events.storage.getProduct(name);
            }
        }

        Product toReturn = toAdd.get(toAdd.size()-1);
        toAdd.remove(toAdd.size()-1);
        if(toAdd.size()>0)
        Main.events.shop.insertProduct(toAdd);
        return toReturn;
    }

    private void callDelivery(String needed) {

    }

}
