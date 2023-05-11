package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class SignUpPage {
	
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(id = "signin2")
	private WebElement singUp;
	
	@FindBy(id = "sign-username")
	private WebElement createUserName;
	
	@FindBy(id = "sign-password")
	private WebElement createPassword;
	
	@FindBy(xpath = "//button[@onClick='register()']")
	private WebElement signUpButton;
	
	//button[@onClick='register()']
	
	public SignUpPage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Home ']")
	private WebElement home;
	
	public void clickHome() {
		commonUtility.click(home);
	}
	
	public void clickOnSignUp() {
		commonUtility.click(singUp);
	}
	
	public void setUser(String input) {
		commonUtility.sendKeys(createUserName, input);
		
	}
	
	public void setPassword(String input) {
		commonUtility.sendKeys(createPassword, input);
		
	}
	
	public void clickOnSignUpButton() {
		commonUtility.click(signUpButton);
	}
	
	public void signUpWithCredentials(String createUserName, String createPassword) throws Throwable {
		clickHome();
		clickOnSignUp();
		setUser(createUserName);
		setPassword(createPassword);
		clickOnSignUpButton();
		Thread.sleep(2000);
		
	}
	

}
