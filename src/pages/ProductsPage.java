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

public class ProductsPage extends BasePage {

	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "inventory_item_name")
	private List<WebElement> itemNameList;
	
	@FindBy(className = "inventory_item_price")
	private List<WebElement> itemPriceList;
	
	@FindBy(css = ".product_sort_container")
	private WebElement dropDownButton;
	
	public void tapDropDownButton() {
		dropDownButton.click();
	}
	
	public void selectDropdownOption(String visibleText) {
        Select dropdown = new Select(dropDownButton);
        dropdown.selectByVisibleText(visibleText); 
    }

	public List<String> getItemList() {
		return itemNameList.stream().map(name -> name.getText().toLowerCase()).collect(Collectors.toList());
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
}
