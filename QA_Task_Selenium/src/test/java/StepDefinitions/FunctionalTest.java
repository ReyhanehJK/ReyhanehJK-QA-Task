package StepDefinitions;


import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FunctionalTest {


	WebDriver driver = null;
	String BaseURL = "https://react-shopping-cart-67954.firebaseapp.com/";
	//PageFactoryModel	PageFactoryModel_POM;

	@BeforeTest
	public void browserSetup() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);

		//setProperty for Chrome-Windows
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");

		//setProperty for Firefox-Windows
		//System.setProperty("webdriver.firefox.driver", projectPath+"/src/test/resources/Drivers/geckodrive_win64r.exe");

		//setProperty for Chrome-MAC
		//System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver_mac64");

		//setProperty for Firefox-MAC
		//System.setProperty("webdriver.firefox.driver", projectPath+"/src/test/resources/Drivers/geckodriver-v0.30.0-macos");


		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}



	@Test
	public void the_browser_launched_and_opened() throws IOException, InterruptedException  {
		System.out.println("* The Browser Launched and Opened & all the Test Steps is Passed *");

		//Product(s) found Title
		String expectedTitle="16 Product(s) found.";
		String	actualTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/div[1]/small/span")).getText();
		Assert.assertEquals(expectedTitle,actualTitle,"xxxxxxx- Failed: The Tittle not found -xxxxxxx");
		System.out.println("Passed..."+actualTitle);

		//XS button
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/label/span")).click();
		System.out.println("* Display the  XS  Sizes Product(s) *");


		//Add to cart
		String	ProductName = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/div[2]/p")).getText();
		System.out.println("XS Size-Name = "+ProductName);
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/div[2]/div[4]")).click();

		//Price_of_added_product
		String	Price_of_added_product = driver.findElement(By.xpath("//p[contains(text(),'10.90')]")).getText();
		System.out.println("Price for adding the 1 Quantity  is  $10.90 "+Price_of_added_product);

		// + button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[4]/div/button[2]")).click();


		//Assert for the Prices 
		String expectedPrice="$ 21.80";
		String	actualPrice = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/p")).getText();
		Assert.assertEquals(expectedPrice,actualPrice,"xxxxxxx- Failed: The Tittle not found -xxxxxxx");
		System.out.println("Passed...Actual Price is  "+actualPrice+"for adding 2  Quantity");


		//Close
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).click();


		//Uncheck the XS button
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/div[1]/label/span")).click();
		System.out.println("* Display the  All  the Product(s) *");
		Thread.sleep(5000);


		//sort Product(s) low to high
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/div[1]/div/select")).click();	
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/div[1]/div/select/option[2]")).click();
		System.out.println("* Displaythe Product(s) sorted low to high*");
		Thread.sleep(5000);


		// capture screenshot and store the image
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(s.getImage(),"PNG",new File(System.getProperty("user.dir")+"/ScreenShotOfResult/LowToHigh.png"));


		//html report
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/report/Html_QA_Report.Html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("FunctionalTest");
		ExtentTest logger =	extent.createTest("FunctionalTest");
		logger.log(Status.INFO, "QA Task");
		logger.log(Status.PASS, "All Tests Passed");

		//screen shot of failed tests

		//sample failed senario and screenshot
		ExtentTest logger2 =extent.createTest("Logoff Test");
		logger2.log(Status.FAIL, "Title");
		logger2.fail("faild because of some issues" , MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		logger2.addScreenCaptureFromPath(System.getProperty("user.dir")+"/report/logo.jpg");
		extent.flush();

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
