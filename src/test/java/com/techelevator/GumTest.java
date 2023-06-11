package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {
    @Test
    public void D1_returns_Chew_Chew_yum_() {
        // Arrange
        Gum gum = new Gum("C1", "", 1.50, "chips");
        String expectedMessage = "Chew Chew, Yum!";

        // Act
        gum.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Chew Chew, Yum!");
    }
    @Test
    public void D2_returns_Chew_Chew_yum_() {
        // Arrange
        Gum gum = new Gum("C1", "", 1.50, "chips");
        String expectedMessage = "Chew Chew, Yum!";

        // Act
        gum.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Chew Chew, Yum!");
    }
    @Test
    public void D3_returns_Chew_Chew_yum_() {
        // Arrange
        Gum gum = new Gum("C1", "", 1.50, "chips");
        String expectedMessage = "Chew Chew, Yum!";

        // Act
        gum.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Chew Chew, Yum!");
    }
    @Test
    public void D4_returns_Chew_Chew_yum_() {
        // Arrange
        Gum gum = new Gum("C1", "", 1.50, "chips");
        String expectedMessage = "Chew Chew, Yum!";

        // Act
        gum.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Chew Chew, Yum!");
    }
}
