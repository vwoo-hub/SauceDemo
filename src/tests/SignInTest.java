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
}
