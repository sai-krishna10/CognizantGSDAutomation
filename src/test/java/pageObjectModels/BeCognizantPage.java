package pageObjectModels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BeCognizantPage extends BasePage{
	public BeCognizantPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(id="O365_HeaderRightRegion")
	WebElement profileBtn;
	
	@FindBy(xpath="//*[@id='mectrl_main_trigger']")
	WebElement profileCloseBtn;
	
	@FindBy(id="mectrl_currentAccount_secondary")
	WebElement profileMail;
	
	@FindBy(id="mectrl_currentAccount_primary")
	WebElement profileName;
	
	@FindBy(xpath="//*[@id='5d7d4eec-cbe0-4c55-ae2e-f38d926d82a0']/div/div/div/p/span/strong")
	WebElement aroundCognizant;
	
	@FindBy(xpath="//div[@title='OneCognizant']")
	WebElement oneCognizant;
	
	//Actions
	
	public void profileBtnClick() {
		profileBtn.click();
	}
	
	public void profileCloseBtnClick() {
		profileCloseBtn.click();
	}
	
	public String usermail() {
		return profileMail.getText();
	}
	
	public String username() {
		return profileName.getText();
	}
	
	public void oneCognizantClick() {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()",aroundCognizant);
		oneCognizant.click();
		Set<String> set=new HashSet<String>();
		set=driver.getWindowHandles();
		List<String> list=new ArrayList<String>(set);
		driver.switchTo().window(list.get(1));
	}
}
