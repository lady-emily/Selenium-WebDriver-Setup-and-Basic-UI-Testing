import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
    public static void main(String[] args) {
        // Automatically download and set up ChromeDriver
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); // Launch Chrome

        try {
            driver.get("https://www.google.com");

            WebElement searchBox = driver.findElement(By.name("q")); //finding the google search box, q is the name
            searchBox.sendKeys(" Selenium WebDriver"); //simulates typing the keys in the search box
            searchBox.submit(); // simulates pressing "enter"

            Thread.sleep(5000); //ttl searcg results, 6seconds

            String title = driver.getTitle();
            if (title.contains("Selenium WebDriver")) {
                System.out.println("Test Passed: Title contains the keyword.");
            } else {
                System.out.println("Test Failed: Title does not contain the keyword.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); //closes the browser
        }
    }
}