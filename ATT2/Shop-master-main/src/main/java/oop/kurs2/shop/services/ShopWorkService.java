package oop.kurs2.shop.services;

import oop.kurs2.shop.json.JSon;
import oop.kurs2.shop.model.ProductLocation;
import oop.kurs2.shop.model.ShopWork;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class ShopWorkService {

    private ShopWork shopWork = new ShopWork();
    private static ShopWorkService shopWorkService;

    public void startAutoplay() {
        System.out.println("autoplay");
        shopWorkService = this;
        JSon jSon = new JSon();
        final int[] i = {0};
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                shopWork.setDay(i[0]);
                spendWorkDay();
                writeToJson(jSon);
                i[0]++;
            }
        });
        timer.start();

        for (int g = 0; ; g++) {

        }
    }

    public void startDemo() {
        System.out.print("insert scenario steps count: ");
        Scanner sc = new Scanner(System.in);
        int loc = sc.nextInt();
        shopWork.setWorkDays(loc-1);
        JSon jSon = new JSon();
        shopWorkService = this;
        Scanner wait = new Scanner(System.in);
        for (int i = 0; i <= shopWork.getWorkDays(); i++) {
            System.out.println("press any key to continue main scenario");
            wait.nextLine();
            shopWork.setDay(i);
            spendWorkDay();
            writeToJson(jSon);
        }
    }

    private void spendWorkDay() {
        ShowService showService = new ShowService();
        EventsService events = new EventsService();
        System.out.println("Продукты на складе: " +
                showService.countProducts(ProductLocation.warehouse.getAmountProducts(), shopWork.getWarehousProducts()));
        System.out.println("Продукты в торговом зале: " +
                showService.countProducts(ProductLocation.shoppingRoom.getAmountProducts(), shopWork.getShopRoomProducts()));
        System.out.println("Цены :");
        ShowService.showPrices(shopWork.getWarehousProducts(), shopWork.getShopRoomProducts());
        events.startRandomEvent();
    }

    public void writeToJson(JSon jSon) {
        try {
            jSon.serialize(shopWorkService, "shop.json");
            jSon.deserialize("shop.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getDay() {
        return shopWork.getDay();
    }

    public static ShopWorkService getShopWork() {
        return shopWorkService;
    }
}