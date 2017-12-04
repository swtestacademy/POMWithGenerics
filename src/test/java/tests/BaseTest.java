package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.Page;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public Page page;

    @BeforeMethod
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();

        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);

        //Maximize Window
        driver.manage().window().maximize();

        //Instantiate the Page Class
        page = new Page(driver,wait);
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}
