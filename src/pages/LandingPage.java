package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
	
	private WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	public WebElement userNameField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(id = "login-button")
	public WebElement loginButton;
	
	public void typeUserNameField(String user) {
		userNameField.sendKeys(user);
	}
	
	public void typePasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void tapLoginButton() {
		loginButton.click();
	}
}
