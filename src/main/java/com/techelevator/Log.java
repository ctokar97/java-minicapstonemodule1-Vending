package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public String action;
    public String name;
    public double startingBalance;
    public double endingBalance;
    public String location;
    private DecimalFormat formatDecimalTo100th = new DecimalFormat("0.00");

    public Log(String action, double startingBalance, double endingBalance) throws IOException {
        this.action = action;
        this.startingBalance = startingBalance;
        this.endingBalance = endingBalance;


        File log = new File("log.txt");
        if (!log.exists()) {

            try {
                log.createNewFile();

            } catch (IOException e) {

                System.out.println("IO Exception");
            }
        }
        helpToWriteLog();

    }

    public Log(String name, String location, double startingBalance, double endingBalance) throws IOException {

        this.name = name;
        this.location = location;
        this.startingBalance = startingBalance;
        this.endingBalance = endingBalance;

        File log = new File("log.txt");

        if(!log.exists()) {
            try {

                log.createNewFile();

            } catch (IOException e) {

                System.out.println("File not created");
            }

        }
        writeToLogDispense();

    }


    public String getAction() {
        return action;
    }

    public double getStartingBalance() {
        return startingBalance;
    }

    public double getEndingBalance() {
        return endingBalance;
    }

    public String getLocation() {
        return location;
    }

    public void setStartingBalance(double startingBalance) {
        this.startingBalance = startingBalance;
    }

    public void setEndingBalance(double endingBalance) {
        this.endingBalance = endingBalance;
    }

    private void writeToLogDispense() throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");

        Date date = new Date();

        String dateString = dateFormat.format(date);

        try(FileWriter myFileWriter = new FileWriter("log.txt", true);
            PrintWriter myPrintWriter = new PrintWriter(myFileWriter)) {

            myPrintWriter.println(dateString + " " + name + " " + location + " $" + formatDecimalTo100th.format(startingBalance) + " $" + formatDecimalTo100th.format(endingBalance));
        }


    }

    private void helpToWriteLog() throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");

        Date date = new Date();

        String dateString = dateFormat.format(date);

        try(FileWriter myFileWriter = new FileWriter("log.txt", true);
            PrintWriter myPrintWriter = new PrintWriter(myFileWriter)) {

            myPrintWriter.println(dateString + " " + action + " $" + formatDecimalTo100th.format(startingBalance) + " $" + formatDecimalTo100th.format(endingBalance));
        }

    }

}
