package com.punkerry.persons;

import com.punkerry.Main;
import com.punkerry.auxiliarytypes.Names;

import java.util.Random;

public class Buyer {
    private Names name;

    private int money;
    private int payDay;

    public Names getName() {
        return name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void givePay() {
        money = money + payDay;
    }

    public void buySomething() {
        Random randomizer = new Random(5);
        int buyRatio = randomizer.nextInt();
        idLikeToBuy(buyRatio);
    }

    private void idLikeToBuy(int seed) {
        switch (seed) {
            case 0:
                Main.events.shop.buyProduct("milk", this);
                break;
            case 1:
                Main.events.shop.buyProduct("alcohol", this);
                break;
            case 2:
                Main.events.shop.buyProduct("chemicals", this);
                break;
            case 3:
                Main.events.shop.buyProduct("chemicals", this);
                break;
            case 4:
                Main.events.shop.buyProduct("fruits", this);
                break;
            case 5:
                Main.events.shop.buyProduct("other", this);
                break;
        }
    }

    public Buyer(Names name, int payDay) {
        this.name = name;
        this.payDay = payDay;
        money = payDay * 3;
    }
}
