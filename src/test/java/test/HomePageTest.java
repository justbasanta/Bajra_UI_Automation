package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ContactUs;
import pages.HomePage;

public class HomePageTest extends BaseClass{
	private HomePage homePage;
	private ContactUs contactUs;
	@BeforeMethod
	public void beforeMethodInitialize() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		contactUs = PageFactory.initElements(driver, ContactUs.class);
	}
	
	@Test(priority=1)
	public void checkLogo() {
		try {
			logger = report.createTest("Verify the logo");
			Assert.assertEquals(homePage.isLogoDisplayed().booleanValue(), true, "Logo is not displayed!");
		}
		catch(AssertionError e) {
			logger.fail("Exception >>>>>> " +e.getMessage());
			throw e;
		}
	}
	
	@Test(priority=2)
	public void checkContactNumber() {
		try {
			logger = report.createTest("Verify Contact Number");
			Assert.assertEquals(homePage.getContactNumber(), excel.getStringData("info", 1, 0).toString());
		}
		catch(AssertionError e) {
			logger.fail("Exception >>>>>> " +e.getMessage());
			throw e;
		}
		
	}
	
	@Test(priority=3)
	public void checkContactEmail() {
		try {
			logger = report.createTest("Verify Contact Email");
			Assert.assertEquals(homePage.getContactEmail(), excel.getStringData("info", 1, 1).toString());
		}
		catch(AssertionError e) {
			logger.fail("Exception >>>>>> " +e.getMessage());
			throw e;
		}
	}
	
	@Test(priority=4)
	public void checkPrimaryCTAButtonAction() {
		try {
			logger = report.createTest("Verify on clicking 'Let's start the conversation' opens up Contact Us Page");
			homePage.clickPrimaryCTAButton();
			Assert.assertEquals(contactUs.isContactUsHeading().booleanValue(), true, "Contact Us page is not rendered!");
		}
		catch(AssertionError e) {
			logger.fail("Exception >>>>>> " +e.getMessage());
			throw e;
		}
	}
}
