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
import pages.YourInformationPage;

public class YourInformationTest extends BaseTest {

	private LandingPage landingPage;
	private ProductsPage productsPage;
	private SideBar sideBar;
	private CartPage cartPage;
	private ProductDetailsPage productDetailsPage;
	private YourInformationPage yourInformationPage;
	
	@BeforeMethod
	public void initPages() {
		landingPage = new LandingPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        sideBar = new SideBar(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        yourInformationPage = new YourInformationPage(driver);
	}
	
	@Test(groups = {"Your Information"})
	public void whenCheckingOutWithoutFirstNameThenShowsErrorMessage() throws InterruptedException {
		String expectedItem = "Sauce Labs Fleece Jacket";
		
		landingPage.logIn("standard_user", "secret_sauce");

		productsPage.addProductToCart(expectedItem);
		productsPage.tapShoppingCartButton();
		
		cartPage.tapCheckoutButton();
		
		yourInformationPage.tapContinueButton();
		
		Assert.assertEquals(yourInformationPage.getErrorLabel(), "Error: First Name is required");	
	}
	
	
	@Test(groups = {"Your Information"})
	public void whenCheckingOutWithoutLastNameThenShowsErrorMessage() throws InterruptedException {
		String expectedItem = "Test.allTheThings() T-Shirt (Red)";	
		
		landingPage.logIn("standard_user", "secret_sauce");

		productsPage.addProductToCart(expectedItem);
		productsPage.tapShoppingCartButton();
		
		cartPage.tapCheckoutButton();
		
		yourInformationPage.typeFirstNameTextField("Chris");
		yourInformationPage.tapContinueButton();
		
		Assert.assertEquals(yourInformationPage.getErrorLabel(), "Error: Last Name is required");	
	}
	
	
	@Test(groups = {"Your Information"})
	public void whenCheckingOutWithoutZipCodeThenShowsErrorMessage() throws InterruptedException {
		String expectedItem = "Sauce Labs Bolt T-Shirt";
		
		landingPage.logIn("standard_user", "secret_sauce");

		productsPage.addProductToCart(expectedItem);
		productsPage.tapShoppingCartButton();
		
		cartPage.tapCheckoutButton();
		
		yourInformationPage.typeFirstNameTextField("Chris");
		yourInformationPage.typeLastNameTextField("Wilson");
		yourInformationPage.tapContinueButton();
		
		Assert.assertEquals(yourInformationPage.getErrorLabel(), "Error: Postal Code is required");	
	}
}
