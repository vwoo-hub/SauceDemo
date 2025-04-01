package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.LandingPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import pages.SideBar;
import pages.YourInformationPage;

public class CheckoutOverviewTest extends BaseTest {
	private LandingPage landingPage;
	private ProductsPage productsPage;
	private CartPage cartPage;
	private YourInformationPage yourInformationPage;
	private CheckoutOverviewPage checkoutOverviewPage;

	@BeforeMethod
	public void initPages() {
		landingPage = new LandingPage(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);
		yourInformationPage = new YourInformationPage(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
	}

	@Test(groups = { "Product" })
	public void whenProductsAddedToCartThenVerifyCheckoutInformation() throws InterruptedException {
		String expectedItemNameOne = "Sauce Labs Backpack";
		String expectedItemNameTwo = "Sauce Labs Fleece Jacket";
		String expectedItemNameThree = "Sauce Labs Bolt T-Shirt";

		landingPage.logIn("standard_user", "secret_sauce");

		productsPage.addProductToCart(expectedItemNameOne);
		productsPage.addProductToCart(expectedItemNameTwo);
		productsPage.addProductToCart(expectedItemNameThree);
		productsPage.tapShoppingCartButton();

		cartPage.tapCheckoutButton();
		
		yourInformationPage.typeFirstNameTextField("Chris");
		yourInformationPage.typeLastNameTextField("Wilson");
		yourInformationPage.typeZipTextField("95505");
		yourInformationPage.tapContinueButton();
		
		List<String> actualItemPriceList = checkoutOverviewPage.getItemPriceList();
		
		String subTotalPrice = String.valueOf(checkoutOverviewPage.calculateSubTotalPrice(actualItemPriceList));
		String taxPrice = String.valueOf(checkoutOverviewPage.calculateTaxPrice(actualItemPriceList));
		String totalPrice = String.valueOf(checkoutOverviewPage.calculateTotalPrice(actualItemPriceList));
		
		Assert.assertEquals(checkoutOverviewPage.getPriceValue("subTotal"), subTotalPrice);
		Assert.assertEquals(checkoutOverviewPage.getPriceValue("tax"), taxPrice);
		Assert.assertEquals(checkoutOverviewPage.getPriceValue("total"), totalPrice);
	}
}
