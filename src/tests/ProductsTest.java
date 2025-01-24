package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.ProductsPage;
import pages.SideBar;

public class ProductsTest extends BaseTest {

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
	public void WhenViewingProductsThenVerifyProductsSortedByAcendingAlphabet() {
		landingPage.logIn("standard_user", "secret_sauce");
		
		List<String> expectedProductList = productsPage.expectedItemListAToZ();
		List<String> actualProductList = productsPage.getItemList();
		
//		System.out.print(productsPage.expectedItemListAToZ() + "\n");
//		System.out.print(productsPage.getItemList() + "\n");
		
		Assert.assertEquals(expectedProductList, actualProductList);
	}
}
