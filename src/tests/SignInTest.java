package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.ProductsPage;

public class SignInTest extends BaseTest {
	
	@Test(groups = {"SignIn"})
	public void WhenValidCredentialsThenSignInSuccessfully() throws InterruptedException {
		LandingPage landingPage = new LandingPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		
		landingPage.typeUserNameField("standard_user");
		landingPage.typePasswordField("secret_sauce");
		landingPage.tapLoginButton();
		
		Assert.assertEquals("Swag Labs", productsPage.getTitleHeaderText());
	}
	
	@Test(groups = {"SignIn"})
	public void WhenWrongPasswordThenDisplayErrorMessage() {
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.typeUserNameField("standard_user");
		landingPage.typePasswordField("no_sauce");
		landingPage.tapLoginButton();
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", landingPage.getErrorMessageText());
		//landingPage.tapErrorMessageButton();
	}
}
