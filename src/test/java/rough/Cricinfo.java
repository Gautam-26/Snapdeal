package rough;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class Cricinfo extends BaseTest
{

	@Test
	public void tc_cricinfo()
	{
		driver.get("https://www.espncricinfo.com/series/19430/scorecard/1187685/new-zealand-vs-india-1st-test-icc-world-test-championship-2019-2021");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		String _batsmen = driver.findElement(By.xpath("//div[@id='gp-inning-00']//div[@class = 'wrap header']//div[@class = 'cell batsmen']")).getText();
		System.out.print(_batsmen+ "\t\t");

		List<WebElement> headers = driver.findElements(By.xpath("//div[@id='gp-inning-00']//div[@class = 'wrap header']//div[@class = 'cell runs']"));
		for(int i=0; i < headers.size(); i++)
		{
			System.out.print(headers.get(i).getText()+"\t");
		}
		System.out.println();
		List<WebElement> playersList = driver.findElements(By.xpath("//div[@id='gp-inning-00']//div[@class = 'wrap batsmen']//div[@class = 'cell batsmen']//a[@name='&lpos=cricket:game:scorecard:player']"));
		
		for(int i=0;i<playersList.size();i++)
		{
			String playername = playersList.get(i).getText();
			System.out.print(playername+"\t\t");
			
			List<WebElement> playersInfoList = driver.findElements(By.xpath("//a[contains(text(),'"+playername+"')]/parent::div/following-sibling::div[@class='cell runs']"));	
			for(int j=0; j < playersInfoList.size(); j++)
			{
				System.out.print(playersInfoList.get(j).getText()+"\t");
			}
			System.out.println();
		}
	}
}
