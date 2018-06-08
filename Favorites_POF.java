package com.deere.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.deere.Helpers.BaseClass;
import com.deere.Helpers.LogFactory;
import com.deere.Helpers.ReportFactory;
import com.deere.Helpers.ValidationFactory;

public class Favorites_POF {
	final WebDriver FavouritesDriver;
	static SoftAssert softAssert =new SoftAssert();

	public Favorites_POF(WebDriver driver) {

		this.FavouritesDriver = driver;
		

	}

	@FindBy(how = How.XPATH, using = ".//*[@id='layoutContainers']/div/div[2]/div[3]/div[4]/section/div/div[2]/div[1]/h3")
	static WebElement header_title_Favourites;

	@FindBy(how = How.ID, using = "favorites-filter")
	static WebElement searchbox_Favourites;

	@FindBy(how = How.XPATH, using = ".//*[@id='favorites-target']/div/div")
	static WebElement nofavadded_Favourites;

	@FindBy(how = How.XPATH, using = ".//*[@id='favorites-target']/div/p[2]/span")
	static WebElement icon_Favourites;

	@FindBy(how = How.XPATH, using = ".//*[@id='favorites-target']/div/p[2]")
	static WebElement message_Favourites;

	@FindBy(how = How.LINK_TEXT, using = "Actions")
	static WebElement action_Favourites;

/*	@FindBy(how = How.LINK_TEXT, using = "Add Folder")
	static WebElement addfolder_Favourites;*/

	@FindBy(how = How.XPATH, using = ".//*[@id='favorites-target']/div/div/div/div[1]/div/div[1]")
	static WebElement foldername_Favourites;
	

	
	@FindBy(how = How.XPATH, using = "//a[@id='js-fav-actions-trigger']")
	static WebElement addfolder_Favourites;

	
	/**
	*@Functionality To verify the presence of Favorites header on homepage.
	 * @throws Throwable
	 */
	public static void verifyFavoritesHeaderPresent(String TCID,String strexpectedheadermsg ) throws Throwable 
	{ 
		String flag="Fail";
		try
		{
		String stractualheadermsg = Favorites_POF.header_title_Favourites.getText().toString();
	//	System.out.println(stractualheadermsg);
		
		String result="Favorites portlet with header text is not displayed.";

		if (ValidationFactory.isElementPresent(header_title_Favourites)) {

			if (stractualheadermsg.equals(strexpectedheadermsg)) {
				
				
				 flag="Pass";
				 result="Favorites portlet with header text is displayed.";
				 LogFactory.info("Favorites portlet with header is displayed.");
				
			} 
			
		
		}
		ReportFactory.ReporterOutput(TCID, "Verify Favorites portlet with header text is displayed on homepage.",
				strexpectedheadermsg, "Favorites portlet header should be " + strexpectedheadermsg ,
				result, flag);
		
		if (flag.equalsIgnoreCase("FAIL") )
		{ 	Assert.assertFalse(true);}
		}
		
		catch(Exception e)
		{
			
			ReportFactory.ReporterOutput("Error_Favorites portlet","Favorites portlet with header", "Favorites portlet with header" ,"NA",e.getMessage().toString(),flag);		
		}
	}

	
	/**
	 * @Functionality To verify No Favorites added yet message on homepage.
	 * @throws Throwable exception.
	 */
	public static void verifyWhenNoFavouritePresent(String TCID,String strexpectednofavmsg) throws Throwable 
	{
		String flag="Fail";
		try
		{
		String stractualnofavmsg = Favorites_POF.nofavadded_Favourites.getText().toString();
	//	System.out.println(stractualnofavmsg);
	
		String result= "Message 'No Favourites added yet' is not displayed.";
		if (ValidationFactory.isElementPresent(nofavadded_Favourites)) {

			if (stractualnofavmsg.equals(strexpectednofavmsg)) {
				 flag="Pass";
				 result= "Message 'No Favourites added yet' is displayed.";
				 LogFactory.info("Verify 'No Favourites added yet.' message is displayed.");
				
			} 
			

		}
		
	
		ReportFactory.ReporterOutput(TCID, "Verify 'No Favourites added yet' message on home page when No Favourites added.",
				strexpectednofavmsg, "Message 'No Favourites added yet' should be displayed " + strexpectednofavmsg, result, flag);
		
		
		if (flag.equalsIgnoreCase("FAIL") )
		{ 	softAssert.assertFalse(true);}
		
		
		}
		catch(Exception e)
		{
			
			ReportFactory.ReporterOutput("Error_No_Favourite_added.","Verify 'No Favourites added yet' message on home page when No Favourites added.", 
					"Message 'No Favourites added yet' should be displayed " ,"NA",e.getMessage().toString(),flag);		
		}
	}

	
	/**
	 *@Functionality : To verify favourite icon with message on homepage.
	 * @throws Throwable
	 */
	public static void verifyFavouriteIconWhenNoFavouriteAdded(String TCID,String strexpectedicon ) throws Throwable 
	{
		
		
		String flag="Fail";
	try
	{
		
		
		String result="Star icon with Message is not displayed.";
		
			if (ValidationFactory.isElementPresent(message_Favourites))
			{
			String stractualicon = Favorites_POF.message_Favourites.getText().toString();
		//	System.out.println(stractualicon);
			

			if (stractualicon.equals(strexpectedicon))
			{

				LogFactory.info("Verify Star icon with Message is displayed.");
				flag="Pass";
				result="Star icon with Message is displayed.";
			}	
			}

	
			ReportFactory.ReporterOutput(TCID, "Verify Favorites Icon with message in Favourites portlet when no favourites",
					strexpectedicon, "Star icon with Message should be  " + strexpectedicon,result,flag);
			
			if (flag.equalsIgnoreCase("FAIL") )
			{ 	Assert.assertFalse(true);}
			
	}
	catch(Exception e)
	{
		
		ReportFactory.ReporterOutput("Error_Favorites","Favorites Icon with Message.", "Favorites Icon with Message" ,"NA",e.getMessage().toString(),flag);		
	}
	
	}
}