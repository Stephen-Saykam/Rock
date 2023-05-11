package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class HomePage {
	
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(xpath = "//a[text()='Home ']")
	private WebElement home;
	
	@FindBy(xpath = "//a[@onClick=\"byCat('phone')\"]")
	private WebElement phones;
	
	@FindBy(xpath = "//a[text()='Iphone 6 32gb']")
	private WebElement product;
	
	@FindBy(xpath = "//a[text()='Iphone 6 32gb']//ancestor::div[@class='card-block']/h5")
	private WebElement price;
	
	
	public HomePage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnHome() {
		commonUtility.click(home);
	}
	
	public void selectPhones() {
		commonUtility.click(phones);
	}
	
	public String getPrice() {
		return commonUtility.getText(price);
	}
	
	
	public void selectProduct() {
		commonUtility.click(product);
	}
	
	public String gettProduct() {
		return commonUtility.getText(product);
	}


}
