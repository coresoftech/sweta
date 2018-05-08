package jasan;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class newFile 
{
	public static String FileName(String filename)
	{
		String Strreturn="";
		try
		{			
			
			//Read the Files
			String[] strfileArray = filename.split("\\.");
	    		String strfileName = strfileArray[0];
	    		String strfileExt = strfileArray[1];
	    	

			//*****To comapre the fileName
			Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(strfileName);
			boolean b = m.find();

			if (b==true)
			
			   Strreturn = strfileName + " " + "This File contains Special character.";
		

			else
					  
			   Strreturn = strfileName + " " + "This File can not contains Special character.";
			   
	 
		
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return Strreturn;
	}


	
	public static String fileName_wit_extension(String filename)
	{
			
		String Strreturn="";
		
		//Read the Files
		String[] strfileArray = filename.split("\\.");
    		String strfileName = strfileArray[0];
    		String strfileExt = strfileArray[1];
    		    	
            
      		//*****To check a string if there is a special character in it or not
 		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(strfileName);
		boolean b = m.find();

		if (b==true)
		
		   Strreturn = strfileName + " " + "This File contains Special character.";
		  
		else
				  
		   Strreturn = strfileName + " " + "This File can not contains Special character.";
		
		
    return Strreturn;
    
	}
	
	public static void main(String[] args)
	{
		newFile obj1 = new newFile();
		
		obj1.FileName("swe@.xlsx");
		obj1.fileName_wit_extension("äbc.pdf");
	}
}

