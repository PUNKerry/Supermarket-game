package oop.kurs2.shop;
import oop.kurs2.shop.services.ShopWorkService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShopWorkService work = new ShopWorkService();
        System.out.println("Do you want to start DEMO? y/n");
        Scanner word = new Scanner(System.in);
        String wd = word.nextLine();
        if(wd.equals("y")) {
            work.startDemo();
        }
        if(wd.equals("n")) {
            System.out.println("Do you want to start autoplay? y/n");
            wd = word.nextLine();
            if(wd.equals("y"))
            work.startAutoplay();
        }

    }
}