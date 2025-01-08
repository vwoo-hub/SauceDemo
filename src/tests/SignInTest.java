package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.ProductsPage;

public class SignInTest extends BaseTest {
	
	private LandingPage landingPage;
	private ProductsPage productsPage;
	
	@BeforeMethod
	public void initPages() {
		landingPage = new LandingPage(driver);
        productsPage = new ProductsPage(driver);
	}
	
	@Test(groups = {"SignIn"})
	public void WhenValidCredentialsThenSignInSuccessfully() throws InterruptedException {
		landingPage.typeUserNameField("standard_user");
		landingPage.typePasswordField("secret_sauce");
		landingPage.tapLoginButton();
		
		Assert.assertEquals("Swag Labs", productsPage.getTitleHeaderText());
	}
	
	@Test(groups = {"SignIn"})
	public void WhenWrongPasswordThenDisplayErrorMessage() {
		landingPage.typeUserNameField("standard_user");
		landingPage.typePasswordField("no_sauce");
		landingPage.tapLoginButton();
		
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", landingPage.getErrorMessageText());
		landingPage.tapErrorMessageButton();
	}
	
	@Test(groups = {"SignIn"})
	public void WhenMissingPasswordThenDisplayErrorMessage() {
		landingPage.typeUserNameField("standard_user");
		landingPage.tapLoginButton();
		
		Assert.assertEquals("Epic sadface: Password is required", landingPage.getErrorMessageText());
	}
}
