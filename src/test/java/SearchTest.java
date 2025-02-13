import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    private static WebDriver driver;
    private static SearchPage searchPage;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup(); // Manages ChromeDriver
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Initialize SearchPage object
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testSearchFunctionality() {
        searchPage.enterSearchText("Selenium WebDriver");
        searchPage.clickSearchButton();

        // Wait until title contains "Selenium WebDriver"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));

        // Verify if the title contains expected text
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        assertTrue(title.toLowerCase().contains("selenium webdriver"), "Title does not contain the expected text");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
