package jasan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class test {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		/*	JSONObject obj=new JSONObject();    
			  obj.put("name","sonoo");    
			  obj.put("age",new Integer(27));    
			  obj.put("salary",new Double(600000));    
			   System.out.print(obj);*/		
		
			 
			        JSONParser parser = new JSONParser();
			 
			        try {
			 
			            Object obj = parser.parse(new FileReader(
			                    "C:\\Users\\sweta.ranjan\\Desktop\\file.txt"));
			 
			            JSONObject jsonObject = (JSONObject) obj;
			 
			            String name = (String) jsonObject.get("Name");
			            String author = (String) jsonObject.get("Author");
			            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
			 
			            System.out.println("Name: " + name);
			            System.out.println("Author: " + author);
			            System.out.println("\nCompany List:");
			            
			            
			            Iterator<String> iterator = companyList.iterator();
			            while (iterator.hasNext())
			            {
			                System.out.println(iterator.next());
			            }
			 
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }

}
