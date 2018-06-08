package com.deere.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.deere.Helpers.BaseClass;
import com.deere.Helpers.DateFactory;
import com.deere.Helpers.GenericFactory;

public class InvokeTest {
	
			public static void footerLinks() throws InterruptedException {
		
		//url = "https://dealerpath.tal.deere.com/";
				
		//WebDriver driver = new FirefoxDriver();
		/*BaseClass.wbDv;
		wbDv.get("https://dealerpath.tal.deere.com/");

		driver.findElement(By.name("USERNAME")).sendKeys("nm29536");
		driver.findElement(By.name("PASSWORD")).sendKeys("neer1234");
		Thread.sleep(2000);
		
		List<WebElement> homepageFooterList = GenericFactory.getLinksFromFrame(Announcements_POF.homepageFooterFramePath);
		System.out.println(homepageFooterList);
		*/
	}

			public static Date SystemdateTime()
			{
			// Create object of SimpleDateFormat class and decide the format
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			 
			 //get current date time with Date()
			 Date date = new Date();
			 
			 // Now format the date
			 String date1= dateFormat.format(date);
			 
			 // Print the Date
			 System.out.println("Current date and time is " +date);
			return date;
			}
			
			public static void main(String[] args) throws Exception {
				
				/*InvokeTest obj = new InvokeTest();
				//obj.footerLinks();
		//		obj.SystemdateTime();
				
				Date SystmDate = new InvokeTest().SystemdateTime();
			     int year= SystmDate.getDay();
			     
			   //  System.out.println(">>>>"+SystmDate.);
*/			     
			/*    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			 	
			  	String todaysDate=dateFormat.format(date);
			  	String arr[]=todaysDate.split("/");			 	
			 	System.out.println(arr[2]);*/
				Date date = new Date();
				String todaysDate=DateFactory.captureYear(date);
				System.out.println(todaysDate);
				
			}
			
			
		//*******^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
			
			
			public class Excelglobalconstants {

				@SuppressWarnings({ "null", "deprecation" })
				public void getLoginPrerequisites() throws Throwable {
					
					 XSSFRow singleRow;
				
			          XSSFCell cell;
			    
					FileInputStream inputStream = new FileInputStream(new File(BaseClass.strDataPath));
			        @SuppressWarnings("resource")
			        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			        XSSFSheet sheet = workbook.getSheet("Sheet2");

			        
			        LinkedHashMap<String, String> Mapobj = new LinkedHashMap<String, String>();
					
					
			        int totalRows = sheet.getLastRowNum();
			        System.out.println("Total no of rows:" +totalRows);
			        
			        int totalCol = sheet.getRow(0).getLastCellNum(); 
			        System.out.println("Total no of columns:" +totalCol);

					for (int j = 0; j <=5; j++) 
			        {	
						for(int i=0;i<=3;i++)
						{
			        	
						String Attribute_name = sheet.getRow(i).getCell(j) != null ? sheet.getRow(i).getCell(j).getStringCellValue() : null;
			        	System.out.println(Attribute_name);
			        	 	
			        	if(!Attribute_name.equals("  ") && Attribute_name != null) {
			        		
			        		Mapobj.put(Attribute_name, sheet.getRow(i).getCell(j+1).getStringCellValue());
			        	 }	        	

			        }
			        
			        	j=j+3;
			        
			        }
					System.out.println(Mapobj);
			       
			        /*
			        		for (int j = 0; j <totalRows; j++) 
			                {	for(int i=0;i<=5;i++) {
			                	String Attribute_name = sheet.getRow(j).getCell(i) != null ? sheet.getRow(j).getCell(i).getStringCellValue() : null;
			                	System.out.println(Attribute_name);
			                	 	if(!Attribute_name.equals(" ") || Attribute_name != null ) {
			                	Mapobj.put(Attribute_name, sheet.getRow(j).getCell(i+1).getStringCellValue());
			                	 	}
			                	System.out.println(Mapobj);
			                	i++;
			                	//}
			                	
			                	
			                }
			            
			                }
			               */
			                
			           
			}
			        	
		}
}
