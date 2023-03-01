package com.MLI.LUMAAssignment.intialazingBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class VerifyWishListPage {
    WebDriver driver;

    public VerifyWishListPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//strong[@class='product-item-name']/a")
    WebElement nameOfTheBagInWishList;
    @FindBy(xpath = "//span[text()='Impulse Duffle']/../..//following-sibling::div[@class='product-item-actions']/div/button/span")
    WebElement clickOnAddToCartButton;
    @FindBy (xpath = "//div[@class='message info empty']/span") WebElement emptyWishList;

    public String verifyNameOfBagInWishList(){
        String nameOfBag= nameOfTheBagInWishList.getText();
        return nameOfBag;
    }
    public void addingToCart(){
        clickOnAddToCartButton.click();
    }
    public String verifyTheEmptyCart(){
       String textOfEmptyWishList=emptyWishList.getText();
        System.out.println(textOfEmptyWishList);
       return textOfEmptyWishList;
    }

}
