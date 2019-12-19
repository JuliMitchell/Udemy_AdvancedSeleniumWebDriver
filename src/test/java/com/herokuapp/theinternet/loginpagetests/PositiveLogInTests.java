package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.MainPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLogInTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		// open main page
		MainPage mainPage = new MainPage(driver, log);
		mainPage.openPage();
		takeScreenshot("MainPage opened");

		// Click on Form Authentication link
		LoginPage loginPage = mainPage.clickFormAuthenticationLink();
		takeScreenshot("Secure Area Page opened");

		// enter username and password
		// push log in button
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

		sleep(3000);

		// verifications
		// new url
		Assert.assertEquals(secureAreaPage.getBrowserUrl(), secureAreaPage.getUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(),
				"logOutButton is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
		takeScreenshot("Result viewed");
	}
}
