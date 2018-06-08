package com.deere.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.deere.Helpers.GenericFactory;
import com.deere.Helpers.ReportFactory;

public class Search_POF {
	static WebDriver driver;

	public Search_POF(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.ID, using = "inputFormText")
	static WebElement searchBox;

	@FindBy(how = How.CLASS_NAME, using = "search-button")
	static WebElement searchBoxButton;

	@FindBy(how = How.XPATH, using = "//div[@class='column-facet-options']/div/div/label/div")
	static List<WebElement> productType;

	@FindBy(how = How.XPATH, using = "//div[@class='result-footer']/div/div[3]")
	static List<WebElement> resultFooter;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'search-apply-filters')]/parent::div")
	 static WebElement applyFilters;

	 @FindBy(how = How.XPATH, using = "//ul[@class='pagination']")
	 static WebElement pagination;
	 
	 @FindBy(how = How.CLASS_NAME, using = "next")
	 static WebElement nextLink;
	 
	/**
	 * @param strExpctSearchText
	 * @param TCID
	 * @throws Throwable
	 *             Verify text is entered in search box
	 */
	public void enterSearchText(String strExpctSearchText, String TCID) throws Throwable {
		String flag = "Fail";

		String result = "text is not entered in search box";
		try {
			if (searchBox.isEnabled()) {
				searchBox.sendKeys(strExpctSearchText);
				flag = "Pass";
				result = "text is entered in search box";
			}

			ReportFactory.ReporterOutput(TCID, "Enter the search text", strExpctSearchText,
					"Verify text is entered in search box", result, flag);
			
			if (flag.equalsIgnoreCase("FAIL") )
			{ 	Assert.assertFalse(true);}
			
		} catch (Exception e) {

			ReportFactory.ReporterOutput(TCID, "Enter the search text", strExpctSearchText,
					" Verify text is entered in search box", e.getMessage().toString(), flag);
		}
	}

	/**
	 * @param TCID
	 * @throws Throwable
	 *             Verify clicked on search button
	 */
	public void clickOnSearchButton(String TCID) throws Throwable {
		String flag = "Fail";

		String result = "search box is not clicked";
		try {
			if (searchBoxButton.isEnabled()) {
				searchBoxButton.click();
				flag = "Pass";
				result = "search box is clicked";
			}

			ReportFactory.ReporterOutput(TCID, "Click on search button", "NA", "Verify clicked on search button",
					result, flag);
			
			if (flag.equalsIgnoreCase("FAIL") )
			{ 	Assert.assertFalse(true);}
			
		} catch (Exception e) {

			ReportFactory.ReporterOutput(TCID, "Click on search button", "NA", "Verify clicked on search button",
					e.getMessage().toString(), flag);
		}
	}

	/**
	 * @param productName
	 * @param TCID
	 * @return
	 * @throws Throwable
	 *             Verify check box is unchecked
	 */
	public String clickOnSelectedCheckBox(String strExpctSearchText, String TCID) throws Throwable {
		String number = "";
		String flag = "Fail";

		String result = "check box is not unchecked";
		try {
			if (productType.size() > 0) {
				for (int i = 0; i < productType.size(); i++) {

					String type = productType.get(i).getText();
					String product = GenericFactory.splitString(type, "(").get(0);
					String prodValue = GenericFactory.splitString(type, "(").get(1);
					number = GenericFactory.splitString(prodValue, ")").get(0);
					if (product.equalsIgnoreCase(strExpctSearchText)) {

						productType.get(i).click();
						flag = "Pass";
						result = "check box is clicked";
						break;
					}

				}

			}

			ReportFactory.ReporterOutput(TCID, "Click on checkbox", strExpctSearchText, "Verify checkbox is unchecked",
					result, flag);
			
			if (flag.equalsIgnoreCase("FAIL") )
			{ 	Assert.assertFalse(true);}
			
		} catch (Exception e) {

			ReportFactory.ReporterOutput(TCID, "Click on checkbox", strExpctSearchText, "Verify checkbox is unchecked",
					e.getMessage().toString(), flag);
		}
		return number;
	}

	/**
	 * @param strExpctSearchText
	 * @param TCID
	 * @throws Throwable
	 *             Verify search page has no unchecked check box value
	 */
	public void getResultFooterRowValues(String strExpctSearchText, String TCID) throws Throwable {
		String flag = "Pass";
		String result = "footer row not contains value unchecked";

		try {
			for (int i = 0; i < resultFooter.size(); i++) {

				String content = resultFooter.get(i).getText();
				System.out.println("!!!!!!!!!!!!!!!!!!!!!"+content);
				if (content.contains(strExpctSearchText)) {
					flag = "Fail";
					result = "footer row contains value unchecked";
				}
			}
			ReportFactory.ReporterOutput(TCID, "Value is not displayed in search page", strExpctSearchText,
					"Verify value unchecked is not displayed in search page", result, flag);
			
			if (flag.equalsIgnoreCase("FAIL") )
			{ 	Assert.assertFalse(true);}
			
		} catch (Exception e) {

			ReportFactory.ReporterOutput(TCID, "Value is not displayed in search page", strExpctSearchText,
					"Verify value unchecked is not displayed in search page", e.getMessage().toString(), flag);
		}
	}
	
	/**
	  * @param element
	  * @param driver
	  * Scroll to Element
	  */
	 public void scrollToElement(WebElement element, WebDriver driver) {
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	 }
	 
	 /**
	  * @param TCID
	  * @throws Throwable
	  *  Verify clicked on apply filters button
	  */
	 public void clickApplyFilters(String TCID) throws Throwable { 
	  String flag = "Fail";

	  String result = "apply filters is not clicked";
	  try {
	   scrollToElement(applyFilters, driver);

	   if (applyFilters.isEnabled()) {
	    applyFilters.click();
	    flag = "Pass";
	    result = "apply filters is clicked";
	   }

	   ReportFactory.ReporterOutput(TCID, "Click on apply filters button", "NA", "Verify clicked on apply filters button",
	     result, flag);
		
		if (flag.equalsIgnoreCase("FAIL") )
		{ 	Assert.assertFalse(true);}
		
	  } catch (Exception e) {

	   ReportFactory.ReporterOutput(TCID, "Click on apply filters button", "NA", "Verify clicked on apply filters button",
	     e.getMessage().toString(), flag);
	  }
	 }

	 /**
	  * @param strExpctSearchText
	  * @param TCID
	  * @throws Throwable
	  *             Verify search page has no unchecked check box by clicking
	  *             pagination
	  */
	 public void clickOnNextPaginationLink(String strExpctSearchText, String TCID) throws Throwable {
	  List<WebElement> pages = pagination.findElements(By.tagName("a"));
	  int count = 0;
	  String flag = "Pass";
	  String result = "footer row not contains value unchecked";
	  try {
	   while (count < pages.size() - 2) {
	    if (nextLink.isEnabled()) {
	     List<WebElement> body = resultFooter;
	     System.out.println(body.size());

	     for (int i = 0; i < body.size(); i++) {
	      String content = body.get(i).getText();
	      if (content.contains(strExpctSearchText)) {
	       flag = "Fail";
	       result = "footer row contains value unchecked";
	      }
	     }

	     nextLink.click();
	     ++count;

	    }
	   }
	   ReportFactory.ReporterOutput(TCID, "Value is not displayed in search page", strExpctSearchText,
	     "Verify value unchecked is not displayed in search page", result, flag);
		
		if (flag.equalsIgnoreCase("FAIL") )
		{ 	Assert.assertFalse(true);}
		
	  } catch (Exception e) {

	   ReportFactory.ReporterOutput(TCID, "Value is not displayed in search page", strExpctSearchText,
	     "Verify value unchecked is not displayed in search page", e.getMessage().toString(), flag);
	  }
	 }
}
