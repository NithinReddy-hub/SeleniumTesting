package SeleniumIntegration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
    public String baseUrl="http://demo.guru99.com/test/newtours/";
    public String driverPath="src\\test\\resources\\Drivers\\chromedriver.exe";
    public WebDriver driver ; 
     //creating test annotations
     @BeforeTest
      public void launchBrowser() {
          System.out.println("launching chrome browser"); 
          System.setProperty("webdriver.chrome.driver",driverPath);
          driver=new ChromeDriver();
          driver.get(baseUrl);
          driver.manage().window().maximize();
       
     }
      @Test
      public void verifyHomepageTitle() {
    	
          String expectedTitle = "Welcome: Mercury Tours";
          String actualTitle = driver.getTitle();
          System.out.println(actualTitle);
          Assert.assertEquals(actualTitle, expectedTitle);
     }
      @AfterTest
      public void terminateBrowser(){
          driver.close();
      }
}