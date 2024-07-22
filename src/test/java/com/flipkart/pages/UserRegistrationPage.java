package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class UserRegistrationPage extends BaseClass {

	public UserRegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Login']")
	private WebElement btnLogin;

	@FindBy(xpath = "//a[text()='New to Flipkart? Create an account']")
	private WebElement lnkCreateNewAcct;

	@FindBy(xpath = "//div[@class='I-qZ4M vLRlQb']/input")
	private WebElement txtMobileNo;

	@FindBy(xpath = "//button[@type='submit']/child::span")
	private WebElement btnContinue;

	@FindBy(xpath = "//button[@type='submit']/child::span")
	private WebElement signUpBtn;

	@FindBy(xpath = "//span[text()='Account']")
	private WebElement lnkAccount;

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getLnkCreateNewAcct() {
		return lnkCreateNewAcct;
	}

	public WebElement getTxtMobileNo() {
		return txtMobileNo;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getLnkAccount() {
		return lnkAccount;
	}

	public WebElement getSignUpBtn() {
		return signUpBtn;
	}

	public void navigateRegisterPage() {
		elementClick(getBtnLogin());

	}

	public void registration(String mobileNo) {
		elementClick(getLnkCreateNewAcct());
		elementSendKeys(getTxtMobileNo(), mobileNo);
		elementClick(getBtnContinue());
		sleep();

	}

	public String getAccountMsgText() {
		sleep();
		String elementGetText = elementGetText(lnkAccount);
		return elementGetText;

	}

	public String getLoginMsgText() {
		sleep();
		String elementGetText = elementGetText(btnLogin);
		return elementGetText;

	}

}
