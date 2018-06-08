
/* 
 * Project    : DealerPath
 * Script     : Login_Page_POF
 * Author     : Shrishail Baddi
 * Date       : April.14.2018
 * Last Modified On:
 * Modified By :
 */

package com.deere.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.deere.Helpers.BaseClass;
import com.deere.Helpers.GenericFactory;
import com.deere.Helpers.LogFactory;
import com.deere.Helpers.ReportFactory;

public class Login_Page_POF extends BaseClass {

	final WebDriver locDriver;

	public Login_Page_POF(WebDriver driver) {

		this.locDriver = driver;

	}

	@FindBy(how = How.ID_OR_NAME, using = "username")
	static WebElement txtUserName;

	@FindBy(how = How.NAME, using = "PASSWORD")
	static WebElement txtPasswordName;

	@FindBy(how = How.NAME, using = "login")
	static WebElement btnSignin;
	
	
	

	public static void setCredentials(String username, String password) throws Throwable {

		try {
			String strFlagUserName = "Fail";
			txtUserName.sendKeys(username);

			if ((txtUserName.getText()) != "") {
				strFlagUserName = "Pass";
				LogFactory.info(" Username... " + txtUserName.getText());

			}
			ReportFactory.ReporterOutput("TC01_Login", "Verify entered Username. ", username, "Please enter Username.",
					txtUserName.getText(), strFlagUserName );

			String strFlagPassword = "Fail";
			txtPasswordName.sendKeys(password);

			if ((txtPasswordName.getText() != "")) {
				strFlagPassword = "Pass";
				LogFactory.info("Password ... " + txtPasswordName.getText());
				ReportFactory.ReporterOutput("TC02_Login", "Verify entered Password. ", "XXXXXXXXXX",
						"Please enter Password.", txtPasswordName.getText(), strFlagPassword );
			}

			if (strFlagUserName.equalsIgnoreCase("Pass") && strFlagPassword.equalsIgnoreCase("Pass")) {

				btnSignin.click();
				LogFactory.info("Clicked on Sign-In button... ");

				ReportFactory.ReporterOutput("TC03_Login", "Click On Sign-in Button.", "Sign-in",
						"Click On Sign-in Button.", "Sign-In done Successfully.", "Pass" );
			} else {
				ReportFactory.ReporterOutput("Error_Login", "Unable to Sign-In", "Sign-in", "NA",
						"Unable to Sign-In : Blank Username or Blank Password", "Fail" );
				
/*				if (flag.equalsIgnoreCase("FAIL") )
				{ 	Assert.assertFalse(true);}*/
			}

		} catch (Exception e) {
			System.out.println("############################" + e.getMessage());
			// ReportFactory.ReporterOutput("Error_Login","Unable to Sign-In", "Sign-in"
			// ,"NA",e.getMessage(),"Fail",null);
			ReportFactory.ReporterOutput("Error_Login", "Unable to Sign-In", "Sign-in", "NA",
					e.getMessage().toString(), "Fail" );
		}

	}

}
