package com.MLI.LUMAAssignment.intialazingBrowsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/*
Base Class For the Project
 */
public class BaseClassForProject {
    public WebDriver driver;
    DesiredCapabilities desiredCapabilities;
    ChromeOptions chromeOptions;
    @BeforeSuite
    public void initializeBrowsers(){
        WebDriverManager.chromiumdriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Parameters({"serverlink"})
    @BeforeTest
    public void launchBrowser(String serverlink) throws MalformedURLException {
        desiredCapabilities = new DesiredCapabilities();
        chromeOptions = new ChromeOptions();
        desiredCapabilities.setCapability("browser","chrome");
        desiredCapabilities.merge(chromeOptions);
        driver = new RemoteWebDriver(new URL(serverlink),chromeOptions);

        driver.get("https://magento.softwaretestingboard.com/customer/account/");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterTest
    public void killTheSession(){
        driver.quit();
    }

}
