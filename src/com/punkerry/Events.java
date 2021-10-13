package com.punkerry;

import com.punkerry.persons.Buyer;
import com.punkerry.persons.Manager;
import com.punkerry.auxiliarytypes.Names;
import com.punkerry.shop.Shop;
import com.punkerry.shop.Storage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Events implements ActionListener {

    private static final double saleRatio = 0.5;

    static Events ev;

    public Shop shop;
    public Storage storage;
    public Manager manager;
    //list of buyers
    ArrayList<Buyer> buyers;

    public Events() {
        shop = new Shop();
        storage = new Storage();
        manager = new Manager(saleRatio);

        buyers = new ArrayList<>();

        for (int i = 0; i < Names.values().length; i++) {
            Random randomizer = new Random(1000);
            int payDayIncome = randomizer.nextInt() + 1000;
            buyers.add(new Buyer(Names.values()[i], payDayIncome));
        }

    }

    private void initRandomEvent() {
        Random random = new Random(10);
        int ratio = random.nextInt();
        switch (ratio) {
            case 1:
                //buyerWantsSomething
                Random random2 = new Random(buyers.size());
                int chooseBuyer = random2.nextInt();
                Buyer chosenOne = buyers.get(chooseBuyer);
                chosenOne.buySomething();
                break;
        }
    }

    private void managerCheck() {
        manager.checkDate(shop.getProductsToSell());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(buyers.size() == Names.values().length) {
            counter++;
            if(counter % 60 == 0) {
                //payday
                for (Buyer buyer : buyers) {
                    buyer.givePay();
                }
            }
            initRandomEvent();
            managerCheck();

            if(counter % 2 == 0) {
                //date update
                manager.getCalendar().updateTime();
            }

        }
    }
    //timer updater
    private int counter = 0;
    private Timer timer = new Timer(500, this);
}
