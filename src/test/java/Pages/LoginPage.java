package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {
    WebDriver driver;
    WebElement username;
    WebElement password;
    WebElement login;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmit() {
        return driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
    }

    public void clickOnLogin() {
        getSubmit().click();
    }

    public WebElement getMessage() {
        return driver.findElement(By.id("flash"));
    }

}
