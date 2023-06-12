package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ChipTest {
    @Test
    public void A1_returns_Crunch_Crunch_yum_() {
        // Arrange
        Chip chip = new Chip("A4", "Cloud Popcorn", 3.65, "chips");
        String expectedMessage = "Crunch Crunch, Yum!";

        // Act
        chip.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Crunch Crunch, Yum!");
    }
    @Test
    public void A2_returns_Crunch_Crunch_yum_() {
        // Arrange
        Chip chip = new Chip("A3", "Grain Waves", 2.75, "chips");
        String expectedMessage = "Crunch Crunch, Yum!";

        // Act
        chip.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Crunch Crunch, Yum!");
    }
    @Test
    public void A3_returns_Crunch_Crunch_yum() {
        // Arrange
        Chip chip = new Chip("A1", "Potato Crisps", 3.05, "chips");
        String expectedMessage = "Crunch Crunch, Yum!";

        // Act
        chip.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Crunch Crunch, Yum!");
    }
    @Test
    public void A4_returns_Crunch_Crunch_yum_() {
        // Arrange
        Chip chip = new Chip("A2", "Stackers", 1.45, "chips");
        String expectedMessage = "Crunch Crunch, Yum!";

        // Act
        chip.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Crunch Crunch, Yum!");
    }

}
