package com.elsevier.qe.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.elsevier.qe.base.TestBase;
import com.elsevier.qe.pages.CartSummaryPage;
import com.elsevier.qe.pages.HomePage;
import com.elsevier.qe.pages.PrintedDressesPage;
import com.elsevier.qe.pages.SignInPage;
import com.elsevier.qe.pages.SummerDressesPage;
import com.elsevier.qe.util.TestUtil;

public class SignInPageTest extends TestBase {
	
	HomePage homePage;
	SummerDressesPage summerDressesPage;
	PrintedDressesPage printedDressesPage;
	CartSummaryPage cartSummaryPage;
	SignInPage signInPage;
	
	
	public SignInPageTest() {
		
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		homePage = new HomePage();
		
		
	}
	
	@Test(priority = 3)
	public void verifyProceedToSignUpWithMaxiDressInCart(){
		
		summerDressesPage = homePage.clickSummerDressesLink();
		
		String summerSubHeader = summerDressesPage.verifySummerDressSubHeader().trim();
		
		Assert.assertEquals(summerSubHeader,"SUMMER DRESSES", "Not on summer dress page");
		
		printedDressesPage = summerDressesPage.clickMaxiDressLink();
		
		String DressName = printedDressesPage.getMaxiDressType().trim();
		 
		Assert.assertEquals(DressName, "Maxi Dress", "Not on printed dress page");

		cartSummaryPage = printedDressesPage.addBlackMaxiDressToCartProceedToCheckout();
		
		String cartSummaryHeader = cartSummaryPage.getCartSummaryHeader().trim();
		
		Assert.assertEquals(cartSummaryHeader, "Your shopping cart", "Not on shopping cart page");
		
		signInPage = cartSummaryPage.proceedToCheckOut();
		
	    String authenticationHeader = signInPage.getAuthenticationHeader().trim();
	 
	    Assert.assertEquals(authenticationHeader, "Authentication", " Header name does not match");
		
	}
	
	@Test(priority = 1)
	public void verifyProceedToSignUpWithChiffonDressInCart() {
		
		summerDressesPage = homePage.clickSummerDressesLink();
		printedDressesPage = summerDressesPage.clickMaxiDressLink();
		cartSummaryPage = printedDressesPage.addYellowChiffonDressToCartProceedToCheckout();
		signInPage = cartSummaryPage.proceedToCheckOut();
		
		String authenticationHeader = signInPage.getAuthenticationHeader();
		 
		Assert.assertEquals(authenticationHeader, "Authentication", " Header name does not match");
			
	}
	
	@Test(priority = 2)
	public void verifyProceedToSignUpWithMaxiDressAndChiffonDressInCart() {
		
		summerDressesPage = homePage.clickSummerDressesLink();
		printedDressesPage = summerDressesPage.clickMaxiDressLink();
		summerDressesPage = printedDressesPage.addBlackMaxiDressToCartContinueShopping();
		printedDressesPage = summerDressesPage.clickChiffonDress();
		printedDressesPage.addYellowChiffonDressToCartProceedToCheckout();
		
		String authenticationHeader = signInPage.getAuthenticationHeader();
		 
		Assert.assertEquals(authenticationHeader, "Authentication", " Header name does not match");
			
	}
	 
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
