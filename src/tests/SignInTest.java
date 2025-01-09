package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.ProductsPage;
import pages.SideBar;

public class SignInTest extends BaseTest {
	
	private LandingPage landingPage;
	private ProductsPage productsPage;
	private SideBar sideBar;
	
	@BeforeMethod
	public void initPages() {
		landingPage = new LandingPage(driver);
        productsPage = new ProductsPage(driver);
        sideBar = new SideBar(driver);
	}
	
	@Test(groups = {"SignIn"})
	public void WhenValidCredentialsThenLogInSuccessfully() throws InterruptedException {
		landingPage.typeUserNameField("standard_user");
		landingPage.typePasswordField("secret_sauce");
		landingPage.tapLoginButton();
		
		Assert.assertEquals(productsPage.getTitleHeaderText(), "Swag Labs");
	}
	
	@Test(groups = {"SignIn"})
	public void WhenWrongPasswordThenDisplayErrorMessage() {
		landingPage.typeUserNameField("standard_user");
		landingPage.typePasswordField("no_sauce");
		landingPage.tapLoginButton();
		
		Assert.assertEquals(landingPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");
	}
	
	@Test(groups = {"SignIn"})
	public void WhenEmptyPasswordThenDisplayErrorMessage() {
		landingPage.typeUserNameField("standard_user");
		landingPage.tapLoginButton();
		
		Assert.assertEquals(landingPage.getErrorMessageText(), "Epic sadface: Password is required");
	}
	
	@Test(groups = {"SignIn"})
	public void WhenEmptyUserNameThenDisplayErrorMessage() {
		landingPage.typePasswordField("secret_sauce");
		landingPage.tapLoginButton();
		
		Assert.assertEquals(landingPage.getErrorMessageText(), "Epic sadface: Username is required");
	}
	
	@Test(groups = {"SignIn"})
	public void WhenLogInWithLockedOutUserThenDisplayErrorMessage() {
		landingPage.typeUserNameField("locked_out_user");
		landingPage.typePasswordField("secret_sauce");
		landingPage.tapLoginButton();
		
		Assert.assertEquals(landingPage.getErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
	}
	
	@Test(groups = {"SignIn"})
	public void WhenLoggedInThenLogOutSuccessfully() {
		landingPage.typeUserNameField("standard_user");
		landingPage.typePasswordField("secret_sauce");
		landingPage.tapLoginButton();
		
		productsPage.tapHamburgerButton();
		
		sideBar.tapLogOutButton();
		
		Assert.assertEquals(landingPage.getLogInButtonText(), "Login");
		
	}
}
