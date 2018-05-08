package jasan;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class verify_fileType_webPage_wit_testData
{

	public static void verify_filetype(String excel_filePath)
	{ 
		try{
			
		//READING EXCEL
				File file_obj = new File(excel_filePath);
				FileInputStream io_obj = new FileInputStream(file_obj);
				XSSFWorkbook wb_obj = new XSSFWorkbook(io_obj);
				XSSFSheet sheet_obj = wb_obj.getSheet("Sheet1");
				int row_count = sheet_obj.getLastRowNum();
				System.out.println("Total no of Rows= " +row_count);
				int col_count = sheet_obj.getRow(0).getLastCellNum();
				System.out.println("Total no of col= " +col_count);


		//LAUNCH BROWSER
				WebDriver driver = new FirefoxDriver();
				driver.get("https://you.yash.com/SitePages/SharedServices/HR/library.aspx");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

				Thread.sleep(2000);


		//*****FINDING ALL LINKS PRESENT ON WEBPAGE
				List<WebElement> links_obj = driver.findElements((By.tagName("a")));
				int links_count = links_obj.size();

				for(int k=3; k<=row_count; k++)
				{
					String fileName = sheet_obj.getRow(k).getCell(1).getStringCellValue();
					String excel_fileType = sheet_obj.getRow(k).getCell(2).getStringCellValue();

					//	System.out.println(fileName + "," + excel_fileType);		


		//***** SEARCHING EXCEL FILENAME IN LINK

					for(int i=1; i<links_count; i++)
					{
						String links_name = links_obj.get(i).getText().toString().trim();
						//System.out.println(links_name);

						//IF MATCH RETRIVE THE TYPE OF LINK & VERIFYING WITH "excel_fileType" 
						if(links_name.equalsIgnoreCase(fileName))
						{
							String href_txt = links_obj.get(i).getAttribute("href");
							if(href_txt.contains(excel_fileType))
							{
								System.out.println("File matched. " + fileName + "," + excel_fileType + "," + href_txt);
								// sheet_obj.getRow(k).getCell(5).setCellValue("Pass");
							}
							else
							{
								System.out.println("File does not matched. " + fileName + "," + excel_fileType + "," + href_txt);
								// sheet_obj.getRow(k).getCell(5).setCellValue("Fail");

							}

						}
					}
				}
			
	}

	catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws Exception 
	{
		verify_fileType_webPage_wit_testData obj = new verify_fileType_webPage_wit_testData();
		obj.verify_filetype("C:\\Users\\sweta.ranjan\\Desktop\\Excel_file.xlsx");
	}
}
