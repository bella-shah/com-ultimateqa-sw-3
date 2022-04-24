package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        //this message is from requirement
        String expectedMessage = "Welcome Back!";
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='page__heading']"));
        System.out.println(actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //click
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        //sending username/email & password to elements
        sendTextToElement(By.id("user[email]"), "prime123@gmai.com");
        sendTextToElement(By.id("user[password]"), "prime123");
        //click
        clickOnElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        //This is from requirement
        String expectedMessage = "Invalid email or password.";
        String actualMessage = getTextFromElement(By.xpath("//ul[@class='form-error__list']"));
    }

    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }

}

