package com.techelevator;

public class Chip extends Product{

    public Chip(String location, String name, double price, String category) {

        super (location, name, price, category);
    }

    @Override
    public void message() {
        System.out.println("Crunch Crunch, Yum!");
        System.out.println();
    }
}
