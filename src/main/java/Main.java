import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.StartPage;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {


        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/buttons");

        StartPage startPage = new StartPage(webDriver);
        startPage.clickButton();
        startPage.getText();

        webDriver.quit();


    }

}

