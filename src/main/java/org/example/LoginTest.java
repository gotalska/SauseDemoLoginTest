package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends org.example.BaseTest {

    @Test
    public void userShouldLoginWithValidCredentials() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(driver.findElement(By.cssSelector(".title")).isDisplayed(), "User was not logged in");
    }

    @Test
    public void UserShouldLoginWithPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Password is required", "the error is incorrect");
    }
}
