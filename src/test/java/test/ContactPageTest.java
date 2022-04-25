package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ContactUs;
import pages.Navbar;

public class ContactPageTest extends BaseClass{
	private ContactUs contactUs;
	private Navbar navbar;
	
	@BeforeMethod
	public void beforeMethodInitialize() {
		contactUs = PageFactory.initElements(driver, ContactUs.class);
		navbar = PageFactory.initElements(driver, Navbar.class);
	}
	
	@Test(priority=1)
	public void verifyContactUsPage() {
		try {
			logger = report.createTest("Verify Contact Us page");
			navbar.getNavContactUs();
			Assert.assertEquals(contactUs.isContactUsHeading().booleanValue(), true, "Contact Us Page is not displayed!");
		}
		catch(AssertionError e) {
			logger.fail("Exception >>>>>> " +e.getMessage());
			throw e;
		}
	}
	
	@Test(priority=2)
	public void verifyMessageFormWithIncorrectDetails() {
		try {
			logger = report.createTest("Verify without filling mandatory fields");
			contactUs.setMessageForm("", "", "", "", "");
			Assert.assertEquals(contactUs.isErrorAlertMessage().booleanValue(), true,"Error message not seen!!");
		}
		catch(AssertionError e) {
			logger.fail("Exception >>>>>> " +e.getMessage());
			throw e;
		}
	}
	@Test(priority=3)
	public void verifyMessageFormWithCorrectDetails() {
		try {
			logger = report.createTest("Verify filling all mandatory fields");
			contactUs.setMessageForm(
					"Test", "984100000", "bajratest@getnada.com", "Test Subject", "This is a test!!!"
					);
			Assert.assertEquals(contactUs.isThankYouText().booleanValue(), true,"Thank You message not seen !");
		}
		catch(AssertionError e) {
			logger.fail("Exception >>>>>> " +e.getMessage());
			throw e;
		}
	}
}
