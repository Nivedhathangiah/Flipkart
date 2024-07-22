package com.flipkart.pagemanager;

import com.flipkart.pages.LogoutPage;
import com.flipkart.pages.ProductPurchasePage;
import com.flipkart.pages.ProductSearchPage;
import com.flipkart.pages.UserLoginPage;
import com.flipkart.pages.UserRegistrationPage;

public class PageObjectManager {

	private UserRegistrationPage userRegistrationPage;
	private UserLoginPage userLoginPage;
	private ProductSearchPage productSearchPage;
	private ProductPurchasePage purchasePage;
	private LogoutPage logoutPage;

	public UserRegistrationPage getUserRegistrationPage() {
		return (userRegistrationPage == null) ? userRegistrationPage = new UserRegistrationPage()
				: userRegistrationPage;
	}

	public UserLoginPage getUserLoginPage() {
		return (userLoginPage == null) ? userLoginPage = new UserLoginPage() : userLoginPage;
	}

	public ProductSearchPage getProductSearchPage() {
		return (productSearchPage == null) ? productSearchPage = new ProductSearchPage() : productSearchPage;
	}

	public ProductPurchasePage getPurchasePage() {
		return (purchasePage == null) ? purchasePage = new ProductPurchasePage() : purchasePage;
	}

	public LogoutPage getLogoutPage() {

		return (logoutPage == null) ? logoutPage = new LogoutPage() : logoutPage;
	}

}
