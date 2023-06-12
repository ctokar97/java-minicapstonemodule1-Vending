package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DrinkTest {
    @Test
    public void C1_returns_Glug_Glug_yum_() {
        // Arrange
        Drink drink = new Drink("C1", "Cola", 1.25, "drinks");
        String expectedMessage = "Glug Glug, Yum!";

        // Act
        drink.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Glug Glug, Yum!");
    }

    @Test
    public void C2_returns_Glug_Glug_yum_() {
        // Arrange
        Drink drink = new Drink("C2", "Dr. Salt", 1.50, "drinks");
        String expectedMessage = "Glug Glug, Yum!";

        // Act
        drink.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Glug Glug, Yum!");
    }

    @Test
    public void C3_returns_Glug_Glug_yum_() {
        // Arrange
        Drink drink = new Drink("C3", "Mountain Melter", 1.50, "drinks");
        String expectedMessage = "Glug Glug, Yum!";

        // Act
        drink.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Glug Glug, Yum!");
    }

    @Test
    public void C4_returns_Glug_Glug_yum_() {
        // Arrange
        Drink drink = new Drink("C4", "Heavy", 1.50, "drinks");
        String expectedMessage = "Glug Glug, Yum!";

        // Act
        drink.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Glug Glug, Yum!");
    }
}


