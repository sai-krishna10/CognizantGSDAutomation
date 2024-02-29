package pageObjectModels;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GSDPage extends BasePage{
	//constructor
		public GSDPage(WebDriver driver) {
			super(driver);
		}
		
		//locators
		@FindBy(xpath="//*[@id='ui-view']/div/div[3]/p[1]")
		WebElement GSDPage;
		
		@FindBy(xpath = "(//span[@class='optionLangSelected'])[1]")
		WebElement language;
		
		@FindBy(xpath="(//div [@class='nav-item dropdown languageOptions '])[2]")
		WebElement countryMenu;
		
		@FindBy(className = "tiles-inner-wrapper")
		List<WebElement> allQueries;
		
		
		//actions
		public String gsdPageText() {
			driver.switchTo().frame("appFrame");
			return GSDPage.getText();
		}
		
		public String language() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return language.getText();
		}
		
		public void SelectCountryMenu() {
			countryMenu.click();
		}
		
		public String selectRandomCountry() {
			Random rand = new Random();
			int rand_int1 = rand.nextInt(55)+1;
			WebElement country= driver.findElement(By.xpath("/html/body/nav[1]/div/form/div[2]/ul/li["+rand_int1+"]/a"));
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			String countryText=country.getText();
			jse.executeScript("arguments[0].click();", country);
			return countryText;
		}
		
		public List<WebElement> queries(){
			return allQueries;
		}
		
		
		
}
