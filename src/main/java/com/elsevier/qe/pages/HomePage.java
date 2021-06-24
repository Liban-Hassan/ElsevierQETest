package com.elsevier.qe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.elsevier.qe.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(linkText = "DRESSES")
	WebElement dresses;
	
	@FindBy(linkText = "SUMMER DRESSES")
	WebElement summerDresses;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public SummerDressesPage clickSummerDressesLink() {
		
		mouseOverDressesLink();
		
		summerDresses.click();
		
		return new SummerDressesPage();
	}
	
	private void mouseOverDressesLink() {
		
		Actions action = new Actions(driver);
		action.moveToElement(dresses).build().perform();
	}

}