package oop.kurs2.shop.ui;

import oop.kurs2.shop.services.ShopWorkService;

import java.util.Scanner;

public class CommandLineInterface {
    private CommandLineInterface() {
        ShopWorkService work = new ShopWorkService();
        System.out.println("SUPERMARKET-GAME v.0.2.6");
        System.out.println("_________________________________");
        System.out.println("Do you want to start DEMO? y/n");
        Scanner word = new Scanner(System.in);
        String wd = word.nextLine();
        System.out.print("> ");
        if(wd.equals("y")) {
            work.startDemo();
        }
        if(wd.equals("n")) {
            System.out.println("Do you want to start autoplay? y/n");
            wd = word.nextLine();
            System.out.print("> ");
            if(wd.equals("y"))
                work.startAutoplay();
        }
    }

    public static void executeCLI() {
        new CommandLineInterface();
    }
}
