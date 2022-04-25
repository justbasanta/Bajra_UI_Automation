package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs {

	WebDriver driver;
	
	private By contactUsHeading = By.xpath("//h1[text()='Contact Us']");
	
	//form items
	private By yourName = By.name("Your Name");
	private By phoneNumber = By.name("Phone Number");
	private By email = By.name("email_from");
	private By subject = By.name("subject");
	private By yourQuestion = By.name("Your Question");
	private By submitButton = By.xpath("//a[@role='button']");
			
	private By errorAlertMessage = By.xpath("//*[@id='o_website_form_result']/i[@title='Error']");
	private By thankYouText = By.xpath("//span[text()='Thank You!']");
	public ContactUs(WebDriver driver) {
		this.driver = driver;
	}
	
	public Boolean isContactUsHeading() {
		return driver.findElement(contactUsHeading).isDisplayed();
	}
	
	public Boolean isThankYouText() {
		return driver.findElement(thankYouText).isDisplayed();
	}
	
	public void setMessageForm(
			String m_name, String m_phone, String m_email, String m_subject, String m_yourQuestion
			) {
		driver.findElement(yourName).sendKeys(m_name);
		driver.findElement(phoneNumber).sendKeys(m_phone);
		driver.findElement(email).sendKeys(m_email);
		driver.findElement(subject).sendKeys(m_subject);
		driver.findElement(yourQuestion).sendKeys(m_yourQuestion);
		driver.findElement(submitButton).click();
	}
	
	public Boolean isErrorAlertMessage() {
		return driver.findElement(errorAlertMessage).isDisplayed();
	}
}
