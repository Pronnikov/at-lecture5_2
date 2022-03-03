import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;
import java.time.Duration;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        //DZ4.1
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/buttons");

        MainPage mainPage = new MainPage(driver);
        mainPage.getText();

    }
}
