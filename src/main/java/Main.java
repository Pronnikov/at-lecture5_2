import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class Main {

    public static void main(String[] args) {

            //System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
            WebDriver webDriver = new ChromeDriver();
           webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            webDriver.get("https://demoqa.com/buttons");

            WebElement doubleClick = webDriver.findElement(By.id("doubleClickBtn"));
            WebElement rightClick = webDriver.findElement(By.id("doubleClickBtn"));
            WebElement click = webDriver.findElement(By.xpath("//button[text()='Click me']"));

            new Actions(webDriver)
                    .doubleClick(doubleClick)
                    .contextClick(rightClick)
                    .click(click)
                    .build()
                    .perform();

        boolean isHaveDoubleClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a double click']")).isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a right click']")).isEmpty();
        boolean isHaveClickmeClickText = !webDriver.findElements(By.xpath("//p[text()='You have done a dynamic click']")).isEmpty();
        webDriver.quit();

        if (isHaveDoubleClickText && isHaveRightClickText && isHaveClickmeClickText) {
            System.out.println("Тест пройден успешно");
        } else{
            System.out.println("Тест не пройден");
        }

        }

    }

