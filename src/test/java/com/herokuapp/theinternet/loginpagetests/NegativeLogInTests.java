package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLogInTests extends TestUtilities {


	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeTest(Map<String, String> testData) {
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeTest #" + no + " for " + description);

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
