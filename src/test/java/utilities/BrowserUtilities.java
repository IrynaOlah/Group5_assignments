package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BrowserUtilities {

    public static void LogInToLibrary(WebDriver driver) {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://library2.cybertekschool.com/login.html");
        WebElement inputUsername = driver.findElement(By.id("inputEmail"));
        inputUsername.sendKeys("student11@library");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("tScBPCUr");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
        loginButton.click();
    }
}
