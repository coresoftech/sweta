/* 
 * Project    : DealerPath
 * Script     : Alerts_POF
 * Author     : Neeraja Mantri
 * Date       : May.15.2018
 * Last Modified On:
 * Modified By :
 */

package com.deere.PageFactory;

import javax.xml.xpath.XPath;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.deere.Helpers.LogFactory;
import com.deere.Helpers.ReportFactory;
import com.deere.Helpers.ValidationFactory;

public class Alerts_POF {

	final WebDriver AlrtDriver;

	public Alerts_POF(WebDriver driver) {
		this.AlrtDriver = driver;

	}

	@FindBy(how = How.XPATH, using = "//div[@class='section warning']")
	static WebElement alertportlet;

	@FindBy(how = How.XPATH, using = "//div[@class='section warning']//div[@class='section-header']")
	static WebElement portletheader;

	/*
	 * @FindBy (how=How.XPATH, using
	 * ="//h3[@class='section-title'and contains(text(),' DealerPath Alerts')]")
	 * static WebElement alertheader;
	 */

	@FindBy(how = How.XPATH, using = "//span[@class='icon warning']")
	static WebElement warningimg;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='layoutContainers']/div/div[2]/div[3]/div[2]/section/div/div[2]")
	public static WebElement alertFramePath;
	
	

	/**
	 * @throws Throwable
	 */
	public static void isAlertPortletPresent() throws Throwable {

		String flag = "FAIL";
		String result = "Alerts are not displayed";
		try {
			if (ValidationFactory.isElementPresent(alertportlet)) {
				flag = "PASS";
				result = "Alerts are displayed";
			}
			ReportFactory.ReporterOutput("TC05_Homepage", "Verify presence of Alert portlet on Home Page", "NA","Alert should be present on homepage", result, flag);
			
			if (flag.equalsIgnoreCase("FAIL") )
			{ 	Assert.assertFalse(true);}

		} catch (Throwable e) {

			ReportFactory.ReporterOutput("TC05_Homepage", "Verify presence of Alert portlet on Home Page", "NA","Alert should be present on homepage", e.getMessage().toString(), flag);
		}

	}

	/**
	 * @param actualheadertxt
	 * @param TCID
	 * @param RootSiteArea 
	 * @param ContentType 
	 * @throws Throwable
	 */
	public static void getAlertPortletHeaderAndText(String ContentType, String actualheadertxt) throws Throwable {
		String TCID="Alert Portlet";
		
		String flag = "FAIL";
		String result = "Alert header text is not present";
		try {
			
			if(ContentType.contains("AT_Alert") )
				{			
					if (ValidationFactory.isElementPresent(portletheader)) {

						String stralertheadertxt = portletheader.getText();
						
					//if (stralertheadertxt.equals(actualheadertxt)) {
					flag = "PASS";
					LogFactory.info("Alert portlet contains header with text");
					result = "Alert header text is present :" + actualheadertxt;
				}

			}
			ReportFactory.ReporterOutput(TCID, "Verify alertheadertxt on homepage", "DealerPath Alerts",
					"Alert header text should be present on homepage", result, flag );
			
			if (flag.equalsIgnoreCase("FAIL") )
			{ 	
				Assert.assertFalse(true);
			}			
		}
		catch (Throwable e) {

			ReportFactory.ReporterOutput(TCID, "Verify alertheadertxt on homepage", "DealerPath Alerts",
					"Alert header text should be present on homepage", e.getMessage().toString(), flag );
		}

	}

	/**
	 * @param RootSiteArea 
	 * @param ContentType 
	 * @throws Throwable
	 */
	public static void checkForWarningSignPresentInAlertHeader(String ContentType) throws Throwable

	{
		String TCID="Alert Warning Sign";
		String flag = "FAIL";
		String result = "Alert warning sign icon is not displayed";
		try {
			if  (ContentType.contains("AT_Alert") )
				{	
					
					if (ValidationFactory.isElementPresent(warningimg)) {
				flag = "PASS";
				LogFactory.info("Alert warning sign icon is present");
				result = "Alert sign is displayed";

			}
			ReportFactory.ReporterOutput(TCID, "Verify alert warning sign icon on homepage", "warning sign",
					"Alert warning sign icon should be present on homepage", result, flag );
			
			if (flag.equalsIgnoreCase("FAIL") )
			{ 	Assert.assertFalse(true);}

				
			}
		}catch (Throwable e) {

			ReportFactory.ReporterOutput(TCID, "Verify alert warning sign icon on homepage", "warning sign",
					"Alert warning sign icon should be present on homepage", e.getMessage().toString(), flag );
		}
	}

	/**
	 * @param alertheadertxtprefrdlang
	 * @param TCID
	 * @param RootSiteArea 
	 * @param ContentType 
	 * @param TCID 
	 * @throws Throwable
	 */
	public static void getAlertHeaderTxtInPreferredLanguage(String ContentType,String alertheadertxtprefrdlang)throws Throwable {
		 String TCID="Alert HeaderTxt";
		String stralrtheadertxtonhomepage = null;
		String flag = "FAIL";
		String result = " Alert header Text is not displayed in the user preffered language";
		try {
				if  (ContentType.contains("AT_Alert"))
				{	
			if (ValidationFactory.isElementPresent(portletheader)) {

				LogFactory.info("Alerts portlet header is present ");
				
				stralrtheadertxtonhomepage = portletheader.getText();
				if (stralrtheadertxtonhomepage.equals(alertheadertxtprefrdlang)) {
					flag = "PASS";
					LogFactory.info("Alert is displayed in the user  preffered language with " + stralrtheadertxtonhomepage + " "
							+ "" + alertheadertxtprefrdlang);
					result = " Alert header text is displayed in the user preferred language";
				}
				ReportFactory.ReporterOutput(TCID, "Verify alert header text in the user preffered language",
						stralrtheadertxtonhomepage, "Alert header text should be displayed in the user preffered language",
						result, flag );
				
				if (flag.equalsIgnoreCase("FAIL") )
				{ 	Assert.assertFalse(true);}

				}

				}
			
		}catch (Throwable e) {

			ReportFactory.ReporterOutput(TCID, "Verify alert header text in the user preffered language",
					stralrtheadertxtonhomepage, "Alert header text should be displayed in preffered language",
					e.getMessage().toString(), flag );
		}

	}

}
