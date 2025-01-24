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
	private WebElement errorMessage;
	
	public void typeUserNameField(String userName) {
		userNameField.sendKeys(userName);
	}
	
	public void typePasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void tapLoginButton() {
		loginButton.click();
	}
	
	public void logIn(String userName, String password) {
		typeUserNameField(userName);
		typePasswordField(password);
		tapLoginButton();
	}
	
	public void tapErrorMessageButton() {
		errorMessageButton.click();
		waitForElementToDisappear(errorMessageButton);
	}
	
	public String getErrorMessageText() {
		waitForWebElement(errorMessage);
		return errorMessage.getText();
	}
	
	public String getLogInButtonText() {
		waitForWebElement(loginButton);
		return loginButton.getDomAttribute("value");
	}
}
