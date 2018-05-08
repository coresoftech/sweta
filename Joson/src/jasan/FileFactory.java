package jasan;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileFactory
{

	public static void FileName(String folderpath)
	{
		try
		{
			//Read the Folder Files
			File folder = new File(folderpath);
			File[] listOfFiles = folder.listFiles();

			String filename;
			for (File eachfile : listOfFiles) 
			{
			    if (eachfile.isFile()) 
			    {
			    	filename = eachfile.getName();
			    	String[] strfileArray = filename.split("\\.");
			    	String strfileName = strfileArray[0];
			    	String strfileExt = strfileArray[1];
			    	
			       // System.out.println(eachfile.getName());
			        
			      //*****To comapre the fileName
					Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
					Matcher m = p.matcher(strfileName);
					boolean b = m.find();

					if (b==true)
					{
					   System.out.println(strfileName + "          ," + "This File contains Special character.");
					}

					else
					{
					   System.out.println("******************************************");
					   System.out.println(strfileName + "          ," + "This File can not contains Special character.");

					   
					}
			    }
			}
			System.out.println("%--------%%-----------%%-------------%%-------------%%-------------%%------------%%---------%");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void FileExtesion(String folderpath)
	{
		try
		{
			File folder = new File(folderpath);
			File[] listOfFiles = folder.listFiles();

			String filename;
			for (File eachfile : listOfFiles) 
			{
			    if (eachfile.isFile()) 
			    {
			    	filename = eachfile.getName();
			    	String[] strfileArray = filename.split("\\.");
			    	String strfileName = strfileArray[0];
			    	String strfileExt = strfileArray[1];
			    	
			    	System.out.println(strfileName + "          ," + strfileExt);	
			    	System.out.println("******************************************");
			    }
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	
	
	public static void main(String[] args)
	{
		FileFactory obj = new FileFactory();
		obj.FileName("C:\\Users\\sweta.ranjan\\Desktop\\Downloded file");
		obj.FileExtesion("C:\\Users\\sweta.ranjan\\Desktop\\Downloded file");		
	}

}
