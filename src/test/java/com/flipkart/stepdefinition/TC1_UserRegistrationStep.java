package com.flipkart.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.flipkart.pagemanager.PageObjectManager;
import com.utility.BaseClass;

import cucumber.api.java.en.*;

public class TC1_UserRegistrationStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the flipkart page")
	public void user_is_on_the_flipkart_page() throws FileNotFoundException, IOException {
		browserLaunch(getPropertyFileValue("browser"));
		loadURL(getPropertyFileValue("url"));
		maximize();
		implicitWait();
	}

	@When("User navigate to flipkart registration page")
	public void user_navigate_to_flipkart_registration_page() {
		pom.getUserRegistrationPage().navigateRegisterPage();
	}

	@When("User enters phone number {string} to register")
	public void user_enters_phone_number_to_register(String mobileNo) {
		pom.getUserRegistrationPage().registration(mobileNo);
	}

	@Then("User should verify after navigate to home page and verify My account is present in the catalog {string}")
	public void user_should_verify_after_navigate_to_home_page_and_verify_My_account_is_present_in_the_catalog(
			String expAccountMSg) {
		Assert.assertEquals("Verify after Register", expAccountMSg, pom.getUserRegistrationPage().getAccountMsgText());
	}

}
