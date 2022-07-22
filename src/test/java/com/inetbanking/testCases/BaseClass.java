package com.inetbanking.testCases;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.inetbanking.utilities.ReadConfig;
import com.mongodb.MapReduceCommand.OutputType;

import net.bytebuddy.utility.RandomString;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass {

	ReadConfig readconfig= new ReadConfig();

	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		if (br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());	
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());	
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());	
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		driver.get(baseURL);
	}




	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(5000);

		driver.quit();
	}
	public  void captureScreen(WebDriver driver,String tname) throws IOException {


		TakesScreenshot ts=(TakesScreenshot)driver;

		//Capturing the screenshot
		File source = ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}
	public String randomestring() {
		
		String generatedstring=RandomString.make(8);
		return generatedstring;
	}
	public String randomenuber() {
		
		String generatednumber=RandomString.make(10);
		return generatednumber;
	}

}
