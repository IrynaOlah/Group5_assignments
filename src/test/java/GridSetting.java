
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class GridSetting {
    @Test
    public void setupMethod() {
        Driver.getDriver().get("http://qa3.vytrack.com/user/login");
        WebElement inputUsername =  Driver.getDriver().findElement(By.xpath("//input[@name='_username']"));
        inputUsername.sendKeys("user13");
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='_password']"));
        inputPassword.sendKeys("UserUser123");
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-uppercase btn-primary pull-right']"));
        loginButton.click();
        WebElement dropdownFleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        dropdownFleet.click();
        WebElement optionVehicles = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
        optionVehicles.click();
        WebElement resetButton = Driver.getDriver().findElement(By.xpath("//a[@title='Reset']"));
        WebElement gridSettingsExpected = Driver.getDriver().findElement(with(By.xpath("//a[@title='Grid Settings']")).toRightOf(resetButton));
        WebElement gridSettingsActual = Driver.getDriver().findElement(By.xpath("//a[@title='Grid Settings']"));
        Assert.assertEquals(gridSettingsActual, gridSettingsExpected);

    }
}
