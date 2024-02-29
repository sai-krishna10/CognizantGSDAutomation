package baseTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	public WebDriver driver;
	@BeforeSuite
	public void openApp() throws IOException {
		System.out.println("1.ChromeDriver 2.EdgeDriver");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		sc.close();
		System.out.println("Browser Loading..........\n");
		if(a==1) {
			driver=new ChromeDriver();
		}
		else if(a==2) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("Select Valid Browser");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://be.cognizant.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
