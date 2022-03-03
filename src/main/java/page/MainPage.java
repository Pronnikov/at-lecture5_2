package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

//    private static By locator1 = By.xpath ("doubleClickBtn");
//    private static By locator2 = By.xpath ("rightClickBtn");
    private static By locator3 = By.xpath ("//button[text()='Click Me']");

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    public MainPage getText() {
//        driver.findElement(locator1).click();
//        driver.findElement(locator2).click();
        driver.findElement(locator3).click();
        return new MainPage(driver);
    }


}
