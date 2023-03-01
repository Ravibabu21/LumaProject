package com.MLI.LUMAAssignment.intialazingBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.text.ParseException;


public class ShippingAddressPage {
    WebDriver driver;
    ReadingFileFromJson readJson;
    CommonActionsClass commonActionsClass;

    public ShippingAddressPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        readJson=new ReadingFileFromJson();
        commonActionsClass=new CommonActionsClass(driver);


    }
    @FindBy (xpath = "//div[@class='field _required']//child::div/input[@name='lastname']") WebElement inputLastName;
    @FindBy(xpath = "//div[@class='field _required']//child::div/input[@name='firstname']") WebElement inputFirstName;
    @FindBy(xpath = "//div[@class='field _required']//child::div/input[@name='street[0]']") WebElement inputStreetAdd;
    @FindBy(xpath = "//div[@class='field _required']//child::div/input[@name='city']") WebElement inputCity;
    @FindBy(xpath = "//div[@class='field _required']//child::div/select[@name='region_id']") WebElement inputRegion;
    @FindBy(xpath = "//div[@class='field _required']//child::div/select[@name='country_id']") WebElement inputCountry;
    @FindBy(xpath = "//div[@class='field _required']//child::div/input[@name='postcode']") WebElement inputZipcode;
    @FindBy(xpath = "//div[@class='field _required']//child::div/input[@name='telephone']") WebElement inputPhone;
    @FindBy (xpath = "//button[@class='button action continue primary']") WebElement nextButton;
    @FindBy(xpath = "//button[@class='action primary checkout']") WebElement placeOrderButton;
    @FindBy (xpath = "//a[@class='order-number']") WebElement orderNumber;
    @FindBy(xpath = "//span[@class='base']") WebElement oderNumberInMyOders;
    @FindBy(xpath = "//div[@class='order-date']/span//following-sibling::span") WebElement oderDate;
    @FindBy(xpath = "//button[@class='action action-show-popup']") WebElement newAddressButton;
    @FindBy(xpath = "//button[@class='action primary action-save-address']") WebElement shipHereButton;
   // @FindBy(xpath = "//button[@class='action action-select-shipping-item']") WebElement sb;
    public void shippingAddPage() throws Exception, ParseException {

        newAddressButton.click();
        Thread.sleep(3300);
        commonActionsClass.selectValueFromDropDown(inputCountry,"India","text");
        commonActionsClass.selectValueFromDropDown(inputRegion,"Telangana","text");
        commonActionsClass.EnterValueOnTextField(inputStreetAdd,readJson.readFile("streetName"));
        commonActionsClass.EnterValueOnTextField(inputCity,readJson.readFile("city"));
        commonActionsClass.EnterValueOnTextField(inputZipcode,readJson.readFile("zipCode"));
        commonActionsClass.EnterValueOnTextField(inputPhone, readJson.readFile("phone"));
//        commonActionsClass.EnterValueOnTextField(inputStreetAdd,"2-22/98");
//        commonActionsClass.EnterValueOnTextField(inputCity,"Hyderabad");
//        commonActionsClass.EnterValueOnTextField(inputZipcode,"500084");
//        commonActionsClass.EnterValueOnTextField(inputPhone,"0123654789");
        /*inputStreetAdd.sendKeys("22/22/99");
        inputCity.sendKeys("Hyderabad");*/
        shipHereButton.click();
        commonActionsClass.clickOnElement(nextButton);

    }
    public WebElement reviewAndPaymentsPage(){
        WebElement billingDetails= driver.findElement(By.xpath("//div[@class='billing-address-details']"));
        placeOrderButton.click();

    return billingDetails;
    }
    public String orderDetails(){
        orderNumber.click();
        String orderNo= oderNumberInMyOders.getText();
       String orderDateInMyOder= oderDate.getText();
       return orderDateInMyOder;
    }
}
