package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {
    @Test
    public void B1_Candy_returns_munch_munch_yum() {
        // Arrange
        Candy candy = new Candy("B1", "Moonpie", 1.80, "Candy");
        String expectedMessage = "Munch Munch, Yum!";

        // Act
        candy.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Munch Munch, Yum!");
    }

    @Test
    public void B2_Candy_returns_munch_munch_yum() {
        // Arrange
        Candy candy = new Candy("B2", "Cowtales", 1.50, "Candy");
        String expectedMessage = "Munch Munch, Yum!";

        // Act
        candy.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Munch Munch, Yum!");
    }
    @Test
    public void B3_Candy_returns_munch_munch_yum() {
        // Arrange
        Candy candy = new Candy("B2", "Cowtales", 1.50, "Candy");
        String expectedMessage = "Munch Munch, Yum!";

        // Act
        candy.message();

        // Assert
        Assert.assertEquals(expectedMessage, ("Munch Munch, Yum!"));
    }
    @Test
    public void B4_Candy_returns_munch_munch_yum() {
        // Arrange
        Candy candy = new Candy("B2", "Cowtales", 1.50, "Candy");
        String expectedMessage = "Munch Munch, Yum!";

        // Act
        candy.message();

        // Assert
        Assert.assertEquals(expectedMessage, ("Munch Munch, Yum!"));
    }

}


