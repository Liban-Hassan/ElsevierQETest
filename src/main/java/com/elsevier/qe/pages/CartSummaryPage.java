package com.elsevier.qe.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elsevier.qe.base.TestBase;
import com.elsevier.qe.util.TestUtil;

public class CartSummaryPage extends TestBase {
	
	@FindBy(linkText = "Proceed to checkout")
	WebElement checkOut;
	
	@FindBy(xpath = "//span[@class='navigation_page']") 
	WebElement shoppingCart;
	
	public CartSummaryPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String getCartSummaryHeader() {
		
		 return shoppingCart.getText();
		
	}
	
	public SignInPage proceedToCheckOut() {
		
		checkOut.click();
		
		return new SignInPage();
	}
	
	

}
