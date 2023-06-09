package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewPageOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties properties;
	public Page initBrowser(Properties properties) {
		String browserName = properties.getProperty("browser").trim();
		System.out.println("browser name is :" + browserName);
		
		 playwright = Playwright.create();
		 
		 switch (browserName.toLowerCase()) {
		case "chromium":
			  browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			  browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;	
		case "safari":
			  browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;	
		case "chrom":
			  browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;		

		default:
			   System.out.println("please pass the right browser name ...." );
			break;
		}
		 
		 browserContext = browser.newContext();
		 page =  browserContext.newPage();
		 page.navigate(properties.getProperty("url").trim());
		 return page;

	}
	
	public Properties init_prop() {
		try {
			FileInputStream ip = new FileInputStream("./src/test/java");
			properties = new Properties();
			properties.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

}
