package com.elsevier.qe.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elsevier.qe.base.TestBase;

public class SummerDressesPage extends TestBase {
	
	@FindBy(linkText = "Printed Chiffon Dress")
	WebElement chiffonDress;

	@FindBy(linkText = "Printed Summer Dress" )
	WebElement maxiDress; 
	
	@FindBy(xpath = "//span[@class='cat-name']")
	WebElement summerDressesHeader;
	
	@FindBy(linkText = "DRESSES")
	WebElement dresses;
	
	@FindBy(linkText = "SUMMER DRESSES")
	WebElement summerDresses;

	
	public SummerDressesPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String verifySummerDressSubHeader() {
				
	 return summerDressesHeader.getText();
	 
	}
	
	
	public PrintedDressesPage clickMaxiDressLink() {
		
		maxiDress.click();
		
		return new PrintedDressesPage(); 
	}
	
	public PrintedDressesPage clickChiffonDress() {
		
		chiffonDress.click();
		
		return new PrintedDressesPage();
	}
	
	
	

}
