package com.flipkart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class ProductPurchasePage extends BaseClass {

	public ProductPurchasePage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='name']")
	private WebElement txtName;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement txtMobile;

	@FindBy(xpath = "//input[@name='pincode']")
	private WebElement txtpincCode;

	@FindBy(xpath = "//input[@name='addressLine2']")
	private WebElement txtLocality;

	@FindBy(xpath = "//textarea[@name='addressLine1']")
	private WebElement txtAddress;

	@FindBy(xpath = "//span[text()='Home (All day delivery)']")
	private WebElement rdoAddressType;

	@FindBy(xpath = "//button[text()='Save and Deliver Here']")
	private WebElement btnSaveAndDelivery;

	@FindBy(xpath = "//span[text()='Credit / Debit / ATM Card']")
	private WebElement rdoCCNum;

	@FindBy(xpath = "//input[@name='cardNumber']")
	private WebElement txtCCNum;

	@FindBy(xpath = "//select[@name='month']")
	private WebElement dropDwnMonth;

	@FindBy(xpath = "//select[@name='year']")
	private WebElement dropDwnYY;

	@FindBy(xpath = "//input[@name='cvv']")
	private WebElement txtCvv;

	@FindBy(xpath = "//button[@class='QqFHMw TVgwvR _7Pd1Fp']")
	private WebElement btnPay;

	@FindBy(xpath = "//button[text()='Change']")
	private List<WebElement> btnChange;

	@FindBy(xpath = "//input[@class='HFxIVK']")
	private WebElement txtEmail;

	@FindBy(xpath = "//button[@class='QqFHMw VuSC8m _7Pd1Fp']")
	private WebElement btnContinue;

	@FindBy(xpath = "//button[text()='Accept & Continue']")
	private WebElement btnAccept;

	public void addEmailDetails(String emailId) {
		elementSendKeys(txtEmail, emailId);
		elementClick(btnContinue);
		elementClick(btnAccept);

	}

	public void addDeliveryAddress(String name, String mobileNo, String pinCode, String locality, String address,
			String addressType) {

		if (btnChange.size() == 2) {
			WebElement element = btnChange.get(1);
			elementClick(element);
		}

		elementSendKeys(txtName, name);
		elementSendKeys(txtMobile, mobileNo);
		elementSendKeys(txtpincCode, pinCode);
		elementSendKeys(txtLocality, locality);
		elementSendKeys(txtAddress, address);
		elementClick(rdoAddressType);
		elementClick(btnSaveAndDelivery);

	}

	public void addPayment(String cardNo, String expMonth, String expYear, String cvv) {
		elementClick(rdoCCNum);
		elementSendKeys(txtCCNum, cardNo);
		selectOptionByText(dropDwnMonth, expMonth);
		selectOptionByText(dropDwnYY, expYear);
		elementSendKeys(txtCvv, cvv);
		elementClick(btnPay);

	}

}
