package pages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public List<String> getItemList() {
		// List<String> productNameList = itemNameList.stream().map(name -> name.getText().toLowerCase()).collect(Collectors.toList());
		// System.out.println(Arrays.toString(productNameList.toArray()));
		return itemNameList.stream().map(name -> name.getText().toLowerCase()).collect(Collectors.toList());
	}
	
	public List<String> getItemPriceList() {
		return itemPriceList.stream().map(price -> price.getText().substring(1)).collect(Collectors.toList());
	}
	
	public List<String> expectedItemListAToZ() {
		List<String> expectedItemNameList = getItemList().stream().sorted().collect(Collectors.toList());
		return expectedItemNameList;
	}
	
	public List<String> expectedPriceListLowToHigh() {
		List<Double> expectedItemNameList = getItemPriceList().stream().map(Double::parseDouble).sorted().collect(Collectors.toList());
		return expectedItemNameList.stream().map(Functions.toStringFunction()).collect(Collectors.toList());
	}
}
