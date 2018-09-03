package testcase;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import testbase.TestBase;
import utilities.TestUtil;

public class TestCase_Demo extends TestBase {

	@Test(dataProviderClass=TestUtil.class, dataProvider = "dp")
	public void parallel_demo(Hashtable<String,String>data) throws InterruptedException, IOException {
		logger=extent.startTest("Starting Test with Thread:"+Thread.currentThread().getId());
		setLocallogger(logger);
		openBrowser(data.get("browserName"));
		getLocadriver().manage().window().maximize();
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Hashcode of webDriver instance = " + getLocadriver().hashCode());
		getLocadriver().get("https://www.google.com");
		getLocadriver().findElement(By.name("q")).sendKeys(data.get("SearchString"));
		TestUtil.CaptureScreenshot();
		Thread.sleep(7000);
		
		quitBrowser();
		getLocallogger().log(LogStatus.PASS, "Passed successfully with keys:"+data.get("SearchString"));
		extent.endTest(getLocallogger());
		extent.flush();
	}

	
}
