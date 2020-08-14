package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class MobilesTabletsPage extends BasePage
{
	@FindBy(how = How.XPATH, using = "//div[@class = 'sort-drop clearfix']")
	private WebElement SortBy;
	
	@FindBy(how = How.XPATH, using = "//li[@data-sorttype = 'phtl123']")
	private WebElement PriceHighToLow;
	
	@FindBy(how = How.XPATH, using = "//section[@data-dppos='1']/descendant::span[@class = 'lfloat product-price']")
	private List<WebElement> FirstRow;
	
	public MobilesTabletsPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnSortBy()
	{
		SortBy.click();
	}
	
	public void SelectHighToLow()
	{
		PriceHighToLow.click();
	}
	
	public List<WebElement> getFirstRowPrices()
	{
		return FirstRow;
		
	}

}
