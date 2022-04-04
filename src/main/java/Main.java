import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;

import java.time.Duration;

public class Main {
    static WebDriver driver;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(180);

    public static void main(String[] args) {
    }

    @BeforeClass
    public static void beforeClassMethod() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void afterClassMethod() {
        System.out.println("AfterClass");
    }

    @Before
    public void beforeMethod() {
        driver = new ChromeDriver();
        System.out.println("Before");
    }

    @After
    public void afterMethod() {
        System.out.println("After");
        if (driver != null) driver.quit();
    }

    @Test
    public void test1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/buttons");
        MainPage mainPage = new MainPage(driver);
        mainPage.click();
        mainPage.assertText();
    }
}
