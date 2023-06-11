package com.techelevator;

public class Candy extends Product {

    public Candy(String location,String name, double price, String category) {

        super (location, name, price, category);
    }

    @Override
    public void message() {
        System.out.println("Munch Munch, Yum!");
        System.out.println();
    }
}
