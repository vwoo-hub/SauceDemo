package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import pages.SideBar;

public class ProductDetailsTest extends BaseTest {

	private LandingPage landingPage;
	private ProductsPage productsPage;
	private ProductDetailsPage productDetailsPage;
	private SideBar sideBar;

	@BeforeMethod
	public void initPages() {
		landingPage = new LandingPage(driver);
		productsPage = new ProductsPage(driver);
		sideBar = new SideBar(driver);
		productDetailsPage = new ProductDetailsPage(driver);
	}

	@Test(groups = { "Product" })
	public void whenTapOnProductThenShowsProductDetails() throws InterruptedException {
		String expectedItemName = "Sauce Labs Backpack";
		String expectedItemPrice = "$29.99";

		landingPage.logIn("standard_user", "secret_sauce");

		productsPage.tapProductName(expectedItemName);

		Assert.assertEquals(productDetailsPage.getItemName(), expectedItemName, "Item name does not match!");
		Assert.assertEquals(productDetailsPage.getItemPrice(), expectedItemPrice, "Item price does not match!");
	}
}
