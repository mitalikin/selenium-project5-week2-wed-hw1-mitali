package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {

    String baseurl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // click on the ‘Sign In’ link
        clickOnElement(By.linkText("Sign In"));
        // Verify the text ‘Welcome Back!'
        String expectedMessageField = "Welcome Back!";
        String actualMessage = getTextToElement(By.xpath("//h1[text()='Welcome Back!']"));
        Assert.assertEquals("Invalid password entered", expectedMessageField, actualMessage);
    }
    @Test
    public void verifyTheErrorMessage() {
        // click on the ‘Sign In’ link
        clickOnElement(By.linkText("Sign In"));
        //Enter invalid username
        sendTextToElement(By.id("user[email]"), "123test@gmail.com");
        // Enter invalid password
        sendTextToElement(By.id("user[password]"), "123test");
        // Click on Login button
        clickOnElement(By.xpath("//input[@type='submit']"));
        //Verify the error message ‘Invalid email or password.’
        String expectedMessageField = "Invalid email or password.";
        String actualMessage = getTextToElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        Assert.assertEquals("Error message not display", expectedMessageField, actualMessage);
    }
    @After
    public void testDown() {
        closeBrowser();
    }

}
