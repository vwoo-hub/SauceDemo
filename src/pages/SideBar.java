package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar extends BasePage {

	private WebDriver driver;
	
	public SideBar(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "inventory_sidebar_link")
	private WebElement allItemsButton;
	
	@FindBy(id = "about_sidebar_link")
	private WebElement aboutButton;

	@FindBy(id = "logout_sidebar_link")
	private WebElement logOutButton;
	
	@FindBy(id = "reset_sidebar_link")
	private WebElement resetAppStateButton;
	
	@FindBy(id = "react-burger-cross-btn")
	private WebElement dismissButton;

	public void tapAllItemsButton() {
		allItemsButton.click();
	}
	
	public void tapAboutButton() {
		aboutButton.click();
	}
	
	public void tapLogOutButton() {
		logOutButton.click();
	}
	
	public void tapResetAppStateButton() {
		resetAppStateButton.click();
	}
	
	public void tapDismissButton() {
		dismissButton.click();
	}
}
