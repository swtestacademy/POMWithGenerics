package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;


/**
 * Created by obaskirt on 08-Nov-17.
 */
public class Page {

    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public Page(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //JAVA Generics to Create and return a New Page
    public  <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
