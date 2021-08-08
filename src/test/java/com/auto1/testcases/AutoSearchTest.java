package com.auto1.testcases;



import java.util.Hashtable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.auto.base.TestBase;
import com.auto1.listeners.CustomListeners;
import com.auto1.utilities.TestUtil;
import com.aventstack.extentreports.ExtentTest;
import com.search.pages.SearchFunctionalities;




@Listeners(CustomListeners.class)
public class AutoSearchTest extends TestBase {	
	public ExtentTest test;
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	   public void TC1(Hashtable<String,String> data) throws Exception{	  		
		System.out.println("inside the method tc1");			
		SearchFunctionalities x = new SearchFunctionalities();
		Thread.sleep(3000);
		log.info("Inside Search Test");	
		Thread.sleep(3000);
		x.bookcar(data);
		log.info("Search functionality successfully completed");		
}
}
