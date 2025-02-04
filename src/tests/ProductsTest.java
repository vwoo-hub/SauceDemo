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
	
	@Test(groups = {"Product"})
	public void WhenViewingProductsThenVerifyProductsSortedByAcendingAlphabet() {
		landingPage.logIn("standard_user", "secret_sauce");
		
		List<String> expectedProductList = productsPage.expectedItemListAToZ();
		List<String> actualProductList = productsPage.getItemList();
		
		Assert.assertEquals(expectedProductList, actualProductList);
	}
	
	@Test(groups = {"Product"})
	public void WhenViewingProductsThenVerifyProductsSortedByDescendingAlphabet() {
		landingPage.logIn("standard_user", "secret_sauce");
		
		productsPage.selectDropdownOption("Name (Z to A)");
		
		List<String> expectedProductList = productsPage.expectedItemListZToA();
		List<String> actualProductList = productsPage.getItemList();
		
		Assert.assertEquals(expectedProductList, actualProductList);
	}
	
	@Test(groups = {"Product"})
	public void WhenViewingProductsThenVerifyProductsSortedByLowToHighPrice() {
		landingPage.logIn("standard_user", "secret_sauce");
		
		productsPage.selectDropdownOption("Price (low to high)");
		
		List<String> expectedProductList = productsPage.expectedPriceListLowToHigh();
		List<String> actualItemPriceList = productsPage.getItemPriceList();
		
		
		Assert.assertEquals(expectedProductList, actualItemPriceList);
	}
	
	@Test(groups = {"Product"})
	public void WhenViewingProductsThenVerifyProductsSortedByHighToLowPrice() {
		landingPage.logIn("standard_user", "secret_sauce");
		
		productsPage.selectDropdownOption("Price (high to low)");
		
		List<String> expectedProductList = productsPage.expectedPriceListHighToLow();
		List<String> actualItemPriceList = productsPage.getItemPriceList();
		
		
		Assert.assertEquals(expectedProductList, actualItemPriceList);
	}
}
