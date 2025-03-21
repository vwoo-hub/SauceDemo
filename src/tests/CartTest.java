package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LandingPage;
import pages.ProductsPage;
import pages.SideBar;

public class CartTest extends BaseTest {

	private LandingPage landingPage;
	private ProductsPage productsPage;
	private SideBar sideBar;
	private CartPage cartPage;
	
	@BeforeMethod
	public void initPages() {
		landingPage = new LandingPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        sideBar = new SideBar(driver);
	}
	
	@Test(groups = {"Cart"})
	public void whenAddingProductsThenShowsProductsInCart() throws InterruptedException {
		landingPage.logIn("standard_user", "secret_sauce");

		productsPage.addProductToCart("Sauce Labs Backpack");
		productsPage.addProductToCart("Sauce Labs Bike Light");
		productsPage.tapShoppingCartButton();
		
		Assert.assertEquals(cartPage.getProductNameFromCart("Sauce Labs Backpack"), "Sauce Labs Backpack");
		Assert.assertEquals(cartPage.getProductNameFromCart("Sauce Labs Bike Light"), "Sauce Labs Bike Light");
	}
	
}
