package testCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.MobilesTabletsPage;

public class tc_LaunchBrowser extends BaseTest
{
	HomePage objHome;
	MobilesTabletsPage objeMobilesTables;

	@Test(priority = 1)
	public void GoToHomePage()
	{
		objHome = new HomePage(driver);
		objHome.open();

	}

	@Test(priority = 2)
	public void SelectMobilesAndSort()
	{
		objHome.HoverOnMobilesAndTablets();
		objeMobilesTables = objHome.clickOnSmartPhones();
		sleepTime(5000);
		objeMobilesTables.ClickOnSortBy();
		objeMobilesTables.SelectHighToLow();
	}
	@Test(priority = 3)
	public void GetPricesAndSort()
	{
		sleepTime(5000);
		List<WebElement> list =objeMobilesTables.getFirstRowPrices();
		System.out.println(list.size());


		List<String> prices = new ArrayList<>();
		for(WebElement e : list) { prices.add(e.getText()); }

		List<String> sortedPrices = new ArrayList<>(prices);
		Collections.sort(sortedPrices); Collections.reverse(sortedPrices);

		for(int i=0; i<sortedPrices.size();i++) 
		{ 
			System.out.println(prices.get(i)+" : "+sortedPrices.get(i)); 
			Assert.assertEquals(prices.get(i),sortedPrices.get(i)); 
		}

	}

	public void sleepTime(long millis)
	{
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
