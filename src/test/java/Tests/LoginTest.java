package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("http://the-internet.herokuapp.com/login");
    }

    @Test
    public void validUsernameValidPassword() {
        String validUsername = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);
        loginPage.getUsername().sendKeys(validUsername);
        loginPage.getPassword().sendKeys(validPassword);
        loginPage.clickOnLogin();

        Assert.assertEquals(loginPage.getMessage().getText(), "You logged into a secure area!\n" + "×");
    }

    @Test
    public void invalidUsernameValidPassword() {
        String invalidUsername = excelReader.getStringData("Sheet1", 1, 2);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);
        loginPage.getUsername().sendKeys(invalidUsername);
        loginPage.getPassword().sendKeys(validPassword);
        loginPage.clickOnLogin();

        Assert.assertEquals(loginPage.getMessage().getText(), "Your username is invalid!\n" + "×");
    }

    @Test
    public void validUsernameInvalidPassword() {
        String validUsername = excelReader.getStringData("Sheet1", 1, 0);
        String invalidPassword = excelReader.getStringData("Sheet1", 1, 3);
        loginPage.getUsername().sendKeys(validUsername);
        loginPage.getPassword().sendKeys(invalidPassword);
        loginPage.clickOnLogin();

        Assert.assertEquals(loginPage.getMessage().getText(), "Your password is invalid!\n" + "×");

    }

    @Test
    public void invalidUsernameInvalidPassword() {
        String invalidUsername = excelReader.getStringData("Sheet1", 1, 2);
        String invalidPassword = excelReader.getStringData("Sheet1", 1, 3);
        loginPage.getUsername().sendKeys(invalidUsername);
        loginPage.getPassword().sendKeys(invalidPassword);
        loginPage.clickOnLogin();

        Assert.assertTrue(loginPage.getSubmit().isDisplayed());
    }
}
