package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    //Lunch the chrome browser
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        // Find the usernameField and enter valid Username
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys("Admin");
        // Find the password Field and enter valid password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Find the login link and click on login link
        WebElement loginLink = driver.findElement(By.xpath("//button[@type='submit']"));
        loginLink.click();

        //Find out Dashboard verify test
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }
    @After
    public void TearDown(){
        closeBrowser();
    }


    }


