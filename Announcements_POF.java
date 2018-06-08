//Create separate class under page factory with name announcement_Factory and pase it u can run this method any where by classname.methodname

	package com.deere.PageFactory;

	import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.deere.Helpers.BaseClass;
import com.deere.Helpers.DateFactory;
import com.deere.Helpers.ExcelFactory;
import com.deere.Helpers.GenericFactory;
import com.deere.Helpers.LogFactory;
import com.deere.Helpers.ReportFactory;
import com.deere.Helpers.ValidationFactory;

	public class Announcements_POF {

		final WebDriver AnncmntDriver;

		public Announcements_POF(WebDriver driver) {

			this.AnncmntDriver = driver;

		}

		@FindBy(how = How.XPATH, using = ".//*[@class='section-title announcement']")
		static WebElement headerTitleAnnouncement;

		@FindBy(how = How.XPATH, using = ".//*[@class='wide-list hide-overflow is-expanded']")
		static WebElement bodyAnnouncement;

		@FindBy(how = How.XPATH, using = ".//*[@class='wide-list hide-overflow is-expanded']/div")
		static List<WebElement> announcementBodyList;

		@FindBy(how = How.XPATH, using = ".//div/div/div/div/section/div/div/div/h3")
		static List<WebElement> HeaderList;

		@FindBy(how = How.XPATH, using = ".//*[@class='wide-list hide-overflow is-expanded']/div/div[1]")
		static List<WebElement> announcementTitleBodyList;

		@FindBy(how = How.XPATH, using = ".//*[@id='layoutContainers']/div/div[2]/div[3]/div[3]/section/div/div[2]/div")
		static List<WebElement> announcementTableElements;

		@FindBy(how = How.XPATH, using = ".//div[@class='section']//div[@class='list-item-body']/span")
		static List<WebElement> announcementTableTitle;

		@FindBy(how = How.XPATH, using = ".//*[@class='list-item-info parse-department']")
		static List<WebElement> announcementDeptName;

		@FindBy(how = How.XPATH, using = ".//*[@class='leftNav']/li/a")
		static List<WebElement> announcementLeftNavigationDeptName;
		
		@FindBy(how = How.XPATH, using = ".//*[@id='layoutContainers']/div/div[2]/div[3]/div[3]/section/div/div[2]")
		public static WebElement announcementFramePath;
		
		@FindBy(how = How.XPATH, using = ".//div[@class='section warning']//div[@class='section-header']")
		public static WebElement alertHeaderTitle;
		
		@FindBy(how = How.XPATH, using = ".//div[@class='section warning']//div[@class='section-header']")
		public static WebElement header_title_Favourites;
	
		@FindBy(how = How.XPATH, using = ".//*[@class='list-item-title']")
		public static WebElement announcementTitleContents;
		
		
		
		

		// *********************************************** XPATHS ********************************************************************************

		// To verify announcement table present or not
		public static boolean verifyAnnouncementTableOnHomePage() throws Throwable {
			try {
				List<WebElement> announcementTable_obj = announcementTableElements;

				if (announcementTable_obj.size() > 0) {

					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				// LogFactory.error("e");
				return false;
			}

		}

		// ****************************************************** E-O-M **********************************************************************************
		//
		public static boolean verifyAnnouncementTableBodyIsprsentOnHomePage() throws Throwable {
			try {
				if (announcementTableElements.size() > 0) {

					if (ValidationFactory.isElementPresent(bodyAnnouncement)) {
						return true;

					} else {

						return false;
					}
				} else {

					return false;
				}

			}

			catch (Exception e) {
				// LogFactory.error("e");
				return false;
			}
		}

		// ********************************************************** E- O - M ****************************************************************

		// To verify announcement header is present or not
		public static boolean verifyAnnouncementTableHeaderIsprsentOnHomePage() throws Throwable {
			try {
				if (announcementTableElements.size() > 0) {

					if ((ValidationFactory.isElementPresent(headerTitleAnnouncement))) {

						return true;

					} else {
						return false;

					}
					
				} else {

					return false;
				}

			}

			catch (Exception e) {
				// LogFactory.error("e");
				return false;
			}
		}

		// ****************************************************** E-O-M **********************************************************************************

		/**
		 * @param TCID
		 * @param ContentType 
		 * @throws Throwable
		 */
		// To verify announcement Table is present or not
		public static void verifyAnnouncementTableOnHomePage(String ContentType) throws Throwable {
			String TCID = "Announcement Table";
			String flag = "Fail";
			String result = "Announcement is not displaying.";

			try {
				if  (ContentType.contains("AT_Announcement") )
				{	
				List<WebElement> announcementTable_obj = announcementTableElements;

				if (announcementTable_obj.size() > 0) {
					flag = "Pass";
					result = "Announcement is displaying.";

					LogFactory.info("Announcement is present");

				}

				ReportFactory.ReporterOutput(TCID, "Verify Announcement Present On Homepage", "NA",
						"Announcement should displayed.", result, flag);

			}
			}catch (Exception e) {
				// LogFactory.error("e");
				String er = e.getMessage().toString();

				ReportFactory.ReporterOutput(TCID, "Verify Announcement Content", "NA", "Announcement should displayed.",
						result, er.substring(0, 25));

			}
		}

		// ********************************************************** E- O - M ****************************************************************

		// To verify announcement body is present or not
		/**
		 * @param TCID
		 * @param ContentType 
		 * @throws Throwable
		 */
		public static void verifyAnnouncementContentIsPrsent(String ContentType) throws Throwable {
			String TCID= "Announcement Content";
			String flag = "Fail";
			String result = "Announcement is not present";

			try {
				if  (ContentType.contains("AT_Announcement") )
				{
				List<WebElement> ann_table_obj = announcementTableElements;

				if (ann_table_obj.size() > 0) {
					// LogFactory.info("Announcement is present");
					if (Announcements_POF.verifyAnnouncementTableBodyIsprsentOnHomePage()) {
						flag = "Pass";
						result = "Announcement is present";
						LogFactory.info("Announcement is present");
					}

					if (Announcements_POF.verifyAnnouncementTableHeaderIsprsentOnHomePage()) {
						flag = "Pass";
						result = "Announcement Content is displaying";

						LogFactory.info("Announcement header is present");

					}
				}

				ReportFactory.ReporterOutput(TCID, "Verify Announcement Content", "NA",
						"Announcement Content should display.", result, flag);
			}
			}catch (Exception e) {
				String er = e.getMessage().toString();

				ReportFactory.ReporterOutput(TCID, "Verify Announcement Content", "NA",
						"Announcement Content should dispaly", result, er.substring(0, 25));
			}
		}

		// **************************************************** E-O-M ****************************************************************************

		// To verify announcement header text in preferred language

		/**
		 * @param expectedHeaderTxt
		 * @param ContentType 
		 * @param TCID
		 * @throws Throwable
		 */
		public static void verifyAnnouncementHeaderTextPrefferedLang(String ContentType, String expectedHeaderTxt)
				throws Throwable {

			String TCID = "Announcement Header Text PrefferedLang";
			String actualheadertext = null;
			String flag = "Fail";
			String result = "Announcement header is not showing as per the user preferred language.";

			try {
				if  (ContentType.contains("AT_Announcement") )
				{
				if (announcementTableElements.size() > 0) {

					LogFactory.info("Getting Announcement Header Text in preffered Language.");

					if (ValidationFactory.isElementPresent(headerTitleAnnouncement)) {

						String txtheadertxt = headerTitleAnnouncement.getText().toString().trim();
						// LogFactory.info(txtheadertxt);
						String[] headertxt = txtheadertxt.split(Pattern.quote("("));

						String actualHeaderTxt = headertxt[0].trim();
						// String expectedHeaderTxt
						// BaseClass.getExcelData_By_TestCase_ID().get("TC12_Homepage");
						if (actualHeaderTxt.length() > 0) {

							if (actualHeaderTxt.equals(expectedHeaderTxt)) {
								flag = "Pass";
								result = "Announcement header is showing as per the user preferred language.";

								LogFactory.info("Announcement header is showing as per the user preferred language."
										+ "Actual Value-" + actualHeaderTxt + ";" + "Expected Value-" + expectedHeaderTxt);
							}
						}
					}
				}
				ReportFactory.ReporterOutput(TCID, "Verify_announcement_header_Text_preffered_lng", expectedHeaderTxt,
						"Announcement header should show as per the user preferred language.", result, flag);

			}
			}catch (Exception e) {
				// LogFactory.error("e");
				String er = e.getMessage().toString().trim();

				ReportFactory.ReporterOutput(TCID, "Verify_announcement_Content", "NA",
						"Announcement Content should dispaly", result, er.substring(0, 25));
			}
		}

		// ****************************************************** E-O-M ******************************************************************************

		public static void verifyOrderOnHomepage() {
			
			boolean dAlertsFlag = false;
			boolean dAnnouncementsFlag = false;
			boolean dFavoritesFlag = false;
			int dAlertsIndex = 0;
			int dAnnouncementsIndex = 0;
			int dFavoritesIndex = 0;

			String announcementHeaderTxt = "";
			if(headerTitleAnnouncement.isDisplayed())
			{	announcementHeaderTxt = headerTitleAnnouncement.getText().toString().trim();
							
			}
			
			String alertHeaderTxt= "";
			if(alertHeaderTitle.isDisplayed())
			{	
				alertHeaderTxt = alertHeaderTitle.getText().toString().trim();
				
			
			}
			
			String favouritesHeaderTxt= "";
			if(header_title_Favourites.isDisplayed())
			{
				favouritesHeaderTxt = header_title_Favourites.getText().toString().trim();			
			}
			
			
			int count = HeaderList.size();

			LogFactory.info("Total Portlet present on page  " + count);

			for (int i = 0; i < count; i++) {

				String headertext = HeaderList.get(i).getText().toString().trim();

				if (headertext.contains(alertHeaderTxt)) {
					LogFactory.info("DealerPath Alerts is present : " + headertext);
					dAlertsFlag = true;
					dAlertsIndex = i;

				}

				else if (headertext.contains(announcementHeaderTxt)) {
					LogFactory.info("Announcements  is present :" + headertext);
					dAnnouncementsFlag = true;
					dAnnouncementsIndex = i;

				} else if (headertext.contains(favouritesHeaderTxt)) {
					LogFactory.info("Favorites  is present :  " + headertext);
					dFavoritesFlag = true;
					dFavoritesIndex = i;
				}
			}

			if ((dAlertsFlag == true) && (dAnnouncementsFlag = true) && (dFavoritesFlag == true)) {
				if ((dFavoritesIndex > dAnnouncementsIndex) && (dAnnouncementsIndex > dAlertsIndex)) {
					
					LogFactory.info("Portlet is displayin Correct sequence Alert, Announcements and Favorites below each other  ");
				}
			}

			else if ((dAlertsFlag == true) && (dAnnouncementsFlag = true) && (dFavoritesFlag == false)) {

				if ((dAnnouncementsIndex > dAlertsIndex)) {
					LogFactory.info("Annocumnet is displayed below the Alert ");
				}
			}

			else if ((dAlertsFlag == false) && (dAnnouncementsFlag = true) && (dFavoritesFlag == true)) {

				if ((dFavoritesIndex > dAnnouncementsIndex)) {
					LogFactory.info("Favorites is displayed below the Annocumnet ");
				}
			}

			else if ((dAlertsFlag == true) && (dAnnouncementsFlag = false) && (dFavoritesFlag == true)) {

				if ((dFavoritesIndex > dAlertsIndex)) {
					LogFactory.info("Favorites is displayed below the alert ");
				}
			}

			else {
				LogFactory.info("Single portlet is displaying ");

			}
		}

		// ****************************************************** E-O-M ******************************************************************************

		//verify Announcement in detail
		public static void verifyAnnouncementInDetailOnHomepage() throws Throwable {
			
			String TCID = "TC14_Announcement";
			String flag = "Pass";
			String result = "Announcement is displaying in Detail on Homepage";
			
			try {
				// List<WebElement> listItemTitleValues_obj = new ArrayList<>();

				// To get all title of Announcement
				List<WebElement> listItemTitleDealerHomePage = announcementTableTitle;
				List<WebElement> listItemInfoDepartment = announcementDeptName;

				for (int i = 0; i <listItemTitleDealerHomePage.size()-1; i++) {
					String titleValueDealerHomePage = listItemTitleDealerHomePage.get(i).getText().toString().trim();
					//System.out.println("Title of Announcement DealerHomePage is- " + titleValueDealerHomePage);
					String txtDatevalue  = GenericFactory.splitString(titleValueDealerHomePage, ":").get(0);
					//String[] txtDatevalue = titleValueDealerHomePage.split(":");
					System.out.println(txtDatevalue);
					
					//to get expected date format from excel
					XSSFSheet excelDateFormat = ExcelFactory.readExcel("TestData", "Admin");
					System.out.println(excelDateFormat);
					
					LogFactory.info("Excel date Format" +excelDateFormat);
					
					String dateValue1 = txtDatevalue;
					XSSFSheet dateValue2 = excelDateFormat;
					SimpleDateFormat dateFormat_obj = new SimpleDateFormat(dateValue2.toString());
					try
					{
						flag= "Pass";
					Date date = dateFormat_obj.parse(dateValue1);
				    System.out.println(dateFormat_obj.format(date));
				    System.out.println("Parse successful. s1 matches with s2");
					}
				    catch(ParseException e)
				    {
				    	flag= "Fail";
				    	System.out.println("Parse failed. s1 differs by format.");
				    
				    }
								
					
					// To get Department name
					String announcementDeptName = listItemInfoDepartment.get(i).getText().toString().trim();
					//System.out.println("Dept name is- " + announcementDeptName);
					LogFactory.info("Navigating to department Page- " +announcementDeptName);

					// To get all dept list
					List<WebElement> deptListNames = announcementLeftNavigationDeptName;
					for (int k = 0; k < deptListNames.size(); k++) {
						String deptName = deptListNames.get(k).getText().toString().trim();
						if (deptName.equals(announcementDeptName)) {
							System.out.println(deptName + " = equals to = " + announcementDeptName);
							deptListNames.get(k).click();
							Thread.sleep(2000);
							
							//Retrive and Compare
							List<WebElement> listItemTitleDeptPage = announcementTableTitle;
							
							//To get Department page title
							for (int j = 0; j < listItemTitleDeptPage.size(); j++) {
								String titleValueDeptPage = listItemTitleDeptPage.get(j).getText().toString().trim();
								System.out.println("Title of Announcement Department Page is- " + titleValueDeptPage);
							
							//to validate on desired dept
							if(titleValueDealerHomePage.equals(titleValueDeptPage))
							{
								flag = "Pass";
								
								//System.out.println("** Homepage Announcement DeptPage Title is same as showing on DelerPath Homepage. **");
								LogFactory.info(titleValueDealerHomePage + 
										" Homepage Announcement Deptartment Page Title is same as showing on DelerPath Homepage. " + titleValueDeptPage);
								
								ReportFactory.ReporterOutput(TCID, "Verify Announcement In Detail Homepage", titleValueDealerHomePage,
										"Announcement is displaying in Detail on Homepage", result, flag);							
							}
							
							else{
									//System.out.println("Clicking on desired Dept ie. " + i);
									continue;
								}				
							}
							
							//to go back again to Announcement page
							//BaseClass.wbDv.navigate().back();
							BaseClass.wbDv.findElement(By.xpath(".//*[@class='app-title']")).click();
							//System.out.println("Navigating to back");
							
							LogFactory.info("Navigating back to the DealerPath Homepage");
							
							ReportFactory.ReporterOutput(TCID, "Verify the Announcement In Detail on Homepage", "NA",
									"Announcement should show in Detail on Homepage", result, flag);
							
							//Thread.sleep(2000);
							
						//System.out.println("clik on dept. " + deptName);
					}
				}
				
			} 
		}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
// ****************************************************** E-O-M ******************************************************************************
	
	//verify Date Format	
		public static void verifyDateFormat(String TCID, String header, String dateFormat) throws Throwable
		 {
			//String TCID = "TC14_Announcement";
			String flag = "Fail";
			String result = "Announcement date is not showing as per the UI Format.";
			
			try
			{		  
				List<String> dateList = GenericFactory.getListOfDatesByHeaderName(header);
				LogFactory.info("dateList= " + dateList);
		  
				//validate format
				boolean dateFormatValue = GenericFactory.isValidDateFormat(dateFormat, dateList);
				if(dateFormatValue)
				{
					LogFactory.info("Date format is right.");   
				}
				else
				{
					LogFactory.info("Date format is right.");
				}
			}
			catch (Exception e) {
				// LogFactory.error("e");
				//String er = e.getMessage().toString().trim();

				ReportFactory.ReporterOutput(TCID, "verify Date Format", "NA",
						"Announcement Date format should display in yyyy-mm-dd. ", result, flag);
			}
		  
		 }
		
	// ***************************************************** E-O-M *****************************************************************************
		
		  //To do the date sort
		  public static void verifyDateOrder(String header) throws Throwable
		  {	
			String TCID = "TC14_Announcement";
			String flag = "Fail";
			String result = "Announcement date is not showing as per the UI Format.";
			
			try{
		   List<String> dateList = GenericFactory.getListOfDatesByHeaderName(header);
		   LogFactory.info("dateList= " +dateList);
		   
		   
		   //sort
		   boolean sortedDate = GenericFactory.verifyDateSortedOrder(dateList);
		   if(sortedDate)
		   {
			   flag= "Pass";
		    LogFactory.info("Date is in sorted order.");
		    
		    ReportFactory.ReporterOutput(TCID, "verify Date Order", "NA",
					"Announcement Date order should display in new to old. ", result, flag);
		   }
		   else
		   {
		    LogFactory.info("Date is not in sorted order.");
		    
		   }
			}
		   catch (Exception e) {
				// LogFactory.error("e");
				//String er = e.getMessage().toString().trim();

		    ReportFactory.ReporterOutput(TCID, "verify Date Order", "NA",
					"Announcement Date order should display in new to old. ", result, flag);
		   }
		  }
	// ***************************************************** E-O-M *****************************************************************************
	
		  
		  public static void verifyReadMoreLink()
		  {
			  String announcementTitleMsg = BaseClass.wbDv.findElement(By.xpath("announcementTitleContents")).getText().toString().trim();
			  System.out.println(announcementTitleMsg);
			/*
			  if(announcementTitleMsgCount >))
`			{ 
	
			}*/
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
}
		  
		
	