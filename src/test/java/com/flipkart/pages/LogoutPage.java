package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class LogoutPage extends BaseClass {

	public LogoutPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@class='W5mR4e']")
	private WebElement logoFlipkart;

	@FindBy(xpath = "//span[text()='Account']")
	private WebElement btnAccount;

	@FindBy(xpath = "//li[text()='Logout']")
	private WebElement btnLogout;

	public WebElement getLogoFlipkart() {
		return logoFlipkart;
	}

	public WebElement getBtnAccount() {
		return btnAccount;
	}

	public WebElement getBtnLogout() {
		return btnLogout;
	}
	
	public void logout() {
		// TODO Auto-generated method stub

	}

	public void clickLogoFlipkart() {
		elementClick(logoFlipkart);
		sleep();

	}

	public void logOut() {
		mouseOverAction(btnAccount);
		elementClick(btnLogout);

	}
	
	

}
