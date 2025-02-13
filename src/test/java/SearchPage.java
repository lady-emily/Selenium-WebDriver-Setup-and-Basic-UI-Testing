import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;

    // Using @FindBy annotation for locating elements
    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
    }

    public void enterSearchText(String query) {
        searchBox.sendKeys(query);
    }

    public void clickSearchButton() {
        searchBox.submit(); // Works the same as clicking the search button
    }
}
