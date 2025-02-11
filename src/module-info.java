/**
 * 
 */
/**
 * 
 */
module SauceDemo {
	requires org.seleniumhq.selenium.chrome_driver;
	requires org.seleniumhq.selenium.api;
	requires dev.failsafe.core;
	requires org.testng;
	exports tests to org.testng;
	requires org.seleniumhq.selenium.support;
	opens pages to org.seleniumhq.selenium.support;
	opens utils to org.testng;
	requires io.github.bonigarcia.webdrivermanager;
	requires org.seleniumhq.selenium.firefox_driver;
	requires com.google.common;
	requires extentreports;
	requires org.apache.commons.io;
}