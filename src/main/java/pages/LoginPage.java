package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class LoginPage {
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(id = "login2")
	private WebElement login;
	
	@FindBy(id = "loginusername")
	private WebElement enterUser;
	
	@FindBy(id = "loginpassword")
	private WebElement enterPassword;
	
	@FindBy(xpath = "//button[@onClick='logIn()']")
	private WebElement loginButton;
	
	@FindBy(id = "nameofuser")
	private WebElement userAccount;
	
	
	
	public LoginPage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogin() {
		commonUtility.click(login);
	}
	
	public void setUser(String input) {
		commonUtility.sendKeys(enterUser, input);
	}
	
	public void setPassword(String input) {
		commonUtility.sendKeys(enterPassword, input);
	}
	
	public void clickLoginButton() {
		commonUtility.click(loginButton);
	}
	
	public String getUserAccount() {
		return commonUtility.getText(userAccount);
	}
	
	public void clickToLogin(String enterUser, String enterPassword ) {
		clickOnLogin();
		setUser(enterUser);
		setPassword(enterPassword);
		clickLoginButton();
	}

}
