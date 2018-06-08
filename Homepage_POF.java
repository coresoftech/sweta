/* 
 * Project    : DealerPath
 * Script     : Homepage_POF
 * Author     : Neeraja Mantri
 * Date       : May.15.2018
 * Last Modified On:
 * Modified By :
 */

package com.deere.PageFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.deere.Helpers.BaseClass;
import com.deere.Helpers.DateFactory;
import com.deere.Helpers.ExcelFactory;
import com.deere.Helpers.GenericFactory;
import com.deere.Helpers.LinkFactory;
import com.deere.Helpers.LogFactory;
import com.deere.Helpers.ReportFactory;
import com.deere.Helpers.ValidationFactory;
import com.deere.Helpers.WaitFactory;

/**
 * @author neeraja.mantri
 *
 */
public class Homepage_POF {

	static WebDriver HomDriver;
	static SoftAssert softAssert = new SoftAssert();

	public Homepage_POF(WebDriver driver) {
		this.HomDriver = driver;

	}

	@FindBy(how = How.XPATH, using = "//div[@class='user-info' ]")
	static WebElement userinfo;

	@FindBy(how = How.XPATH, using = "//h1[@class='app-title']")
	static WebElement titleofhomepage;

	@FindBy(how = How.ID, using = "leftNav")
	static WebElement leftWindow;

	@FindBy(how = How.XPATH, using = ".//*[@class='wpthemeFooter']")
	public static WebElement homepageFooterFramePath;

	@FindBy(how = How.XPATH, using = "//div[@id='js-segments']")
	static WebElement productsegmenticon;

	@FindBy(how = How.XPATH, using = ".//*[@id='main-header']/div[1]/div/h1")
	static WebElement homepagepath;
	
	/**
	 * @param title
	 * @param TCID
	 * @throws Throwable
	 */
	public static void checkUserLogIntoHomepage(String title, String TCID) throws Throwable {

		String strtitlepage = HomDriver.getTitle();

		WaitFactory.waitForPageLoaded();

		LogFactory.info(" Title " + strtitlepage + " is displayed on the homepage");

		String flag = "FAIL";
		String result = "Title is not displayed";

		try {
			if (ValidationFactory.isElementPresent(titleofhomepage)) {
				if (strtitlepage.equalsIgnoreCase(title)) {

					flag = "PASS";
					result = "Title is displayed :" + title;
				}

			}
			ReportFactory.ReporterOutput(TCID, "Verify the title is displayed on the homepage", title,
					"Title on homepage should be  " + strtitlepage, result, flag);

			if (flag.equalsIgnoreCase("FAIL")) {
				Assert.assertFalse(true);
			}

		} catch (Throwable e) {

			ReportFactory.ReporterOutput(TCID, "Verify the title is displayed on the homepage", title,
					"Verify the title is displayed on the homepage " + strtitlepage, e.getMessage().toString(), flag);
		}

	}

	/**
	 * @param welcomemsg
	 * @param TCID
	 * @throws Throwable
	 */
	public static void getWelcomeMessageOnHomepage(String welcomemsg, String TCID) throws Throwable {

		String strWelcomemsg = userinfo.getText();

		LogFactory.info(" Welcome username :" + strWelcomemsg);
		String flag = "FAIL";
		String result = "Welcome message is not displayed";

		try {
			if (ValidationFactory.isElementPresent(userinfo)) {

				if (strWelcomemsg.equals(welcomemsg)) {
					flag = "PASS";
					result = "Welcome message is displayed :" + welcomemsg;

				}
			}

			ReportFactory.ReporterOutput(TCID, "Verify welcome message on homepage", strWelcomemsg,
					"Welcome message on homepage should be  " + welcomemsg, result, flag);

			if (flag.equalsIgnoreCase("FAIL")) {
				Assert.assertFalse(true);
			}

		} catch (Exception e) {

			ReportFactory.ReporterOutput(TCID, "Verify welcome message on homepage", strWelcomemsg,
					"Welcome message on homepage should be  " + welcomemsg, e.getMessage().toString(), flag);
		}

	}

	// ***************************************************** E-O-M
	// *****************************************************************************

