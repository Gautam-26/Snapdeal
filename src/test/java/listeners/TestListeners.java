package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;

public class TestListeners implements ITestListener
{
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		htmlReporter = new ExtentHtmlReporter("./src/test/resources/reports/MyReport.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}


	@Override
	public void onTestStart(ITestResult result) 
	{
		test =	reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String MethodName = result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel(MethodName, ExtentColor.GREEN);
		test.pass(m);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{

		String MethodName = result.getMethod().getMethodName();
		Object currentClass = result.getInstance();
		WebDriver driver = ((BaseTest)currentClass).getDriver();

		CaptureScreenshot(driver,MethodName);

		Markup m = MarkupHelper.createLabel(MethodName, ExtentColor.RED);
		test.fail(m);

	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel(MethodName, ExtentColor.ORANGE);
		test.skip(m);

	}

	public void CaptureScreenshot(WebDriver driver,String ScreenshotName)
	{
		String datetime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./src/test/resources/screenshots/"+ScreenshotName+datetime+".png");
		try 
		{
			FileUtils.copyFile(src, des);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


}
