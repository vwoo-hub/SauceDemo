package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.base.Functions;

public class CartPage extends BasePage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id = "continue-shopping")
	private WebElement continueShoppingButton;
	
	@FindBy(id = "item_0_title_link")
	private WebElement bikeLightLabel;
	
	@FindBy(id = "item_4_title_link")
	private WebElement backpackLabel;
	
	@FindBy(id = "item_2_title_link")
	private WebElement onesieLabel;
	
	@FindBy(id = "item_1_title_link")
	private WebElement shirtLabel;
	
	@FindBy(id = "item_5_title_link")
	private WebElement fleeceJacketLabel;

	@FindBy(id = "item_3_title_link")
	private WebElement alltheThingsShirtLabel;
	
	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removeBackpackButton; 
	
	@FindBy(id = "remove-sauce-labs-bike-light")
	private WebElement removeBikeLightButton; 
	
	@FindBy(id = "remove-sauce-labs-fleece-jacket")
	private WebElement removeFleeceJacketButton; 
	
	@FindBy(id = "remove-sauce-labs-bolt-t-shirt")
	private WebElement removeShirtButton; 
	
	@FindBy(id = "remove-sauce-labs-onesie")
	private WebElement removeOnesieButton; 
	
	@FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
	private WebElement removeAllTheThingsShirtButton;
	
	@FindBy(id = "checkout")
	private WebElement checkoutButton;
	
	private List<String> productsInCartList = new ArrayList<String>();
	
	public void tapContinueShoppingButton() {
		continueShoppingButton.click();
	}
	
	public void tapCheckoutButton() {
		checkoutButton.click();
	}
	
	public void tapProductName(String productName) {
		String xpath = "//div[@data-test='inventory-item-name' and text()='" + productName + "']";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public String getProductNameFromCart(String productName) {
		switch (productName) {
			case "Sauce Labs Backpack": {
				return backpackLabel.getText();
			}
			case "Sauce Labs Bike Light": {
				return bikeLightLabel.getText();
			}
			case "Sauce Labs Bolt T-Shirt": {
				return shirtLabel.getText();
			}
			case "Sauce Labs Fleece Jacket": {
				return fleeceJacketLabel.getText();
			}
			case "Sauce Labs Onesie": {
				return onesieLabel.getText();
			}
			case "Test.allTheThings() T-Shirt (Red)": {
				return alltheThingsShirtLabel.getText();
			}
			default:
            throw new IllegalArgumentException("Unknown product name: " + productName);
		}
	}
	
	public void tapProductNameButton(String productName) {
		switch (productName) {
			case "Sauce Labs Backpack": {
				backpackLabel.click();
				break;
			}
			case "Sauce Labs Bike Light": {
				bikeLightLabel.click();
				break;
			}
			case "Sauce Labs Bolt T-Shirt": {
				shirtLabel.click();
				break;
			}
			case "Sauce Labs Fleece Jacket": {
				fleeceJacketLabel.click();
				break;
			}
			case "Sauce Labs Onesie": {
				onesieLabel.click();
				break;
			}
			case "Test.allTheThings() T-Shirt (Red)": {
				alltheThingsShirtLabel.click();
				break;
			}
			default:
            throw new IllegalArgumentException("Unknown product name: " + productName);
		}
	}
	
	public void removeProductFromCart(String productName) {
		switch (productName) {
			case "Sauce Labs Backpack": {
				removeBackpackButton.click();
				break;
			}
			case "Sauce Labs Bike Light": {
				removeBikeLightButton.click();
				break;
			}
			case "Sauce Labs Bolt T-Shirt": {
				removeShirtButton.click();
				break;
			}
			case "Sauce Labs Fleece Jacket": {
				removeFleeceJacketButton.click();
				break;
			}
			case "Sauce Labs Onesie": {
				removeOnesieButton.click();
				break;
			}
			case "Test.allTheThings() T-Shirt (Red)": {
				removeAllTheThingsShirtButton.click();
				break;
			}
			default:
	            throw new IllegalArgumentException("Unknown product name: " + productName);
	    }
	}


}
