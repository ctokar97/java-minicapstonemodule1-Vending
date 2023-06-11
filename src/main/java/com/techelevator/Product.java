package com.techelevator;

import java.text.DecimalFormat;

public class Product {
    private int quantity = 5;
    private String slotLocation;
    private String name;
    private double price;
    private String category;

    private static DecimalFormat decimalTo100Th = new DecimalFormat("0.00");


    public Product(String slotLocation, String name, double price, String category) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int dispense(int quantityToRemove) {
        quantity = quantity - quantityToRemove;

        System.out.println();
        System.out.println(name + " $" + decimalTo100Th.format(price * quantityToRemove));
        message();
        System.out.println();
        return quantity;
    }

    public void message() {

    }

    public int getQuantity() {
        return quantity;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
