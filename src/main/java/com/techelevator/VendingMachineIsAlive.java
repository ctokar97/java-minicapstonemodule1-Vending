package com.techelevator;

import java.io.IOException;

public class VendingMachineIsAlive {
    public static void main(String[] args)  {
       try {
           VendingMachine machineAlive = new VendingMachine();
           machineAlive.mainMenu();

       }catch(NumberFormatException | IOException e) {
           System.out.println("Whoops something went wrong");
       }
    }
}
