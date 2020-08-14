package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest 
{
	protected WebDriver driver;
	protected BrowserFactory factory;

	@Parameters("browser")
	@BeforeTest(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser)
	{
		factory = new BrowserFactory(browser);
		driver = factory.createDriver();
		driver.manage().window().maximize();
	}

	
	public WebDriver getDriver()
	{
		return this.driver;
	}
	@AfterTest(alwaysRun = true)
	public void tearDown()
	{
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver != null)
		{
			driver.quit();
		}

	}

}
