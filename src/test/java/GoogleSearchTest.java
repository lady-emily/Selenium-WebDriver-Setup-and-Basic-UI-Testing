import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class GoogleSearchTest {
    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Locate search box and enter query
            WebElement searchBox = driver.findElement(By.name("q")); // q represents google search box
            searchBox.sendKeys("Selenium WebDriver"); // simulates typing into search box
            searchBox.submit(); // simulates pressing the enter button

            // Wait until the title contains "Selenium WebDriver"
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); //wait 60s until condition is met
            wait.until(ExpectedConditions.titleContains("Selenium WebDriver")); //condition to be met

            // Get the page title after search
            String title = driver.getTitle();
            System.out.println("Page Title: " + title); // Debugging step

            // Verify if the title contains expected text
            if (title.toLowerCase().contains("selenium webdriver")) {
                System.out.println("Test Passed: Title contains the keyword.");
            } else {
                System.out.println("Test Failed: Title does not contain the keyword.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}