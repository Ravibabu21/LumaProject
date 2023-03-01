package com.MLI.LUMAAssignment.intialazingBrowsers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaHomePage {
    WebDriver driver;
    public LumaHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Gear']")
    WebElement gearButton;
    @FindBy (xpath="//span[text()='Bags']") WebElement bagsButton;


    public void selectingBags(){
        Actions actions=new Actions(driver);
        actions.moveToElement(gearButton).perform();
        actions.click(bagsButton).perform();

    }
}
