import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Main {

    public static void main(String[] args) {

            //System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
           WebDriver webDriver = new ChromeDriver();
           webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(7));
           //webDriver.get("https://demoqa.com/buttons");
           webDriver.get("https://demoqa.com/alerts");
           // WebElement doubleClick = webDriver.findElement(By.id("doubleClickBtn"));
           // WebElement rightClick = webDriver.findElement(By.id("rightClickBtn"));
           // WebElement click = webDriver.findElement(By.xpath("//button[text()='Click Me']"));
              WebElement alert = webDriver.findElement(By.id("alertButton"));
              WebElement alertTimer = webDriver.findElement(By.id("timerAlertButton"));
              WebElement confirmButton = webDriver.findElement(By.id("confirmButton"));
          //  new Actions(webDriver)
        //           .doubleClick(doubleClick)
        //           .contextClick(rightClick)
        //           .click(click)
        //           .build()
        //           .perform();
       
        alert.click();
        webDriver.switchTo().alert().accept();
        alertTimer.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent())
                .accept();
        confirmButton.click();
        webDriver.switchTo().alert().dismiss();
        boolean isHaveText = !webDriver.findElements(By.xpath("//span[contains(.,'Cancel')]")).isEmpty();
        // boolean isHaveDoubleClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a double click']")).isEmpty();
       // boolean isHaveRightClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a right click']")).isEmpty();
       // boolean isHaveClickmeClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a dynamic click']")).isEmpty();
        webDriver.quit();



       // if (isHaveDoubleClickText && isHaveRightClickText && isHaveClickmeClickText) {
            if (isHaveText){
        System.out.println("Тест пройден успешно");
        } else{
            System.out.println("Тест не пройден");
        }

        }

    }

