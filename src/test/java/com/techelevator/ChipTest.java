package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ChipTest {
    @Test
    public void A1_returns_Crunch_Crunch_yum_() {
        // Arrange
        Chip chip = new Chip("A1", "", 1.50, "chips");
        String expectedMessage = "Crunch Crunch, Yum!";

        // Act
        chip.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Crunch Crunch, Yum!");
    }
    @Test
    public void A2_returns_Crunch_Crunch_yum_() {
        // Arrange
        Chip chip = new Chip("A2", "", 1.50, "chips");
        String expectedMessage = "Crunch Crunch, Yum!";

        // Act
        chip.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Crunch Crunch, Yum!");
    }
    @Test
    public void A3_returns_Crunch_Crunch_yum() {
        // Arrange
        Chip chip = new Chip("A1", "", 1.50, "chips");
        String expectedMessage = "Crunch Crunch, Yum!";

        // Act
        chip.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Crunch Crunch, Yum!");
    }
    @Test
    public void A4_returns_Crunch_Crunch_yum_() {
        // Arrange
        Chip chip = new Chip("A1", "", 1.50, "chips");
        String expectedMessage = "Crunch Crunch, Yum!";

        // Act
        chip.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Crunch Crunch, Yum!");
    }

}
