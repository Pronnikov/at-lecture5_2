package page;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {
    WebDriver driver;

    private final static String expectedText1 = "Double Click Me";
    private final static String expectedText2 = "Right Click Me";
    private final static String expectedText3 = "Click Me";

    private final static By doubleClickLocator = By.xpath("//button[text()='Double Click Me']");
    //By.id ("doubleClickBtn");
    private final static By rightClickLocator = By.id ("rightClickBtn");
    private final static By clickLocator = By.xpath ("//button[text()='Click Me']");

//    public String getDoubleClickLocator() {
//        return driver.findElement(doubleClickLocator).getText();
//    }
//    public String getRightClickLocator() {
//        return driver.findElement(rightClickLocator).getText();
//    }
//    public String getClickLocator() {
//        return driver.findElement(clickLocator).getText();
//    }

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    @Step ("Нажимаем на кнопки")
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

    @Step ("Проверяем результат")
    public void assertText() {
        String isHaveDoubleClickText = driver.findElement(doubleClickLocator).getText();
        String isHaveRightClickText = driver.findElement(rightClickLocator).getText();
        String isHaveClickMeText = driver.findElement(clickLocator).getText();
        Assert.assertEquals("Обьекты не равны", expectedText1,isHaveDoubleClickText);
        Assert.assertEquals("Обьекты не равны", expectedText2,isHaveRightClickText);
        Assert.assertEquals("Обьекты не равны", expectedText3,isHaveClickMeText);

    }
}
