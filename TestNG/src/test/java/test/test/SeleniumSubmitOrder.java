package test.test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import test.TestComponents.BaseTest;
import test.pageobject.CartProductsPage;
import test.pageobject.ConfirmationPage;
import test.pageobject.Landingpage;
import test.pageobject.PlaceOrderpage;
import test.pageobject.Productcatalogue;


public class SeleniumSubmitOrder extends BaseTest {



	@Test
	public void SeleniumSubmitOrder() throws IOException
	{
		WebDriver driver = initializeDriver(); 
		
		String ProductName="ZARA COAT 3";
		landingpage.loginApplication("utale@gmail.com", "Abcxyz@1");
		
		Productcatalogue productcatalogue=new Productcatalogue(driver);
		List<WebElement> products =productcatalogue.productList();
		productcatalogue.addProductToCart(ProductName);
		productcatalogue.clickCart();
		
		CartProductsPage cartproduct=new CartProductsPage(driver);
		cartproduct.VerifyProductDisplay(ProductName);  // Verify product in the cart
        cartproduct.Checkout();
		//Assert.assertTrue(match);
		
		PlaceOrderpage placeorderpage=new PlaceOrderpage(driver);
		placeorderpage.placeOrder("India");
		placeorderpage.Submit();
		ConfirmationPage confirmationpage =new ConfirmationPage(driver);
		String confirmationmessage=confirmationpage.confirmationPage();
		Assert.assertTrue(confirmationmessage.equalsIgnoreCase("Thankyou for the order."));
		
		//Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
		
		
		
		//actions class
		
		

	}

}