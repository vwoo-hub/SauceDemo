package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LandingPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import pages.SideBar;

public class CartTest extends BaseTest {

	private LandingPage landingPage;
	private ProductsPage productsPage;
	private SideBar sideBar;
	private CartPage cartPage;
	private ProductDetailsPage productDetailsPage;
	
	@BeforeMethod
	public void initPages() {
		landingPage = new LandingPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        sideBar = new SideBar(driver);
        productDetailsPage = new ProductDetailsPage(driver);
	}
	
	@Test(groups = {"Cart"})
	public void whenAddingProductsThenShowsProductsInCart() throws InterruptedException {
		String expectedItemNameOne = "Sauce Labs Backpack";
		String expectedItemNameTwo = "Sauce Labs Bike Light";
		
		landingPage.logIn("standard_user", "secret_sauce");

		productsPage.addProductToCart(expectedItemNameOne);
		productsPage.addProductToCart(expectedItemNameTwo);
		productsPage.tapShoppingCartButton();
		
		Assert.assertEquals(cartPage.getProductNameFromCart("Sauce Labs Backpack"), expectedItemNameOne);
		Assert.assertEquals(cartPage.getProductNameFromCart("Sauce Labs Bike Light"), expectedItemNameTwo);
	}
	
	@Test(groups = {"Cart"})
	public void whenRemoveProductsFromCartThenShowsEmptyCart() {
		String expectedItemNameOne = "Sauce Labs Backpack";
		String expectedItemNameTwo = "Sauce Labs Bike Light";
		
		landingPage.logIn("standard_user", "secret_sauce");
		
		productsPage.addProductToCart(expectedItemNameOne);
		productsPage.addProductToCart(expectedItemNameTwo);
		productsPage.tapShoppingCartButton();
		
		cartPage.removeProductFromCart(expectedItemNameOne);
		cartPage.removeProductFromCart(expectedItemNameTwo);
		cartPage.tapContinueShoppingButton();
		
		Assert.assertTrue(productsPage.viewProductAddButton(expectedItemNameOne));
		Assert.assertTrue(productsPage.viewProductAddButton(expectedItemNameTwo));
	}
	
	@Test(groups = {"Cart"})
	public void whenCheckingProductsFromCartThenShowsProductDetails() throws InterruptedException {
		String expectedItemName = "Sauce Labs Onesie";
		String expectedItemPrice = "$7.99";
		
		landingPage.logIn("standard_user", "secret_sauce");

		productsPage.addProductToCart(expectedItemName);
		productsPage.tapShoppingCartButton();
		
		cartPage.tapProductName(expectedItemName);
		
		Assert.assertEquals(productDetailsPage.getItemName(), expectedItemName);
		Assert.assertEquals(productDetailsPage.getItemPrice(), expectedItemPrice);
	}
}
