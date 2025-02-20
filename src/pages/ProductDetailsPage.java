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

public class ProductDetailsPage extends BasePage {

	private WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "inventory_details_name")
	private WebElement itemName;
	
	@FindBy(className = "inventory_details_price")
	private WebElement itemPrice;
	
	@FindBy(id = "add-to-cart")
	private WebElement addToCartButton;
	
	public String getItemName() {
		return itemName.getText();
	}
	
	public String getItemPrice() {
		return itemPrice.getText();
	}
	
	public void tapAddToCartButton() {
		addToCartButton.click();
	}
}
