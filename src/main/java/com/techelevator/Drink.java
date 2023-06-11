package com.techelevator;

public class Drink extends Product{

    public Drink(String location,String name, double price, String category) {

        super (location, name, price, category);
    }

    @Override
    public void message() {
        System.out.println("Glug Glug, Yum!");
        System.out.println();
    }
}
