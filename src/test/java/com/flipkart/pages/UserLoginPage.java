package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class UserLoginPage extends BaseClass {
	public UserLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='I-qZ4M vLRlQb']//child::input[@type='text']")
	private WebElement txtMobileNo;

	@FindBy(xpath = "//button[text()='Request OTP']")
	private WebElement btnReqOTP;

	@FindBy(xpath = "//div[text()='My Account']")
	private WebElement lnkAccount;

	@FindBy(xpath = "//div[text()='Logout']")
	private WebElement btnLogOut;

	public WebElement getTxtMobileNo() {
		return txtMobileNo;
	}

	public WebElement getBtnReqOTP() {
		return btnReqOTP;
	}

	public void login(String mobileNo) {
		elementSendKeys(getTxtMobileNo(), mobileNo);
		elementClick(getBtnReqOTP());
		sleep();

	}

}
