package pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage {
	
	private WebDriver driver;

	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "inventory_item_price")
	private List<WebElement> itemPriceList;
	
	@FindBy(css = ".summary_subtotal_label")
	private WebElement subTotalPrice;
	
	@FindBy(css = ".summary_tax_label")
	private WebElement taxPrice;
	
	@FindBy(css = ".summary_total_label")
	private WebElement totalPrice;
	
	
	public List<String> getItemPriceList() {
		return itemPriceList.stream().map(price -> price.getText().substring(1)).collect(Collectors.toList());
	}
	
	public float calculateSubTotalPrice(List<String> itemPriceList) {
		float totalCost = 0;
		
		for(String itemPrice: itemPriceList) {
			totalCost += Float.parseFloat(itemPrice);
		}
		return totalCost;
	}
	
	public float calculateTaxPrice(List<String> itemPriceList) {
		float tax = calculateSubTotalPrice(itemPriceList) * 0.08f;
		
		return (float) (Math.ceil(tax * 100) / 100);
	}
	
	public float calculateTotalPrice(List<String> itemPriceList) {
		return (float) calculateSubTotalPrice(itemPriceList) + calculateTaxPrice(itemPriceList);
	}
	
	public String getPriceValue(String price) {
		String priceText;
		
		switch(price) {
			case "subTotal": {
				priceText = subTotalPrice.getText();
				break;
			}
			case "tax": {
				priceText = taxPrice.getText();
				break;
			}
			case "total": {
				priceText = totalPrice.getText();
				break;
			}
			default:
	            throw new IllegalArgumentException("Unknown price value: " + price);
		}
		
		Pattern pattern = Pattern.compile("\\d+.\\d+");
		Matcher matcher = pattern.matcher(priceText);
		
		return matcher.find() ? matcher.group() : "";
	}
}
