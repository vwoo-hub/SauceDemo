package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {

	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='app_logo']")
	private WebElement titleHeader;
	
	public String getTitleHeaderText() {
		waitForWebElement(titleHeader);
		return titleHeader.getText();
	}
}
