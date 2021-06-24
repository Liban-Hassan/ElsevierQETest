package com.elsevier.qe.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.elsevier.qe.base.TestBase;
import com.elsevier.qe.util.TestUtil;

public class PrintedDressesPage extends TestBase {
	
	@FindBy(xpath = "//td[text()='Maxi Dress']")
	WebElement dressType;
	
	@FindBy(id = "group_1")
	WebElement dressSize;
	
	@FindBy(id = "color_11")
	WebElement blackDressColour;
	
	@FindBy(id = "color_16")
	WebElement yellowDressColour;
	
	@FindBy(id = "add_to_cart")
	WebElement addToCart;
	
	@FindBy(id = "quantity_wanted")
	WebElement dressQuantity;
	
	@FindBy(xpath = "//span[@title='Continue shopping']")
	WebElement continueShopping;
	
	@FindBy(linkText = "Summer Dresses")
	WebElement summerDressesLink;
	
	@FindBy(linkText = "Proceed to checkout")
	WebElement checkOut;
	
	
	public PrintedDressesPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String getMaxiDressType() {
		
	    return dressType.getText();
		
	}
	
	
	public SummerDressesPage addBlackMaxiDressToCartContinueShopping(){
		
	    return addDressToCartContinueShopping("1", blackDressColour);
	 
	}
	
	public SummerDressesPage addYellowChiffonDressToCartContinueShopping(){
		
		 return	addDressToCartContinueShopping("1", yellowDressColour);
		 
		}
	

	public CartSummaryPage addBlackMaxiDressToCartProceedToCheckout(){
		
	    return addDressToCartProceedToCheckout("1", blackDressColour);
	 
	}
	

	public CartSummaryPage addYellowChiffonDressToCartProceedToCheckout(){
		
	    return addDressToCartProceedToCheckout("1", yellowDressColour);
	 
	}
	
	
	
	private SummerDressesPage addDressToCartContinueShopping(String quantity, WebElement dressColour ){
		
		addDressToCart(quantity, dressColour);
		
		continueShopping.click();
		
		summerDressesLink.click();
		
		return new SummerDressesPage();
		
	}
	
	private CartSummaryPage addDressToCartProceedToCheckout(String quantity, WebElement dressColour) {
		
		addDressToCart(quantity, dressColour);
		TestUtil.clickOn(driver, checkOut, 20);
		
		
		return new CartSummaryPage();
	}
	
	
	private void addDressToCart(String quantity, WebElement dressColour) {
		
		selectDress(quantity, dressColour);
		
		addToCart.click();
	}
	
	
	
	private void selectDress(String quantity, WebElement dressColour) {
		
		dressQuantity.clear();
		dressQuantity.sendKeys(quantity);
		
		selectDressSize();
		
		dressColour.click();
	}
	
	
	
	private void selectDressSize() {
		
		Select select = new Select(dressSize);
		select.selectByVisibleText("M");
	}
	
   

}
