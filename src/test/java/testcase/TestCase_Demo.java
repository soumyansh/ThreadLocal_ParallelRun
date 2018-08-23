package testcase;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


import testbase.TestBase;
import utilities.TestUtil;

public class TestCase_Demo extends TestBase {

	@Test(dataProviderClass=TestUtil.class, dataProvider = "dp")
	public void parallel_demo(Hashtable<String,String>data) throws InterruptedException {
		openBrowser(data.get("browserName"));
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Hashcode of webDriver instance = " + getLocadriver().hashCode());
		getLocadriver().get("https://www.google.com");
		getLocadriver().findElement(By.name("q")).sendKeys(data.get("SearchString"));
		Thread.sleep(7000);
		getLocadriver().manage().window().maximize();
		quitBrowser();
	}

	
}
