package com.search.pages;


import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.auto.base.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pageobjects.pages.SearchPageObjects;

public class SearchFunctionalities extends SearchPageObjects {
	ExtentTest testcase = TestBase.getreportinstance();

	WebDriver driver = TestBase.getWebDriverinstance();

	public void bookcar(Hashtable<String,String> data) throws InterruptedException, IOException, Exception {
		String brand=data.get("brand");
		String type=data.get("type");
		String mileage=data.get("mileage");
		testcase.log(Status.INFO, "Navigating to the search method");
		PageFactory.initElements(driver, SearchPageObjects.class);
		Thread.sleep(5000);
		try {
			closebutton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			BrandandModel.click();
			testcase.pass("Clicked car model dropdown");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testcase.fail("clicking brand and model is failed");
			e.printStackTrace();
		}
		int brandscount = totalbrands.size();
		System.out.println("Total brands" + brandscount);
		for (WebElement webelement : totalbrands) {
			if (webelement.getAttribute("value").equals(brand)) {
				webelement.click();
				testcase.pass("Clicked car model:"+brand);
				break;
			}
		}
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfAllElements(brandtypes));
		int typescount = brandtypes.size();
		System.out.println("Number of types" + typescount);
		for (WebElement webelement : brandtypes) {
			System.out.println("Brand name is:" + webelement.getAttribute("value"));
			if (webelement.getAttribute("value").equals(type)) {
				webelement.click();
				testcase.pass("Clicked make:"+type);
				break;
			}
		}
		try {
			BasicFilter.click();
			testcase.pass("Clicked basic dropdown");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select select = new Select(kilometerrange);
		select.selectByVisibleText(mileage);
		testcase.pass("selected max mileage:"+mileage);
		BasicFilter.click();
		Thread.sleep(10000);					
		Screen s= new Screen();
		Pattern downarrow=new Pattern(System.getProperty("user.dir")+"\\downarrow.png");
		Pattern lastpage=new Pattern(System.getProperty("user.dir")+"\\lastpage.png");		
		boolean lastPageReached=false;		
		HashSet<WebElement> finalcount= new HashSet<WebElement>();				
		System.out.println(searchResult.size());		
		finalcount.addAll(searchResult);		
		String initPos="0";		
		while(lastPageReached==false)
		{
			s.click(downarrow);
			PageFactory.initElements(driver, SearchPageObjects.class);
			System.out.println(searchResult.size());
			finalcount.addAll(searchResult);			
			for(WebElement e:searchResult)
			{
				System.out.println("the values displayed are:"+e.getText());
			}
			
			for(WebElement e:searchResult)
			{
				if( !e.getText().contains(brand) && !e.getText().contains(type))
				{
					
					Assert.assertTrue(false,"Wrong search results are present");
				}
			}
					
			System.out.println("***************************************************************************************************************************************************");
			
			try {
				s.click(lastpage);
				lastPageReached=true;
			} catch (FindFailed e) {
			}
		
		}		
		System.out.println("Final size:"+finalcount.size());		
		testcase.pass("Total number of search results:"+finalcount.size());
	}

}
