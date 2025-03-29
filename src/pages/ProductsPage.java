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

public class ProductsPage extends BasePage {

	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addBackpackButton;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement addBikeLightButton;
	
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	private WebElement addFleeceJacketButton;
	
	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement addShirtButton;
	
	@FindBy(id = "add-to-cart-sauce-labs-onesie")
	private WebElement addOnesieButton;
	
	@FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
	private WebElement addAllTheThingsShirtButton;
	
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
	
	@FindBy(className = "inventory_item_name")
	private List<WebElement> itemNameList; 
	
	@FindBy(className = "inventory_item_price")
	private List<WebElement> itemPriceList;
	
	@FindBy(css = ".product_sort_container")
	private WebElement dropDownButton;
	
	private List<String> addedProductsList = new ArrayList<>();
	
	public void tapDropDownButton() {
		dropDownButton.click();
	}
	
	public void tapProductName(String productName) {
		String xpath = "//div[@data-test='inventory-item-name' and text()='" + productName + "']";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void addProductToCart(String productName) {
		switch(productName) {
			case "Sauce Labs Backpack": {
				addBackpackButton.click();
				break;
			}
			case "Sauce Labs Bike Light": {
				addBikeLightButton.click();
				break;
			}
			case "Sauce Labs Bolt T-Shirt": {
				addShirtButton.click();
				break;
			}
			case "Sauce Labs Fleece Jacket": {
				addFleeceJacketButton.click();
				break;
			}
			case "Sauce Labs Onesie": {
				addOnesieButton.click();
				break;
			}
			case "Test.allTheThings() T-Shirt (Red)": {
				addAllTheThingsShirtButton.click();
				break;
			}
			default:
	            throw new IllegalArgumentException("Unknown product name: " + productName);
		}
		
		addedProductsList.add(productName);
	}
	
	public List<String> getAddedProducts() {
		return new ArrayList<>(addedProductsList);
    }
	
	public void selectDropdownOption(String visibleText) {
        Select dropdown = new Select(dropDownButton);
        dropdown.selectByVisibleText(visibleText); 
    }

	public List<String> getItemList() {
		return itemNameList.stream().map(name -> name.getText().toLowerCase()).collect(Collectors.toList());
	}
	
	public List<String> getItemListOriginal() {
		return itemNameList.stream().map(name -> name.getText()).collect(Collectors.toList());
	}
	
	public List<String> getItemPriceList() {
		return itemPriceList.stream().map(price -> price.getText().substring(1)).collect(Collectors.toList());
	}
	
	public List<String> expectedItemListAToZ() {
		List<String> expectedItemNameList = getItemList().stream().sorted().collect(Collectors.toList());
		return expectedItemNameList;
	}
	
	public List<String> expectedItemListZToA() {
		List<String> expectedItemNameList = getItemList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		return expectedItemNameList;
	}
	
	public List<String> expectedPriceListLowToHigh() {
		List<Double> expectedItemNameList = getItemPriceList().stream().map(Double::parseDouble).sorted().collect(Collectors.toList());
		return expectedItemNameList.stream().map(Functions.toStringFunction()).collect(Collectors.toList());
	}
	
	public List<String> expectedPriceListHighToLow() {
		List<Double> expectedItemNameList = getItemPriceList().stream().map(Double::parseDouble).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		return expectedItemNameList.stream().map(Functions.toStringFunction()).collect(Collectors.toList());
	}
	
	public boolean viewProductAddButton(String productName) {
		switch(productName) {
			case "Sauce Labs Backpack": {
				return addBackpackButton.isDisplayed();
			}
			case "Sauce Labs Bike Light": {
				return addBikeLightButton.isDisplayed();	
			}
			case "Sauce Labs Bolt T-Shirt": {
				return addShirtButton.isDisplayed();		
			}
			case "Sauce Labs Fleece Jacket": {
				return addFleeceJacketButton.isDisplayed();
			}
			case "Sauce Labs Onesie": {
				return addOnesieButton.isDisplayed();	
			}
			case "Test.allTheThings() T-Shirt (Red)": {
				return addAllTheThingsShirtButton.isDisplayed();			
			}
			default:
	            throw new IllegalArgumentException("Unknown product name: " + productName);
		}
	}
	
	public boolean viewProductRemoveButton(String productName) {
		switch(productName) {
			case "Sauce Labs Backpack": {
				return removeBackpackButton.isDisplayed();
			}
			case "Sauce Labs Bike Light": {
				return removeBikeLightButton.isDisplayed();	
			}
			case "Sauce Labs Bolt T-Shirt": {
				return removeShirtButton.isDisplayed();		
			}
			case "Sauce Labs Fleece Jacket": {
				return removeFleeceJacketButton.isDisplayed();
			}
			case "Sauce Labs Onesie": {
				return removeOnesieButton.isDisplayed();	
			}
			case "Test.allTheThings() T-Shirt (Red)": {
				return removeAllTheThingsShirtButton.isDisplayed();			
			}
			default:
	            throw new IllegalArgumentException("Unknown product name: " + productName);
		}
	}
	
	public void addAllProductsToCart() {
		List<String> productList = getItemListOriginal();
		
		for(String product: productList) {
			addProductToCart(product);
		}
	}
	
	
	public void viewAllProductsRemoveButtons() {
		List<String> productList = getItemListOriginal();
		
		for(String product: productList) {
			viewProductRemoveButton(product);
		}
	}
	
	
}
