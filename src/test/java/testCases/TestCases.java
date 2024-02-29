package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.BaseTest;
import pageObjectModels.BeCognizantPage;
import pageObjectModels.GSDPage;
import pageObjectModels.OneCognizantPage;
import utils.ExcelUtils;
import utils.ScreenShot;

public class TestCases extends BaseTest{
	String language;
	String mail;
	String name;
	public static String path;
	
	@Test(priority=1)
	void profileValidation() throws InterruptedException, IOException {
		BeCognizantPage bcp=new BeCognizantPage(driver);
		bcp.profileBtnClick();
		mail=bcp.usermail();
		name=bcp.username();
		path=ScreenShot.screenShot("profileValidation", driver);
		System.out.println("Employee Name: "+name);
		System.out.println("Employee Mail:"+mail);
		Assert.assertEquals("2303770@cognizant.com", bcp.usermail());
		System.out.println("UserDetails Verified\n");
		bcp.profileCloseBtnClick();
		
				
	}
	
	@Test(priority=2)
	void openOneCognizant() throws InterruptedException, IOException{
		BeCognizantPage bcp=new BeCognizantPage(driver);
		bcp.oneCognizantClick();
		String title="OneCognizant";
		System.out.println(driver.getTitle());
		System.out.println("OneCognizant Page Verified\n");
		Assert.assertEquals(title,driver.getTitle());
		path= ScreenShot.screenShot("openOneCognizant", driver);
	}
	
	@Test(priority = 3)
	void validateGSDpage() throws IOException {
		OneCognizantPage ocp=new OneCognizantPage(driver);
		ocp.searchGSD();
		ocp.openGSD();
		GSDPage gp=new GSDPage(driver);
		String GSDPageTitle=gp.gsdPageText();
		Assert.assertEquals("Welcome to the all-in-one Live Support!", GSDPageTitle);
		System.out.println(GSDPageTitle);
		System.out.println("GSD Page Verified\n");
		path=ScreenShot.screenShot("GSDpageValidation", driver);
	}
	
	@Test(priority = 4)
	void selectLanguage() throws IOException {
		GSDPage gp=new GSDPage(driver);
		language = gp.language();
		System.out.println("Language Selected :" + language);
		String expectlan = "English";
		Assert.assertEquals(language, expectlan);
		System.out.println("Language verified\n");
		path=ScreenShot.screenShot("languageValidation", driver);
	}
	
	@Test(priority=5)
	void selectCountryAndQueries() throws IOException {
		List<String> countries=new ArrayList<String>();
		List<List<String>> queries=new ArrayList<List<String>>();
		for(int i=0;i<2;i++) {
			
			GSDPage gp=new GSDPage(driver);
			gp.SelectCountryMenu();
			
			String randomCountry=gp.selectRandomCountry();
			System.out.println("\nSelected country is: "+randomCountry);
			countries.add(randomCountry);
			
			
			List<WebElement> elements=gp.queries();
			List<String> query=new ArrayList<String>();
			for(WebElement e:elements) {
				query.add(e.getText());
			}
			System.out.println(query);
			
			queries.add(query);
		}
		ExcelUtils.excel(name,mail,language,countries,queries);
		path= ScreenShot.screenShot("countryValidation", driver);
	}
	
}
