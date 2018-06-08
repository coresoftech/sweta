package com.deere.PageFactory;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.LinkedHashMap;
	import java.util.LinkedHashSet;
	import java.util.List;
	import java.util.Set;
	import java.util.TreeMap;

	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.testng.annotations.Test;

	//public class Excelnewcode 
	public class test
	{
		@Test
		public static void excelread() throws Exception
		{
		  FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\vinay.kumar\\Desktop\\testdatasample.xlsx"));
	      @SuppressWarnings("resource")
	      XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	      XSSFSheet firstSheet = workbook.getSheet("Sheet2");

	      int totalRows = firstSheet.getLastRowNum();
	    
	      int startRow=0;
	      int totalCol=0;
	      //
	      
	      ArrayList<String>ListAttributeName= new ArrayList<String>();
	      for(int i=0;i<totalRows;i++)
	      {
	    	  String cellvalue = firstSheet.getRow(i).getCell(0).getStringCellValue().toString().trim();
	    	  if(cellvalue.equalsIgnoreCase("User_Id")){
	    		  startRow=i;
	    		 
	    		   totalCol = firstSheet.getRow(startRow).getLastCellNum();
	    		   
	    		   for(int j=0;j<totalCol;j++){
	    			   
	    			   String AttributeName = firstSheet.getRow(startRow).getCell(j).getStringCellValue().trim().toString();
	    			   ListAttributeName.add(AttributeName);
	    		   }
	    		 
	    		  break;
	    		
	    	  }
	    	
	      }
	//**************** Reading Excel sheet line by line
	        
	    
	      
	      
	      ArrayList<LinkedHashMap> Exceldata= new  ArrayList<LinkedHashMap>();
	      
	      LinkedHashSet<String>UniqueUserIdList= new LinkedHashSet<String>();
	      
	    
	     
	      
	     for(int i=startRow+1;i<totalRows;i++)
	      {
	    	      String User_Id = firstSheet.getRow(i).getCell(0).getStringCellValue().trim();
	   	          UniqueUserIdList.add(User_Id);
	    	      LinkedHashMap<String, String> excelrowdata = new LinkedHashMap<String, String>();
	    	     for(int j=0;j<totalCol;j++)
	    	      {
	    		  
	    		  String StrAttributeName = ListAttributeName.get(j);
	    		  String StrAttributeValue=firstSheet.getRow(i).getCell(j).getStringCellValue().trim();
	    		  excelrowdata.put(StrAttributeName, StrAttributeValue);
	    	       }
	    	       Exceldata.add(excelrowdata);
	      }   
	    	// Completed excel data   
	 
	     System.out.println(UniqueUserIdList);
	     System.out.println();
	   //  System.out.println(Exceldata);
	      
	      
	      
	     
	  
	      
		
	     
	     String id="XCI8711";
	     
	     
	     for(int i=0;i<Exceldata.size();i++){
	    	 LinkedHashMap rowdata = Exceldata.get(i);
	    	String id_value = (String) rowdata.get("User_Id");
	    	//System.out.println(id_value);
	    	if(id_value.equalsIgnoreCase(id)){
	    		
	    		String  value = (String) rowdata.get("ContentType");
	    		if(value.equalsIgnoreCase("AT-UtilityLinks"))
	    		System.out.println(rowdata);
	    		
	    	}
	    	 
	     }
	     
	     
	     

		
		}
	

}
