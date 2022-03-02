import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        //DZ4.1
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/buttons");

        WebElement doubleClick = webDriver.findElement(By.id("doubleClickBtn"));
        WebElement rightClick = webDriver.findElement(By.id("rightClickBtn"));
        WebElement click = webDriver.findElement(By.xpath("//button[text()='Click Me']"));

        new Actions(webDriver)
        .doubleClick(doubleClick)
        .contextClick(rightClick)
        .click(click)
        .build ()
        .perform();

        boolean isHaveDoubleClickText = !webDriver.findElements(By.xpath(
                "//p[text()='You have done a double click']")).isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(By.xpath(
                "//p[text()='You have done a right click']")).isEmpty();
        boolean isHaveClickMeText = !webDriver.findElements(By.xpath(
                "//p[text()='You have done a dynamic click']")).isEmpty();
        webDriver.quit();

        if (isHaveClickMeText && isHaveDoubleClickText && isHaveRightClickText) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }

        //DZ4.2
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(7));
//        webDriver.get("https://demoqa.com/alerts");
//
//        WebElement alert = webDriver.findElement(By.id("alertButton"));
//        WebElement alertTimer = webDriver.findElement(By.id("timerAlertButton"));
//        WebElement confirmButton = webDriver.findElement(By.id("confirmButton"));
//
//        alert.click();
//        webDriver.switchTo().alert().accept();
//        alertTimer.click();
//        webDriverWait.until(ExpectedConditions.alertIsPresent())
//        .accept();
//        confirmButton.click();
//        webDriver.switchTo().alert().dismiss();
//
//        boolean isHaveText = !webDriver.findElements(By.xpath(
//                "//span[contains(., 'Cancel')]")).isEmpty();
//        if (isHaveText) {
//            System.out.println("Тест пройден");
//        } else {
//            System.out.println("Тест не пройден");
//        }
//
    }

}
