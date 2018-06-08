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
import com.deere.Helpers.ValidationFactory;
/* 
 * Project    : DealerPath
 * Script     : PortalLeftNavigation_POF 
 * Author     : Shrey choudhary
 * Date       : May.15.2018
 * Last Modified On: May.15.2018
 * Modified By : Shrey choudhary
 */
public class PortalLeftNavigation_POF {
	final WebDriver locDriver;

	public PortalLeftNavigation_POF(WebDriver driver) {

		this.locDriver = driver;

	}

	@FindBy(how = How.ID, using = "leftNav")
	static WebElement wbelLeftWindowFrame;

	@FindBy(how = How.XPATH, using = ".//*[@id='leftNav']/li/a[@class='active']")
	public static List<WebElement> allActiveLinks;

	@FindBy(how = How.XPATH, using = ".//*[@id='leftNav']/li/a[@class='inactive']")
	public static List<WebElement> allInActiveLinks;
	
	/**
     * This method verifies Left navigation window link names are in correct order
     * @author shrey.choudhary
     * @createdAt 15-05-2018
     * @param testData
     * @param TCID
     * @return
     * @throws Throwable
     * @modifiedAt 21-05-2018
     */
     public static void compareNavigationLinksWithTestData(String testData, String TCID) throws Throwable {
            String flag = "Fail";
            try {
                   if(ValidationFactory.isElementPresent(wbelLeftWindowFrame)) {
                   List<String> ExpectedData = GenericFactory.splitString(testData, ",");
                   List<String> actualData = new ArrayList<String>();
                   for (int i = 0; i < allActiveLinks.size(); i++) {
                         String temp = allActiveLinks.get(i).getText();
                         actualData.add(temp);
                   }
                   if (ExpectedData.equals(actualData)) {
                         flag = "Pass";
                   }
                   ReportFactory.ReporterOutput(TCID, "Verify Portal Left Navigation Links name ", "NA ",
                                "Verify the order of links name " + ExpectedData.toString(),
                                "Links order names should be same" + actualData.toString(), flag);
            }else{
                   ReportFactory.ReporterOutput(TCID, "Verify Portal Left Navigation Links name",
                                "Verify Portal Left Navigation Links name", "NA", "Portal Left Navigation window is not present", flag);
                   if (flag.equalsIgnoreCase("FAIL") )
                     {  Assert.assertFalse(true);}
                   }
                   }
                   catch (Exception e) {

                   ReportFactory.ReporterOutput(TCID, "Verify Portal Left Navigation Links name",
                                "Verify Portal Left Navigation Links name", "NA", e.getMessage().toString(), flag);
            }
     }

}