	// To verify homepage footer Links
	public static void verifyFooterLinksonHomepage(String header) throws Throwable {
		String TCID = "";
		String flag = "Fail";
		String result = "Announcement FooterLinks is not showing as per on the UI.";
		ArrayList<String> StrhomepageFooterList = new ArrayList<String>();

		try {

			List<WebElement> WeHomepageFooterList = GenericFactory.getLinksFromFrame(homepageFooterFramePath);
			// List<WebElement> WeHomepageFooterList =
			// BaseClass.wbDv.findElements(By.xpath("html/body/div[15]/footer/div/div/ul/li/a"));
			for (int i = 0; i < WeHomepageFooterList.size(); i++) {
				String hearlinktxtvalue = WeHomepageFooterList.get(i).getText().toString().trim();
				StrhomepageFooterList.add(hearlinktxtvalue);
			}

			System.out.println(StrhomepageFooterList);

			// To compare with testdata
			String expectedtestdata = header;
			String[] StrExpectedtestFooterdataList = expectedtestdata.split(",");

			for (int i = 0; i < StrhomepageFooterList.size(); i++) {
				String expectedvalue = StrExpectedtestFooterdataList[i];

				if (expectedvalue.contains("Switch Site")) {
					flag = "Pass";
					LogFactory.info(expectedvalue + " is present on Footer link");
				} else {
					if (StrhomepageFooterList.contains(expectedvalue)) {
						flag = "Pass";
						LogFactory.info(expectedvalue + " is present on Footer link");
					} else {
						flag = "Fail";
						LogFactory.info(expectedvalue + " is not present on Footer link");
					}
				}

				// To check system date and match the date with the 'Copyright ©
				// 2017 Deere & Company. All Rights Reserved' link

				// GenericFactory.isValidDateFormat(dateFormat, listOfDates)
				String copyrighttxt = BaseClass.wbDv
						.findElement(By.xpath("html/body/div[15]/footer/div/div[2]/ul/li[3]/a")).getText().toString()
						.trim();

				List<String> copyrightYr = GenericFactory.splitString(copyrighttxt, " ");
				String copyrightYrValue = copyrightYr.get(2);
				System.out.println(copyrightYrValue);

				// getting system DateTime
				Date date = new Date();
				String systemYr = DateFactory.captureYear(date);

				// getting UI 'copyright' link date
				if (copyrightYrValue.equals(systemYr)) {
					LogFactory.info("Copyright Date is correct as FY yr.");
				} else {
					LogFactory.info("Copyright Date is not correct as FY yr.");
				}

			}
		} catch (Exception e) {
			// LogFactory.error("e");
			// String er = e.getMessage().toString().trim();

			ReportFactory.ReporterOutput(TCID, "verify FooterLinks on Homepage", "NA",
					"Announcement FooterLinks is not showing as per on the UI.", result, flag);

		}
	}
	
	// ***************************************************** E-O-M *****************************************************************************
	public static void chkOrderOfProductSegment(String ContentType, String RootSiteArea, String DeptName, String Title) throws Throwable {
		
		String TCID = "Product Segments";
		String flag = "Fail";
		String result= "Product Segment are not in order ";
		WebElement element = null;
		int i=0;
		
		try{
			
		if (RootSiteArea.contains("Homepage") && (DeptName.equalsIgnoreCase(""))) 
		{
		//if ! (DeptName.isEmpty() || DeptName.equalsIgnoreCase("NA")) {

			if (ContentType.contains("AT_ProductType") ) {
			
				if (productsegmenticon.isEnabled()) 
				{
					productsegmenticon.click();
					System.out.println("clik ok element. ");
				}
				List<String> ActualDataFromSite = GenericFactory.getcheckBoxValues();
				System.out.println("ActualDataFromSite- " + ActualDataFromSite);

				//List<String> ExpectedDataFromExcel = GenericFactory.splitString(Title, ",");
				// Compare both string list

				//Compare with testdata
				//XSSFSheet expectedDataFromExcel = ExcelFactory.readExcel("", "");
				List<String> expectedDataFromExcel = GenericFactory.splitString(Title, ",");
				
				if (ActualDataFromSite.equals(expectedDataFromExcel)) {
					LogFactory.info("Prod type is same as expected. ");
				} 
				else 
				{
					LogFactory.info("Prod type is not same as expected. ");
				}
				
				//To clik on dealerpath
				homepagepath.click();
			
			} 
		}
			else if (DeptName.length() > 0) 
			{
				if (ContentType.contains("AT_ProductType"))
				
				//if (ContentType.contains("AT_ProductType") && (RootSiteArea.contains("Homepage")) && (Announcements_POF.announcementDeptName)))
				{
					List<String> deptnamefromexcel = GenericFactory.splitString(DeptName, ",");
					for (int j=0;j<deptnamefromexcel.size();j++)
					{
						if(GenericFactory.getDeptname(deptnamefromexcel.get(j))!=null)
						{
							WebElement dept = GenericFactory.getDeptname(deptnamefromexcel.get(j));
							dept.click();
					
					
					
						//compare active dept links with assigned dept links to dealer						
							flag = "Pass";
							LogFactory.info("dept name contains active link");
							dept.click();
							
							if (productsegmenticon.isEnabled())
							{
								productsegmenticon.click();
								System.out.println("clik on element");
							}
							
							List<String> ActualDataFromSite = GenericFactory.getcheckBoxValues();
							System.out.println("ActualDataFromSite- " +ActualDataFromSite);
							
							
							//Compare with testdata
							//XSSFSheet expectedDataFromExcel = ExcelFactory.readExcel("", "");
							
							List<String> expectedDataValue = GenericFactory.splitString(Title, ",");
							if (ActualDataFromSite.equals(expectedDataValue)) {
								
								LogFactory.info("Product segment is same as expected. ");
							} 
							else 
							{
								LogFactory.info("Product segment is not same as expected. ");
							}
							
						//To clik on dealerpath
							//BaseClass.wbDv.findElement(By.xpath(".//*[@id='main-header']/div[1]/div/h1")).click();
							homepagepath.click();
						}					
				  }				
			}
				else {
					
					LogFactory.info("content type is not AT_ProductType ");
					
				}
			}
		
	}catch(Exception e)
		{
		ReportFactory.ReporterOutput(TCID, "verify Product Segment on Homepage", "NA",
				"Product Segment is not showing as per on the UI.", result, flag);
	}
	}
	  
	

