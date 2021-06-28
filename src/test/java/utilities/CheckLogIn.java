package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckLogIn {
    public static boolean LogIn(String username, String password){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://qa3.vytrack.com/user/login");
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='_username']"));
        inputUsername.sendKeys(username);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='_password']"));
        inputPassword.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-uppercase btn-primary pull-right']"));
        loginButton.click();
        String expectedHomePageTitle = "Dashboard";
        String actualHomePageTitle = driver.getTitle();
        if (actualHomePageTitle.equals(expectedHomePageTitle)) {
            System.out.println("Successfully login to my account!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }
}
