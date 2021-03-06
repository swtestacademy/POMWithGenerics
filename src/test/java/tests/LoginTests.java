package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test (priority = 0)
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException {

        //*************PAGE METHODS WITH JAVA GENERICS********************
        //Open N11 HomePage
        page.GetInstance(HomePage.class).goToN11();

        //Go to LoginPage
        page.GetInstance(HomePage.class).goToLoginPage();

        //Login to N11
        page.GetInstance(LoginPage.class).loginToN11("onur@swtestacademy.com", "11223344");

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        page.GetInstance(LoginPage.class).verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
    }

    @Test (priority = 1)
    public void invalidLoginTest_EmptyUserEmptyPassword () throws InterruptedException {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        homePage.goToN11();
        homePage.goToLoginPage();
        loginPage.loginToN11("","");

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        loginPage.verifyLoginUserName("Lütfen e-posta adresinizi girin.");
        loginPage.verifyLoginPassword("Bu alanın doldurulması zorunludur.");
    }

}
