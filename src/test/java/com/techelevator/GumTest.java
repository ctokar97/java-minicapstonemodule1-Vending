package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {
    @Test
    public void D1_returns_Chew_Chew_yum_() {
        // Arrange
        Gum gum = new Gum("D1", "U-Chews", 0.85, "gum");
        String expectedMessage = "Chew Chew, Yum!";

        // Act
        gum.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Chew Chew, Yum!");
    }
    @Test
    public void D2_returns_Chew_Chew_yum_() {
        // Arrange
        Gum gum = new Gum("D2", "Little League Chew", 0.95, "chips");
        String expectedMessage = "Chew Chew, Yum!";

        // Act
        gum.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Chew Chew, Yum!");
    }
    @Test
    public void D3_returns_Chew_Chew_yum_() {
        // Arrange
        Gum gum = new Gum("D3", "Chiclets", 0.75, "gum");
        String expectedMessage = "Chew Chew, Yum!";

        // Act
        gum.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Chew Chew, Yum!");
    }
    @Test
    public void D4_returns_Chew_Chew_yum_() {
        // Arrange
        Gum gum = new Gum("D4", "Triplemint", 0.75, "gum");
        String expectedMessage = "Chew Chew, Yum!";

        // Act
        gum.message();

        // Assert
        Assert.assertEquals(expectedMessage, "Chew Chew, Yum!");
    }
}
