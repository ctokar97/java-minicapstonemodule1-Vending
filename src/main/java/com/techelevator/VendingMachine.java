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

    private static DecimalFormat decimalTo100Th = new DecimalFormat("0.00");


    public VendingMachine() {

        readInventoryFromFile();
    }


    public void mainMenu() throws NumberFormatException, IOException {

        boolean validInput = false;

        System.out.println("Main Menu");

        while(!validInput) {

            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            System.out.println("Please choose an option: ");

            String selection = userInput.nextLine();
            if(selection.equals("1")) {

                displayInventoryList();
                validInput = false;

            } else if( selection.equals("2")) {

                validInput = true;

                processMenu();

            } else if( selection.equals("3")) {

                validInput = true;

                exit();
            }

        }

    }

    public void processMenu() throws NumberFormatException, IOException {
        boolean workingInput = false;

        while(!workingInput) {

            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            System.out.println("Current balance: $" + decimalTo100Th.format(currentBalance));
            System.out.println("Please enter a valid option: ");

            String selection = userInput.nextLine();

            if (selection.equals("1")) {

                workingInput = true;

                feedMoney();

            } else if (selection.equals("2")) {

                selectProduct();
                workingInput = true;

            } else if (selection.equals("3")) {

                returnChange();
                workingInput = true;

                mainMenu();

            }

        }
    }

    public void feedMoney() throws NumberFormatException, IOException {
        boolean finish = false;

        while(!finish) {
            System.out.println();

            System.out.println("Press P to select Product");

            System.out.println("Please select amount to feed: (1) = ($1), (2) = ($2), (5) = ($5), (10) = ($10)");

            System.out.println("Current balance: $" + decimalTo100Th.format(currentBalance));

            System.out.println("Insert Bills or enter P to go to Select Product:  ");

            String money = userInput.nextLine();

            if(money.toLowerCase().equals("P")) {

                finish = true;

                selectProduct();

            } else if (money.equals("1") || money.equals("2") || money.equals("5") || money.equals("10")) {
                double startingBalance = currentBalance;

                currentBalance += Double.parseDouble(money);

                Log logFeedMoney = new Log("FEED MONEY: ", startingBalance, currentBalance);

            } else {

                System.out.println("Invalid entry, please try again");
            }
        }
    }


    public void selectProduct() throws NumberFormatException, IOException {

        displayInventoryList();
        System.out.println("Current balance: $" + decimalTo100Th.format(currentBalance));
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
            }
        }

    }


    public void returnChange() throws IOException {

        int change = (int)(Math.ceil(currentBalance * 100));

        int quarters = Math.round((int)change / 25);

        change = change % 25;

        int dimes = Math.round((int)change / 10);

        change = change % 10;

        int nickels = Math.round((int)change / 5);

        change = change % 5;

        Log logReturnChange = new Log("GIVE CHANGE: ", currentBalance, 0.00);

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

                if (category.toLowerCase().equals("chip")) {
                    this.inventoryList.add(new Chip(location, name, price, category));

                } else if (category.toLowerCase().equals("candy")) {
                    this.inventoryList.add(new Candy(location, name, price, category));

                } else if (category.toLowerCase().equals("drink")) {
                    this.inventoryList.add(new Drink(location, name, price, category));

                } else if (category.toLowerCase().equals("gum")) {
                    this.inventoryList.add(new Gum(location, name, price, category));
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
            System.out.println(product.getSlotLocation() + " | " + product.getName() + " | $" + product.getPrice() + " | " + product.getCategory());
        }
    }
}
