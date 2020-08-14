package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{
	private String browser;
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public BrowserFactory(String _browser)
	{
		this.browser = _browser.toLowerCase();

	}

	public WebDriver createDriver()
	{
		System.out.println("Creating Driver : "+browser);

		switch(browser)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/executables/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/executables/geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/executables/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}
		
		return driver.get();
	}

}
