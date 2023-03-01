package com.MLI.LUMAAssignment.Testclass;

import com.MLI.LUMAAssignment.intialazingBrowsers.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.ParseException;


public class TestClassForLumaProject extends BaseClassForProject {
    public LoginPage launchingApp;
    public LumaHomePage homepage;
    public SelectingHighestPriceBagPage bagPrice;
    public VerifyWishListPage wishListPage;
    public ClickOnCartButtonOnWLPage cartButtonOnWLPage;
    public ShippingAddressPage shipAddress;
    public ReadingFileFromJson readingFileFromJson;
    @BeforeTest
    public void initializeThePages(){
    launchingApp=new LoginPage(driver);
    homepage=new LumaHomePage(driver);
    bagPrice=new SelectingHighestPriceBagPage(driver);
    wishListPage=new VerifyWishListPage(driver);
    cartButtonOnWLPage=new ClickOnCartButtonOnWLPage(driver);
    shipAddress =new ShippingAddressPage(driver);
    readingFileFromJson = new ReadingFileFromJson();
    }


    @Test(priority = 0)
    public void verifyTheLogin()  {
        launchingApp.loginPage();


    }
    @Test(priority = 1)
    public void verifyTheBags()  {
        homepage.selectingBags();
        bagPrice.verifyCart();
        //Assert.assertEquals(bagPrice.verifyCart(),("You have no items in your shopping cart."));
        bagPrice.clickingOnHighestPriceBag();

    }
    @Test(priority = 2)
    public void verifyTheWishListPageContents() throws InterruptedException, Exception, ParseException {
        wishListPage.verifyNameOfBagInWishList();
        wishListPage.addingToCart();
        wishListPage.verifyTheEmptyCart();
        Thread.sleep(3000);
        cartButtonOnWLPage.cartButtonOnWLPage();
        Thread.sleep(3000);
        shipAddress.shippingAddPage();
       Assert.assertTrue(shipAddress.reviewAndPaymentsPage().isDisplayed());
       Assert.assertTrue(shipAddress.orderDetails().equals("March 1, 2023"));
    }
}
