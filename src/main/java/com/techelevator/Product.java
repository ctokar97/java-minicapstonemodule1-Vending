package com.techelevator;

public abstract class Product {
    private String name;
    private double price;
    private int numberOfProducts = 5;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public abstract String getEnjoy();

}
