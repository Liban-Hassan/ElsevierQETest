package com.elsevier.qe.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elsevier.qe.base.TestBase;

public class SignInPage extends TestBase {
	                 
	@FindBy(xpath = "//span[@class='navigation_page']")
	WebElement authenticationHeader;
	
	
	public SignInPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String getAuthenticationHeader() {
		
		return authenticationHeader.getText();
	}

}
