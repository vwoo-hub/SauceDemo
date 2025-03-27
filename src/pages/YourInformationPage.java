package pages;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.base.Functions;

public class YourInformationPage extends BasePage {
	
	private WebDriver driver;

	public YourInformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first-name")
	private WebElement firstNameTextField;
	
	@FindBy(id = "last-name")
	private WebElement lastNameTextField;
	
	@FindBy(id = "postal-code")
	private WebElement zipTextField;
	
	@FindBy(id = "continue")
	private WebElement continueButton;
	
	@FindBy(css = "h3[data-test='error']")
	private WebElement errorLabel;
	
	public void typeFirstNameTextField(String firstName) {
		firstNameTextField.sendKeys(firstName);
	}
	
	public void typeLastNameTextField(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}
	
	public void typeZipTextField(String zipCode) {
		zipTextField.sendKeys(zipCode);
	}
	
	public void tapContinueButton() {
		continueButton.click();
	}
	
	public String getErrorLabel() {
		return errorLabel.getText();
	}
}
