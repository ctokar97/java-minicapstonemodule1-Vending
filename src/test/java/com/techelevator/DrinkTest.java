package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DrinkTest {
    @Test
    public void C1_returns_Glug_Glug_yum_() {
        // Arrange
        Drink drink = new Drink("C1", "", 1.50, "chips");
        String expectedMessage = "Glug Glug, Yum!";

        // Act
        drink.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Glug Glug, Yum!");
    }

    @Test
    public void C2_returns_Glug_Glug_yum_() {
        // Arrange
        Drink drink = new Drink("C1", "", 1.50, "chips");
        String expectedMessage = "Glug Glug, Yum!";

        // Act
        drink.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Glug Glug, Yum!");
    }

    @Test
    public void C3_returns_Glug_Glug_yum_() {
        // Arrange
        Drink drink = new Drink("C1", "", 1.50, "chips");
        String expectedMessage = "Glug Glug, Yum!";

        // Act
        drink.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Glug Glug, Yum!");
    }

    @Test
    public void C4_returns_Glug_Glug_yum_() {
        // Arrange
        Drink drink = new Drink("C1", "", 1.50, "chips");
        String expectedMessage = "Glug Glug, Yum!";

        // Act
        drink.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Glug Glug, Yum!");
    }
}


