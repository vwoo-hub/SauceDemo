package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement userNameField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(id = "login-button")
	WebElement loginButton;
	
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
