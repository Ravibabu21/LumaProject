package com.MLI.LUMAAssignment.intialazingBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectingHighestPriceBagPage {
    WebDriver driver;
    WebElement nameOfTheBagElement;
    double max;
    public SelectingHighestPriceBagPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[contains(@class,'minicart-wrapper')]/a") WebElement cartButton;
    @FindBy(xpath = "//strong[@class='subtitle empty']") WebElement cartText;
    public String verifyCart(){
        cartButton.click();
        String cartWebText=cartText.getText();
        System.out.println(cartWebText);

        return cartWebText;
    }


    public String clickingOnHighestPriceBag()  {
        List<WebElement> listOfWEPrices=driver.findElements(By.xpath("//span[@class='price-wrapper ']//span[@class='price']"));
        ArrayList<String> listOfSPrices=new ArrayList<>();
        for (WebElement lp:listOfWEPrices) {
            String priceText=lp.getText();
            listOfSPrices.add(priceText);

        }
        ArrayList<Double> l2= new ArrayList<>();
        for (String ret : listOfSPrices) {
            String str ="";
            for(int i=1;i<ret.length();i++) {
                str= str+ret.charAt(i);
            }
            Double n =Double.parseDouble(str);
            l2.add(n);

        }
         max = l2.get(0);
        for (double x: l2) {
            if (x>max)max=x;

    }

        WebElement nameOfTheBagElement=driver.findElement(By.xpath("//span[@class='price-wrapper ']//span[contains(text(),'"+max+"')]//ancestor::span/..//preceding-sibling::div//preceding-sibling::strong/a"));
        String nameOfTheBagInWeb=nameOfTheBagElement.getText();
        System.out.println(nameOfTheBagInWeb);

        WebElement wishListButton= driver.findElement(By.xpath("//span[@class='price-wrapper ']//span[contains(text(),'"+max+"')]/../../..//following-sibling::div//child::div/div//following-sibling::div/a"));
        Actions actions =new Actions(driver);
        actions.moveToElement(nameOfTheBagElement).perform();

        actions.moveToElement(wishListButton).click().build().perform();
        return nameOfTheBagInWeb;
}

}
