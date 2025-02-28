package test.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.AbstractComponents.AbstractComponents;

public class CartProductsPage extends AbstractComponents {
	WebDriver driver;
	
	public CartProductsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css=".cartSection h3")
	List<WebElement> Cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement Checkbutton;
	public Boolean VerifyProductDisplay(String ProductName) {
	    // Ensure Cartproducts is populated correctly
	    List<WebElement> cartProducts = Cartproducts;
	  
	    // Check if the product name is present in the list of cart products
	    Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(ProductName));
	    
	    // Return the result (True or False)
	    return match;
	}
	
		
	
	public void Checkout() {
		Checkbutton.click();
	}
	
	


}
