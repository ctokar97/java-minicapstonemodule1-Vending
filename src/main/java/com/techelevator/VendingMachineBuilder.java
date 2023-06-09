package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineBuilder {

    public File getInputFile() {
        String filePath = "vendingmachine.csv";
        File inputFile = new File(filePath);

        if(!inputFile.exists()) {
            System.out.println(filePath + " does not exist");
            System.exit(1);
        }

        return inputFile;
    }
                                                               // deal with it later
    public Map<String, Product> getInventory (File inputFile) throws FileNotFoundException {
        Map<String, Product> inventoryMap = new LinkedHashMap<String, Product>();

        try(Scanner fileScanner = new Scanner(inputFile)) {

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] organizedList = line.split("\\|");

                if (organizedList[3].equals("Chip")) {
                    Product product = new Chip(organizedList[1], Double.parseDouble(organizedList[2]));
                    inventoryMap.put(organizedList[0], product);

                } else if(organizedList[3].equals("Candy")) {
                    Product product = new Chip(organizedList[1], Double.parseDouble(organizedList[2]));
                    inventoryMap.put(organizedList[0], product);

                } else if(organizedList[3].equals("Drink")) {
                    Product product = new Chip(organizedList[1], Double.parseDouble(organizedList[2]));
                    inventoryMap.put(organizedList[0], product);

                } else if(organizedList[3].equals("Gum")) {
                    Product product = new Chip(organizedList[1], Double.parseDouble(organizedList[2]));
                    inventoryMap.put(organizedList[0], product);
                }
            }
        }
        return inventoryMap;
    }









}
