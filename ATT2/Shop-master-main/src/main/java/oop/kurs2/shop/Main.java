package oop.kurs2.shop;

import oop.kurs2.shop.ui.CommandLineInterface;

public class Main {
    public static void main(String[] args) {

        if(args[0].equals("CLI")) {
            CommandLineInterface.executeCLI();
        } else if(args[0].equals("GUI")) {
            System.out.println("Not supported now");
        }

    }
}