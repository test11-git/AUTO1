package com.pageobjects.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPageObjects {
		
	@FindBy(how=How.ID,using="carMakeFilter")	
	public static WebElement BrandandModel;
	
	@FindBy(how=How.ID,using="basicFilter")	
	public static WebElement BasicFilter;
	
	@FindBy(how=How.ID,using="rangeEnd")	
	public static WebElement kilometerrange;
		
	@FindBy(how=How.XPATH, using="//*[@class='list___2iBtR multiColList___RwpIk']/li/input")
	public static List<WebElement> totalbrands;	
	
	@FindBy(how=How.XPATH, using="//*[@class='list___1Alc-']/li/input")
	public static List<WebElement> brandtypes;
	
	@FindBy(how=How.XPATH, using="//*[@class='title___uRijL adTitle___1MVoL")
	public static List<WebElement> CarTitles;
	
	@FindBy(how=How.XPATH, using="//*[@class='closeBtn____-0Mx plain___3Dl0A']")	
	public static WebElement closebutton;
	
	@FindBy(how=How.XPATH, using="//h2[@data-qa-selector='title']")
	public static List<WebElement> Finaloutput;
	
	@FindBy(how=How.XPATH, using="//button[@class='button___2v8xP show___1pg74 default___1FRAY']")	
	public static WebElement scroll;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'FAQ')]")	
	public static WebElement faq;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'titleWrapper')]/h2")	
	public static List<WebElement> searchResult;
	
	
	
	

}
