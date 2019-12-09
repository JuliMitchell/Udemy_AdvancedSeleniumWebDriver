package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLogInTests extends BaseTest {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");

		// open main page
		MainPage mainPage = new MainPage(driver, log);
		mainPage.openPage();
		log.info("Main page is opened.");

		// Click on Form Authentication link
		LoginPage loginPage = mainPage.clickFormAuthenticationLink();

		// enter username and password
		// push log in button
		loginPage.negativeLogIn(username, password);

		// Verification
		loginPage.waitForErrorMessage();
		String actualErrorMessage = loginPage.getErrorMessage();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}

}
