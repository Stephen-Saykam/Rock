package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class CartPage {
	
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(id = "totalp")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//button[text()='Place Order']")
	private WebElement placeOrder;
	
	@FindBy(id = "name")
	private WebElement enterName;
	
	@FindBy(id = "country")
	private WebElement enterCountry;
	
	@FindBy(id = "city")
	private WebElement enterCity;
	
	@FindBy(id = "card")
	private WebElement enterCard;
	
	@FindBy(id = "month")
	private WebElement enterMonth;
	
	@FindBy(id = "year")
	private WebElement enterYear;
	
	@FindBy(xpath = "//button[@onClick='purchaseOrder()']")
	private WebElement selectPurchage;
	
	@FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
	private WebElement successMsg;
	
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement selectOk;
	
	@FindBy(id = "logout2")
	private WebElement logout;
	
	
	public CartPage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String checkPrice() {
		return commonUtility.getText(totalPrice);
	}
	
	public void clickOnPlaceOrder() {
		commonUtility.click(placeOrder);
	}
	
	public void giveName(String input) {
		commonUtility.sendKeys(enterName, input);
	}
	
	public void giveCountry(String input) {
		commonUtility.sendKeys(enterCountry, input);
	}
	
	public void giveCity(String input) {
		commonUtility.sendKeys(enterCity, input);
	}
	
	public void giveCardDetails(int input) {
		commonUtility.sendKeys(enterCard, input);
	}
	
	public void giveMonth(int input) {
		commonUtility.sendKeys(enterMonth, input);
	}
	public void giveYear(int input) {
		commonUtility.sendKeys(enterYear, input);
	}
	
	public void clickOnPurchase() {
		commonUtility.click(selectPurchage);
	}
	
	public String getPurchaseSuccessMessage() {
		return commonUtility.getText(successMsg);
	}
	
	public boolean getPurchaseSuccess() {
		return commonUtility.isElementPresent(successMsg);
	}
	
	public void clickOnOk() {
		commonUtility.click(selectOk);
	}
	
	public void clickOnLogout() {
		commonUtility.click(logout);
	}
	
	public void purchaseDetails(String user,String country, String city, int cardNum, int month, int year) throws Throwable {
		clickOnPlaceOrder();
		giveName(user);
		giveCountry(country);
		giveCity(city);
		giveCardDetails(cardNum);
		giveMonth(month);
		giveYear(year);
		clickOnPurchase();
		Thread.sleep(2000);
		clickOnOk();
		clickOnLogout();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
