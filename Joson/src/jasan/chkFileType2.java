package jasan;


import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class chkFileType2 
{
	public static String FileName(String filename)
	{
			String Strreturn="";
			
			//Read the Folder Files
			String[] strfileArray = filename.split("\\.");
	    	String strfileName = strfileArray[0];
	    	String strfileExt = strfileArray[1];
	    	
	            
	      //*****To comapre the fileName
			Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(strfileName);
			boolean b = m.find();

			if (b==true)
			{
			   Strreturn = strfileName + " " + "contianing special character";
			}

			else
			{			  
			   Strreturn = strfileName + " " + "NOT contianing special character";
			   //System.out.println("-------------------------------------------------------------------------------");
			}
			
	    return Strreturn;
		
	}

	public static ArrayList<String> fileName_wit_extension(String filename)
	{
		ArrayList<String> filename_obj = new ArrayList<String>();
		
		String Strreturn="";
		
		//Read the Folder Files
		String[] strfileArray = filename.split("\\.");
    	String strfileName = strfileArray[0];
    	String strfileExt = strfileArray[1];
    	filename_obj.add(strfileExt);
    	
            
      //*****To comapre the fileName
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(strfileName);
		boolean b = m.find();

		if (b==true)
		{
		   Strreturn = strfileName + " " + "contianing special character";
		   filename_obj.add(Strreturn);
		   
		}

		else
		{			  
		   Strreturn = strfileName + " " + "NOT contianing special character";
		   filename_obj.add(Strreturn);
		   //System.out.println("-------------------------------------------------------------------------------");
		}
		
    return filename_obj;
	
	}
	//***************************************************** END OF METHOD *************************************************************
	
	public static String FileExtension(String filename)
	{
		String[] strfileArray = filename.split("\\.");
    	String strfileName = strfileArray[0];
    	String strfileExt = strfileArray[1];
    	    		
    	return strfileExt;
	}
	
	//***************************************************** END OF METHOD *************************************************************
	
	public static void main(String[] args) throws Exception
	{
		chkFileType2 obj = new chkFileType2();
		/*String savFileNam = obj.FileName("sweta.xml - ");
		String savFileExt = obj.FileExtension("swet@.txt");*/
		
		ArrayList<String> filTyp_obj = obj.fileName_wit_extension("sw#eta.bimp");
				
		String FileExtType = filTyp_obj.get(0);
		String FileChar = filTyp_obj.get(1);
		System.out.println("File Extension is- " +FileExtType);
		System.out.println("File chacter is- " + FileChar);
		
	
		
		/*
		String chkFile = FileName("sweta12ranj@n.txt - ");
		System.out.println(chkFile);	
		String ExtFile = FileExtension("sweta_ranj@n.pdf");
		System.out.println(ExtFile);*/
	}
}
