package com.MLI.LUMAAssignment.intialazingBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "#email")
    WebElement emailInput;
    @FindBy(name = "login[password]") WebElement passwordInput;
   @FindBy(xpath ="//button[@class='action login primary']") WebElement signInButton;
    public void loginPage()  {
    emailInput.sendKeys("ravi18babu@gmail.com");
    passwordInput.sendKeys("Ravibabu@123");
    signInButton.click();
    }
}