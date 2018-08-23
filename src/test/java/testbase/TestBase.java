package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.ExcelReader;

public class TestBase {
	public WebDriver driver;
	private static ThreadLocal<WebDriver> locadriver = new ThreadLocal<WebDriver>();
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\TestData.xlsx");
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static WebDriverWait wait;
	public static WebDriver getLocadriver() {
		return locadriver.get();
	}

	public static void setLocadriver(WebDriver driver) {
		locadriver.set(driver);
	}

	public void openBrowser(String browser) {
		if (browser.equals("chrome")) {
			System.out.println("Launching Browser " + browser);
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Soumyansh\\eclipse-workspace\\ThreadLocal_Parallelization\\src\\test\\resources\\Executables\\chromedriver.exe");
			driver = new ChromeDriver();
			setLocadriver(driver);
		}

	}

	public void quitBrowser() {
		getLocadriver().quit();
	}

}
