package com.inetbanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	
	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("Accesss URL");
		
		LoginPage lP = new LoginPage(driver);//create object to call loginpage method
		lP.setUserName(username);
		logger.info("Entered Username");
		
		lP.setPassword(password);
		logger.info("Entered Password");
		
		lP.clickSubmit();
		logger.info("user clicked submit button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Succesfull login user");
		}	
		else {
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Failed login user");
		}
	}
		
		
		
		
		
	
}
