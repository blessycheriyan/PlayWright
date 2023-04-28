package com.qa.opencart.page;

import com.microsoft.playwright.Page;

public class HomePage {
	private Page page;
	// String Locator -OR
	
	private String search = "input[name='search']";
	private String searchicons = "div#search button";
	private String searchPageheader = "div#content h1";
	// page constructor
	public HomePage (Page page) {
		this.page =page;
	}
	// page actions /page 
	
	public String  gethomepagetitle() {
		String title =  page.title();
		System.out.println("Title "+ title);
		return title;
		
	}
	public String  gethomepageurl() {
		String url =  page.url();
		System.out.println("Url "+ url);
		return url;
		
	}
	
	public String doSearch(String ProductName) {
		
		page.fill(search, ProductName);
		page.click(searchicons);
		String searchheader = page.textContent(searchPageheader);
		System.out.println("Serach header is:"+ searchheader);
		return searchheader;
		
		
	}
	
}
