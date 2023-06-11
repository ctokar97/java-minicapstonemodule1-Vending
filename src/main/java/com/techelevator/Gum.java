package com.techelevator;

public class Gum extends Product {

    public Gum(String location, String name, double price, String category) {

        super (location, name, price, category);
    }

    @Override
    public void message() {
        System.out.println("Chew Chew, Yum!");
        System.out.println();
    }
}