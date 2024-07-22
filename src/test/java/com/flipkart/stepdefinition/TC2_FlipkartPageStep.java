package com.flipkart.stepdefinition;

import org.junit.Assert;

import com.flipkart.pagemanager.PageObjectManager;
import com.utility.BaseClass;

import cucumber.api.java.en.*;

public class TC2_FlipkartPageStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@When("User login with phone number {string}")
	public void user_login_with_phone_number(String mobileNo) {
		pom.getUserRegistrationPage().navigateRegisterPage();
		pom.getUserLoginPage().login(mobileNo);

	}

	@When("User seach product {string}")
	public void user_seach_product(String productName) {
		pom.getProductSearchPage().searchProduct(productName);

	}

	@Then("User should verify same product listed in the search option  {string}")
	public void user_should_verify_same_product_listed_in_the_search_option(String expProductSearchMsg) {
		Assert.assertTrue("Verify Product search Msg",
				pom.getProductSearchPage().getSearchSuccessMsgText().contains(expProductSearchMsg));
	}

	@When("User add the product into cart")
	public void user_add_the_product_into_cart() {
		pom.getProductSearchPage().addProductIntoCart();
	}

	@When("User add the delivery address {string},{string},{string},{string},{string} and {string}")
	public void user_add_the_delivery_address_and(String name, String mobileNo, String pinCode, String locality,
			String address, String addressType) {
		pom.getPurchasePage().addDeliveryAddress(name, mobileNo, pinCode, locality, address, addressType);
	}

	@When("User enter the order confirmation details {string}")
	public void user_enter_the_order_confirmation_details(String emailId) {
	pom.getPurchasePage().addEmailDetails(emailId);
	}

	@When("User enter the payment details {string},{string},{string} and {string}")
	public void user_enter_the_payment_details_and(String cardNo, String expMonth, String expYear, String cvv) {
	//	pom.getPurchasePage().addPayment(cardNo, expMonth, expYear, cvv);
	}

	@When("User logout from the application")
	public void user_logout_from_the_application() {
		pom.getLogoutPage().clickLogoFlipkart();
		pom.getLogoutPage().logOut();

	}

	@Then("User should verify {string} text to check if user is  successfully logout")
	public void user_should_verify_text_to_check_if_user_is_successfully_logout(String expectedMsg) {
		String actualLoginMsgText = pom.getUserRegistrationPage().getLoginMsgText();
		Assert.assertEquals("Verify user logout successfully", expectedMsg, actualLoginMsgText);

	}
}
