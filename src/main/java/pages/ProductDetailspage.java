package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.CommonUtility;

public class ProductDetailspage {
	
	WebDriver driver;
	CommonUtility commonUtility;
	
	@FindBy(xpath = "//h2[text()='Iphone 6 32gb']")
	private WebElement myProduct;
	
	@FindBy(xpath = "//h2[text()='Iphone 6 32gb']/ancestor::div[@id='tbodyid']/h3")
	private WebElement myProductPrice;
	
	
	@FindBy(xpath = "//a[text()='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(id = "cartur")
	private WebElement cartMenu;
	
	
	
	public ProductDetailspage(WebDriver driver) {
		commonUtility = new CommonUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getProductDetail() {
		return commonUtility.getText(myProduct);
	}
	
	public String getPriceDetail() {
		return commonUtility.getText(myProductPrice);
	}
	
	public boolean addtoCartVisible() {
		return commonUtility.isElementPresent(addToCart);
	}
	
	public void clickAddToCart() throws Throwable {
		commonUtility.click(addToCart);
		Thread.sleep(2000);
	}
	
	public void clickOnCart() {
		commonUtility.click(cartMenu);
	}
	

}
