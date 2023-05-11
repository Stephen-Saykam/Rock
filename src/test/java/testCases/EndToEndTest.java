package testCases;

import genericUtility.BaseClass;
import genericUtility.CommonUtility;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailspage;
import pages.SignUpPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.TestData;

public class EndToEndTest extends BaseClass {
	
	@Test
	public void demoTest() throws Throwable {
		SignUpPage signUpPage = new SignUpPage(driver);
		TestData testData = new TestData();
		CommonUtility commonUtility = new CommonUtility(driver);
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		ProductDetailspage productDetailsPage = new ProductDetailspage(driver);
		CartPage cartPage = new CartPage(driver);
		
		String user=testData.generateRandomUser();
		String password = testData.generateRandomPassword();
		
		signUpPage.signUpWithCredentials(user, password);		
		String successText = commonUtility.getTextOnPopUp(driver);
		System.out.println("Message on POPUP: "+successText);
		commonUtility.acceptAlert(driver);
		
		loginPage.clickToLogin(user, password);
		String accountOwner = loginPage.getUserAccount();
		System.out.println(accountOwner);
		Assert.assertTrue(accountOwner.contains(loginPage.getUserAccount()));
		
		homePage.clickOnHome();
		homePage.selectPhones();
		String product = homePage.gettProduct();
		String price = homePage.getPrice();
		
		homePage.selectProduct();
		Assert.assertEquals(productDetailsPage.getProductDetail(),product);
		Assert.assertTrue(productDetailsPage.getPriceDetail().contains(price));
		Assert.assertTrue(productDetailsPage.addtoCartVisible());
		productDetailsPage.clickAddToCart();
		String productAdded = commonUtility.getTextOnPopUp(driver);
		System.out.println("producted Added Msg: "+productAdded);
		commonUtility.acceptAlert(driver);
		productDetailsPage.clickOnCart();
		if(price.contains(cartPage.checkPrice())) {
			System.out.println("Price of single Product: "+cartPage.checkPrice());
		}else {
			Assert.fail();
		}
		
//		Assert.assertTrue(cartPage.checkPrice().contains(price));
		
		cartPage.purchaseDetails(user, "India", "Hyderabad", 123456789, 10, 2026);
		System.out.println("Success Message: "+cartPage.getPurchaseSuccessMessage());
		Assert.assertTrue(cartPage.getPurchaseSuccess());
		
		
	}

}
