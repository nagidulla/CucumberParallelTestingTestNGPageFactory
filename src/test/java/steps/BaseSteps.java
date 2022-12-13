package steps;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pages.GooglePage;

public class BaseSteps {
	
	private WebDriver driver;
	public WebDriverWait wait;
	public GooglePage gPage;
	public static ThreadLocal<WebDriver> dr  = new ThreadLocal<WebDriver>();
	
	public void startPage() {
		gPage = PageFactory.initElements(BaseSteps.getDriver(), GooglePage.class);
		System.out.println("--------------------------------------");
	}
	
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	public static void setWebDriver(WebDriver driver) {
		dr.set(driver);
		
	}

	
	
	public void startWebDriver(String browser) throws MalformedURLException {
		System.out.println("Driver intializing...");
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		setWebDriver(driver);
		getDriver().manage().window().maximize();
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		
		System.out.println("Driver initialized");
	}
	
	public void navigate(String url) {
		getDriver().navigate().to(url);
	}
	
	public void stopWebDriver() {
		getDriver().quit();
	}
	
	
}
