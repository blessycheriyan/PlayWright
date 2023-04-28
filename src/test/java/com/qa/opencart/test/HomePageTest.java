package com.qa.opencart.test;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.page.HomePage;

import Base.BaseTest;

public class HomePageTest extends BaseTest{
	PlaywrightFactory pf;
	Page page;
	HomePage homePage;
	Properties properties;
	
	
	@Test
	public void homepagetitleTest() {
		String actualtitle = homePage.gethomepagetitle();
		Assert.assertEquals(actualtitle, "Your Store");
		
	}
	
	@Test
	public void homepageurlTest() {
		String actualurl = homePage.gethomepageurl();
		Assert.assertEquals(actualurl, properties.getProperty("url"));
		
	}
	@DataProvider
	public Object[][] getProductData(){
		return new Object[][] {
			{"Macbook Phone"},
			{"IMac"},
			{"Samsung"}
		};
	}
	
	
	@Test(dataProvider = "getProductData")
	public void searchTest(String ProductName) {
		String actualheader =  homePage.doSearch(ProductName);
		Assert.assertEquals(actualheader, "Search - "+ProductName);
		
	}
	
}
