package com.MLI.LUMAAssignment.intialazingBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/*
Clicking on CartButton on the WishList Page
*/
public class ClickOnCartButtonOnWLPage {
    WebDriver driver;
    public ClickOnCartButtonOnWLPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//div[contains(@class,'minicart-wrapper')]/a")
    WebElement cartButtonOnWL;
    @FindBy(xpath = "//button[text()='Proceed to Checkout']") WebElement checkOutButton;
    public void cartButtonOnWLPage(){
        cartButtonOnWL.click();

        checkOutButton.click();
    }
}
