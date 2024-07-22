package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseClass;

public class ProductSearchPage extends BaseClass {

	public ProductSearchPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	private WebElement txtSearchBox;

	@FindBy(xpath = "//span[@class='BUOuZu']")
	private WebElement textSearchResMsg;

	@FindBy(xpath = "//div[contains(text(),'Apple iPhone')]")
	private WebElement lnkProductName;

	@FindBy(xpath = "//button[@class='QqFHMw vslbG+ In9uk2']")
	private WebElement btnAddToCart;

	@FindBy(xpath = "//span[text()='Place Order']")
	private WebElement btnPlaceOrder;

	public void searchProduct(String productName) {
		elementSendKeysEnter(txtSearchBox, productName);
	}

	public String getSearchSuccessMsgText() {
		String elementGetText = elementGetText(textSearchResMsg);
		return elementGetText;

	}

	public void addProductIntoCart() {
		elementClick(lnkProductName);
		switchToChildWindow();
		sleep(5000);
		elementClick(btnAddToCart);
		elementClick(btnPlaceOrder);

	}

}