	// ***************************************************** E-O-M *****************************************************************************
	
public static void verifyOrderofUtilityLinks(String RootSiteArea,String ContentType,String DepartmentName , String expectedData) throws Throwable
{
 	String TCID= "UtilityLinks";
	String flag = "Fail";
	String result= "Utility Links are not in order ";
	try{
		
		WebElement element = null;

		if (RootSiteArea.contains("Homepage")) 
		{			
			if  (ContentType.contains("AT_UtilityLinks") ) 
			{	
				List<String> deptnamefromexcel = GenericFactory.splitString(DepartmentName, ",");
				for (int i=0;i<deptnamefromexcel.size();i++)
				{
					if(GenericFactory.getDeptname(deptnamefromexcel.get(i))!=null)
					{
						WebElement dept = GenericFactory.getDeptname(deptnamefromexcel.get(i));
						dept.click();
					
				
				
				
				
				element = ValidationFactory.getElementIfPresent(By.xpath(".//*[@class='primary-caret spr']"));
				System.out.println(">>>>>>>>>>>>");
				
				if (element.isEnabled()) 
				{
					element.click();
					System.out.println("clik ok element. " +result);
					
					//To retrive the list of utility link
					List<WebElement> utilityLinkLists = BaseClass.wbDv.findElements(By.xpath(".//*[@class='user-actions']/li/a"));
					
					//To store in all utilities link in arraylist
					ArrayList<String> actualUtilityLinkLists = new ArrayList<String>();					
					
					for(int j=0; j< utilityLinkLists.size()-1; j++)
					{
						String utilityLinkListsNames = utilityLinkLists.get(j).getText().toString().trim();
						actualUtilityLinkLists.add(utilityLinkListsNames);						
					}
					System.out.println("arryUtilityLinkLists- " +actualUtilityLinkLists);
					
					//Compare with testdata
					//XSSFSheet expectedDataFromExcel = ExcelFactory.readExcel("", "");
					
					List<String> expectedDataValue = GenericFactory.splitString(expectedData, ",");
					if (actualUtilityLinkLists.equals(expectedDataValue)) {
						
						LogFactory.info("Utility Links is same as expected. ");
					} 
					else 
					{
						LogFactory.info("Utility Links is not same as expected. ");
					}
					
					
				}
				else{
					
					LogFactory.info("Element is not enabled");
					
					}
				
				homepagepath.click();
				}
			  }
			}
		
		
		else {
			
			LogFactory.info("ContentType  is not Utility links ");
			
		}
	}
else {
			
			LogFactory.info("Rootsite area is not homepage ");
			
		}
	
    }catch(Exception e)
	{
		//System.out.println(e);
		// LogFactory.error("e");
		// String er = e.getMessage().toString().trim();

					ReportFactory.ReporterOutput(TCID, "verify FooterLinks on Homepage", "NA",
							"Announcement FooterLinks is not showing as per on the UI.", result, flag);
		}
}




}
	// ***************************************************** E-O-M *****************************************************************************
		