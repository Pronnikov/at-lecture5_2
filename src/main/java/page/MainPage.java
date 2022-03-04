package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    WebDriver driver;

    private static By doubleClickLocator = By.id ("doubleClickBtn");
    private static By rightClickLocator = By.id ("rightClickBtn");
    private static By clickLocator = By.xpath ("//button[text()='Click Me']");


    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    public MainPage click() {
        WebElement doubleClick = driver.findElement(doubleClickLocator);
        WebElement rightClick = driver.findElement(rightClickLocator);
        WebElement click = driver.findElement(clickLocator);
        new Actions(driver)
        .doubleClick(doubleClick)
        .contextClick(rightClick)
        .click(click)
        .build ()
        .perform();
        return new MainPage(driver);
    }

    public void assertText () {
        boolean isHaveDoubleClickText = !driver.findElements(doubleClickLocator).isEmpty();
        boolean isHaveRightClickText = !driver.findElements(rightClickLocator).isEmpty();
        boolean isHaveClickMeText = !driver.findElements(clickLocator).isEmpty();
        if (isHaveClickMeText && isHaveDoubleClickText && isHaveRightClickText) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
    }


}
