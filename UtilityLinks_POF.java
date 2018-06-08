package com.deere.PageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.deere.Helpers.GenericFactory;
import com.deere.Helpers.ReportFactory;

/* 
 * Project    : DealerPath
 * Script     : UtilityLink_POF 
 * Author     : Shrey choudhary
 * Date       : May.15.2018
 * Last Modified On: May.15.2018
 * Modified By : Shrey choudhary
 */
public class UtilityLinks_POF {
	final WebDriver locDriver;

	public UtilityLinks_POF(WebDriver driver) {

		this.locDriver = driver;

	}

	@FindBy(how = How.ID, using = "js-user-info")
	static WebElement clickUtilityLinks;

	@FindBy(how = How.ID, using = "js-user-info-pop")
	static WebElement allUtilityLinks;

	@FindBy(how = How.XPATH, using = "//div[@id='js-user-info-pop']/div[2]/button")
	static WebElement utilityLinkButton;

	/**
	 * This method verify utility link button name
	 * @author shrey.choudhary
	 * @param testData
	 * @param TCID
	 * @throws Throwable
	 */
	public static void compareUtilityLinksWithTestData(String testData, String TCID) throws Throwable {
		String flag = "Fail";
		try {

			clickUtilityLinks.click();
			List<WebElement> ExpectedUtilityElements = GenericFactory.getLinksFromFrame(allUtilityLinks);
			List<String> ExpectedUtilityLinks = new ArrayList<String>();
			for (int i = 0; i < ExpectedUtilityElements.size(); i++) {
				String temp = ExpectedUtilityElements.get(i).getText();
				ExpectedUtilityLinks.add(temp);
			}
			List<String> ExpectedData = GenericFactory.splitString(testData, ",");
			if (ExpectedUtilityLinks.equals(ExpectedData)) {
				flag = "Pass";
			}
			
			
			ReportFactory.ReporterOutput(TCID, "Verify utility links and their order on the homepage", "NA",
					"Verify the order of links on utility links on the home page" + ExpectedData.toString(),
					"Order of utility links should be same as" + ExpectedUtilityLinks.toString(), flag);
			
			if (flag.equalsIgnoreCase("FAIL") )
			{ 	Assert.assertFalse(true);}
			
		} catch (Exception e) {

			ReportFactory.ReporterOutput(TCID, "Verify utility links and their order on the homepage", "Verify links on the utility menu on homepage", "NA",
					e.getMessage().toString(), flag);
		}

	}

	/**
	 * This method verify utility link button name
	 * @author shrey.choudhary
	 * @param testData
	 * @param TCID
	 * @throws Throwable
	 */
	public static void compareUtilityButtonWithTestData(String testData, String TCID) throws Throwable {
		String flag = "Fail";
		try {
			String UtilityButton = utilityLinkButton.getText();
			String ExpectedButtonName = testData;
			if (UtilityButton.equals(ExpectedButtonName)) {
				flag = "Pass";
			}
			ReportFactory.ReporterOutput(TCID, "Verify the Signout/EndImpersonate button on the Utility Links Menu on Home Page", "NA", ExpectedButtonName.toString(),
					UtilityButton.toString(), flag);
			
			if (flag.equalsIgnoreCase("FAIL") )
			{ 	Assert.assertFalse(true);}
			
		} catch (Exception e) {

			ReportFactory.ReporterOutput(TCID, "Verify Signout/EndImpersonate button on utility link menu", "Verify Utility Links Menu button name", "NA",
					e.getMessage().toString(), flag);
		}
	}
}
