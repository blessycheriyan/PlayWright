package Base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.page.HomePage;

public class BaseTest {
	PlaywrightFactory pf;
	Page page; 
   protected HomePage homePage; 
   protected Properties properties;
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		properties = pf.init_prop();
		page = pf.initBrowser(properties);
		homePage = new HomePage(page);
	}

	@AfterTest
	public void teardown() {
		page.context().browser().close();
	}
}
