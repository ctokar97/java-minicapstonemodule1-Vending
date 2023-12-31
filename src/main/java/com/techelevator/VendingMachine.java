package com.techelevator;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    Scanner userInput = new Scanner(System.in);

    protected List<Product> inventoryList = new ArrayList<>();

    protected double currentBalance = 0.00;

    private static final DecimalFormat DECIMAL_TO_100_TH = new DecimalFormat("0.00");


    public VendingMachine() {

        readInventoryFromFile();
    }


    public void mainMenu() throws NumberFormatException, IOException {

        boolean validInput = false;

        System.out.println("Main Menu");

        while(!validInput) {

            System.out.println("---------------------------------");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            System.out.println("Please choose an option: ");

            String selection = userInput.nextLine();
            switch (selection) {
                case "1":

                    displayInventoryList();
                    validInput = false;

                    break;
                case "2":

                    validInput = true;

                    processMenu();

                    break;
                case "3":

                    validInput = true;

                    exit();
                    break;
            }

        }

    }

    public void processMenu() throws NumberFormatException, IOException {
        boolean workingInput = false;

        while(!workingInput) {

            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            System.out.println("Current balance: $" + DECIMAL_TO_100_TH.format(currentBalance));
            System.out.println("Please enter a valid option: ");

            String selection = userInput.nextLine();

            switch (selection) {
                case "1":

                    workingInput = true;

                    feedMoney();

                    break;
                case "2":

                    selectProduct();
                    workingInput = true;

                    break;
                case "3":

                    returnChange();
                    workingInput = true;

                    mainMenu();

                    break;
            }

        }
    }

    public void feedMoney() throws NumberFormatException, IOException {
        boolean finish = false;

        while(!finish) {
            System.out.println();

            System.out.println("Press P to select Product");

            System.out.println("Please select amount to feed: (1) = ($1), (2) = ($2), (5) = ($5), (10) = ($10)");

            System.out.println("Current balance: $" + DECIMAL_TO_100_TH.format(currentBalance));

            System.out.println("Insert Bills or enter P to go to Select Product:  ");

            String money = userInput.nextLine();

            if(money.toLowerCase().equals("p")) {

                finish = true;

                selectProduct();

            } else if (money.equals("1") || money.equals("2") || money.equals("5") || money.equals("10")) {
                double startingBalance = currentBalance;

                currentBalance += Double.parseDouble(money);



            } else {

                System.out.println("Invalid entry, please try again");
            }
        }
    }


    public void selectProduct() throws NumberFormatException, IOException {

        displayInventoryList();
        System.out.println("Current balance: $" + DECIMAL_TO_100_TH.format(currentBalance));
        System.out.println("Please enter an Item code: ");

        String userSelection = userInput.nextLine().toUpperCase();

        boolean goodInput = false;

        while(!goodInput) {

            for(Product inventory : inventoryList) {

                if (inventory.getSlotLocation().equals(userSelection)) {

                    goodInput = true;

                    goodItemSelection(inventory);
                }
            }

            System.out.println("sorry, invalid input");

            selectProduct();
        }
    }


    public void goodItemSelection(Product inventory) throws IOException {

        int dispenseAmount = 0;
        boolean validInput = false;

        while (!validInput) {

            System.out.println("How many would you like to dispense ");
            String KeyBoardEntry = userInput.nextLine();

            if (KeyBoardEntry.equals("1") || KeyBoardEntry.equals("2") || KeyBoardEntry.equals("3") || KeyBoardEntry.equals("4") || KeyBoardEntry.equals("5")) {

                dispenseAmount = Integer.parseInt(KeyBoardEntry);

                validInput = true;

            } else {

                System.out.println("Sorry, out of stock");
            }
        }

        if (dispenseAmount < 0) {

            System.out.println("Invalid entry please try again");

            selectProduct();
        } else {

            if (inventory.getQuantity() < dispenseAmount) {

                System.out.println(" Sold Out");

                selectProduct();
            } if (currentBalance <= (inventory.getPrice() * dispenseAmount)) {

                System.out.println("insufficient Funds");
                processMenu();
            } else if (currentBalance >= (inventory.getPrice() *dispenseAmount)) {

                if (inventory.getQuantity() < dispenseAmount) {

                    System.out.println(" Not enough product available");

                    selectProduct();
            } if(inventory.getQuantity() >= dispenseAmount) {

                    double startingBalance = currentBalance;
                    currentBalance -= (inventory.getPrice() * dispenseAmount);
                    inventory.dispense(dispenseAmount);
                    for (int i = 0; i < dispenseAmount; i++) {
                        System.out.println("Enjoy!");
                    }
                    processMenu();
                }

            }
        }

    }


    public void returnChange() {

        int change = (int)(currentBalance * 100);

        int quarters = ( change / 25);

        change = change % 25;

        int dimes = ( change / 10);

        change = change % 10;

        int nickels = ( change / 5);

        change = change % 5;

        System.out.println("GIVE CHANGE: " + " $" + DECIMAL_TO_100_TH.format(currentBalance));

        currentBalance = 0;

        System.out.println("Quarters: " + quarters + ", Dimes: " + dimes + ", Nickels " + nickels);
    }


    private void exit() {
        System.out.println("Thank you, please come again!");
        System.exit(1);
    }


    private boolean readInventoryFromFile() {
        File inventory = new File("vendingmachine.csv");

        try(Scanner inventoryInput = new Scanner(inventory)) {

            while(inventoryInput.hasNextLine()) {

                String line = inventoryInput.nextLine();
                String[] data = line.split("\\|");

                String location = data[0];
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                String category = data[3];

                switch (category.toLowerCase()) {
                    case "chip":
                        this.inventoryList.add(new Chip(location, name, price, category));

                        break;
                    case "candy":
                        this.inventoryList.add(new Candy(location, name, price, category));

                        break;
                    case "drink":
                        this.inventoryList.add(new Drink(location, name, price, category));

                        break;
                    case "gum":
                        this.inventoryList.add(new Gum(location, name, price, category));
                        break;
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
            return false;
        }
        return true;
    }


    public void displayInventoryList() {
        for(Product product : inventoryList) {
            System.out.println(product.getSlotLocation() + " | " + product.getName() + " | $" + DECIMAL_TO_100_TH.format(product.getPrice()) + " | " + product.getQuantity());
        }
    }
}
