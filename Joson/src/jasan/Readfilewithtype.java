package jasan;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Readfilewithtype 
{ 
 public static void main(String[] args) throws AWTException, Exception
 {	 
	 System.setProperty("webdriver.chrome.driver", "G:\\DRIVER\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 Thread.sleep(2000);
	 
	// WebDriver driver = new FirefoxDriver();
	 
	 
	 driver.get("https://you.yash.com/SitePages/SharedServices/HR/library.aspx");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	 
	 Thread.sleep(2000);
	 	 
	 //downloads
	 	 
	//Using Robot class to operate ENTER operation
			Robot robj = new Robot();
			robj.keyPress(KeyEvent.VK_ENTER);
			robj.keyRelease(KeyEvent.VK_ENTER);
			
			
	 
	 //Read file to download
  File folder = new File("C:\\Users\\sweta.ranjan\\Desktop\\Downloded file");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles)
        {
            if (file.isFile())
            {
               // System.out.println(file.getName());
                
                String Filename = file.getName().trim();
                String[] FileArray = Filename.split("\\.");
                
                String Fname = FileArray[0];
                String Ftype = FileArray[1];
                
                System.out.println(Fname + "," + Ftype);                            
                
            }
        }
  }

 }