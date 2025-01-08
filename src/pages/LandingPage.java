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
	private WebElement userNameField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	@FindBy(css = ".error-button")
	private WebElement errorMessageButton;
	
	@FindBy(css = ".error-message-container.error")
	private WebElement errorMessageText;
	
	public void typeUserNameField(String user) {
		userNameField.sendKeys(user);
	}
	
	public void typePasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void tapLoginButton() {
		loginButton.click();
	}
	
	public void tapErrorMessageButton() {
		errorMessageButton.click();
		waitForElementToDisappear(errorMessageButton);
	}
	
	public String getErrorMessageText() {
		waitForWebElement(errorMessageText);
		return errorMessageText.getText();
	}
}
