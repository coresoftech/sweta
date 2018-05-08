package jasan;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class json_exampl 
{
	public static void wordPress(String txtTitle, String txtmsg) throws Exception
	{
		try
		{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php?redirect_to=https%3A%2F%2Fs1.demo.opensourcecms.com%2Fwordpress%2Fwp-admin%2F&reauth=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		//Pass userName Pwd
		driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys("opensourcecms");
		driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys("opensourcecms");
		driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
		
		//ACTIONS  on Pages module
		  
		WebElement Page_obj = driver.findElement(By.xpath(".//*[@id='menu-pages']/a/div[3]"));
		
		Actions act_obj = new Actions(driver);
		act_obj.moveToElement(Page_obj).build().perform();
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		//****To display submodules of PAGE
		driver.findElement(By.xpath(".//*[@id='menu-pages']/ul/li[2]/a")).click();
		
		
		//WEBTABLE
		WebElement table_obj_before = driver.findElement(By.xpath(".//*[@id='the-list']"));
		List<WebElement> row_obj_before = table_obj_before.findElements(By.tagName("tr"));
		int row_count_before = row_obj_before.size();
		
		String table_value_before = "";
		for(int i=1; i<=row_count_before; i++)
		{
			List<WebElement> col_obj_before = row_obj_before.get(i).findElements(By.tagName("td"));
			int col_count_before = col_obj_before.size();
			for(int j=1; j<=col_count_before; j++)
			{
				table_value_before = col_obj_before.get(j).getText().toString().trim();
				System.out.println(table_value_before);
			}
		}
		  	
		
		//*** ADD NEW PAGE
		driver.findElement(By.xpath(".//*[@id='wpbody-content']/div[3]/a")).click();
		driver.findElement(By.xpath(".//*[@id='title']")).sendKeys(txtTitle);
		Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='tinymce']/p")).sendKeys(txtmsg);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='publish']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='wpbody-content']/div[3]/a")).click();
			
		Thread.sleep(2000);
		
		
		//**** AGAIN READ WEBTABLE
		WebElement table_obj_after = driver.findElement(By.xpath(".//*[@id='the-list']"));
		List<WebElement> row_obj_after = table_obj_after.findElements(By.tagName("tr"));
		int row_count_after = row_obj_after.size();
		
		String table_value_after = "";
		for(int i=1; i<=row_count_after; i++)
		{
			List<WebElement> col_obj_after = row_obj_before.get(i).findElements(By.tagName("td"));
			int col_count_after = col_obj_after.size();
			for(int j=1; j<=col_count_after; j++)
			{
				table_value_after = col_obj_after.get(j).getText().toString().trim();
				System.out.println(table_value_after);
			}
			
		}
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	
	
	//******************************************************************************************************
	
	public static void main(String[] args) throws Exception 
	{
		json_exampl obj = new json_exampl();
		obj.wordPress("Sample3", "Hello 3");
	}
}
