package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class HomePage extends BasePage
{
	private String url = "http://www.snapdeal.com";
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Mobile & Tablets')]")
	private WebElement MobilesandTablets;
	
	@FindBy(how = How.XPATH, using = "//span[@class = 'linkTest'][contains(text(),'Smartphones')]")
	private WebElement Smartphones;
	
	Actions actions;

	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void open()
	{
		driver.get(url);
	}	
	
	public void HoverOnMobilesAndTablets()
	{
		actions = new Actions(driver);
		actions.moveToElement(MobilesandTablets).build().perform();
		
	}
	
	public MobilesTabletsPage clickOnSmartPhones()
	{
		Smartphones.click();
		return new MobilesTabletsPage(driver);
	}
}
