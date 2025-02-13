import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //initialise chrome
        driver.get("https://www.google.com"); //load Google
        System.out.println("Opened Google!"); //test for connection
        driver.quit(); //close browser
    }
}
