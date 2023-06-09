package com.techelevator;

public class Drink extends Product{

    public Drink(String name, double price) {
        super(name, price);
    }

        public String getEnjoy() {
            return "Glug Glug, Yum!";
        }
}
