import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
        WebDriver driver;

        // Step 3: Use @FindBy to locate elements
        @FindBy(name = "q")  // Search input field
        private WebElement searchBox;

        @FindBy(name = "btnK")  // Search button
        private WebElement searchButton;

        // Step 4: Constructor initializes elements using PageFactory
        public SearchPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        // Step 5: Define methods for search functionality
        public void enterSearchText(String searchText) {
            searchBox.sendKeys(searchText);
        }

        public void clickSearchButton() {
            searchButton.submit();  // or searchButton.click();
        }
}
