package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage{
	WebDriver driver;
	
	private By logo = By.xpath("//*[@id=\"top\"]//a[@class='navbar-brand logo']/span/img");
	private By primaryCTAButton = By.xpath("//a[@class='convolink']");
	private By secondaryCTAButton = By.xpath("//small[@class='orCheck_text']");
	private By contactNumber = By.xpath("//*[@id='wrap']/section[7]/div/div/div[3]/div[1]/span[2]/font[1]");
	private By contactEmail = By.xpath("//*[@id='wrap']/section[7]/div/div/div[3]/div[2]/span[2]/font[1]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Boolean isLogoDisplayed() {
		return driver.findElement(logo).isDisplayed();
	}
	
	public WebElement getPrimaryCTAButton() {
		return driver.findElement(primaryCTAButton);
	}
	
	public WebElement getSecondaryCTAButton() {
		return driver.findElement(secondaryCTAButton);
	}
	
	public String getContactNumber() {
		return driver.findElement(contactNumber).getText().trim();
	}
	public String getContactEmail() {
		return driver.findElement(contactEmail).getText().trim();
	}
	
	public void clickPrimaryCTAButton() {
		this.getPrimaryCTAButton().click();
	}
	
	public void clickSecondaryCTAButton() {
		this.getSecondaryCTAButton().click();
	}
}
