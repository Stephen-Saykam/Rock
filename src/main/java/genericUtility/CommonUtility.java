package genericUtility;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	
	WebDriverWait wait = null;
	public WebDriver webDriver;
	
	public CommonUtility(WebDriver driver) {
		if((driver != null)) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10l));
			webDriver = driver;
		}
	}
	
	public void selectByVisibleText(WebElement element, String vistext) {
		Select s = new Select(element);
		s.selectByVisibleText(vistext);
	}
	public void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	public void selectByIndex(WebElement element, int num) {
		Select s = new Select(element);
		s.selectByIndex(num);
	}
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20l));
	}
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20l));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions ac= new Actions(driver);
		ac.contextClick(element).perform();
	}
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextOnPopUp(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void sendKeys(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendKeys(WebElement element, int value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(String.valueOf(value));
	}
	
	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	public boolean isElementPresent(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}catch (TimeoutException e) {
			return false;
		}
	}
	
	
	
	
	

}
