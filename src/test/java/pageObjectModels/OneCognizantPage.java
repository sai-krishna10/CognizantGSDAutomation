package pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OneCognizantPage extends BasePage{
	//constructor
		public OneCognizantPage(WebDriver driver) {
			super(driver);
		}
		
		//locators
		@FindBy(xpath="//input[@placeholder='Search this site...']")
		WebElement searchGSD;
		
		@FindBy(xpath="//*[@id=\"newSearchAppsLST\"]/div/div/div[2]")
		WebElement openGSD;
		
		//actions
		public void searchGSD() {
			searchGSD.sendKeys("GSD");
		}
		
		public void openGSD() {
			openGSD.click();
		}
}
