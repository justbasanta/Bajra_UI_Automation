package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navbar{
	WebDriver driver;
	
	private By navHome = By.xpath("//div[@id='top_menu_collapse']//li/a/span[text()='Home']");
	private By navAboutUs = By.xpath("//div[@id='top_menu_collapse']//li/a/span[text()='About Us']");
	private By navWork = By.xpath("//div[@id='top_menu_collapse']//li/a/span[text()='Work']");
	private By navCareers = By.xpath("//div[@id='top_menu_collapse']//li/a/span[text()='Careers']");
	private By navContactUs = By.xpath("//div[@id='top_menu_collapse']//li/a/span[text()='Contact Us']");
	
	public Navbar(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getNavHome() {
		driver.findElement(navHome).click();
	}
	public void getNavAboutUs() {
		driver.findElement(navAboutUs).click();
	}
	public void getNavWork() {
		driver.findElement(navWork).click();
	}
	public void getNavCareers() {
		driver.findElement(navCareers).click();
	}
	public void getNavContactUs() {
		driver.findElement(navContactUs).click();
	}
}
