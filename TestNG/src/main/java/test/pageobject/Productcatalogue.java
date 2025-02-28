package test.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import test.AbstractComponents.AbstractComponents;

public class Productcatalogue extends AbstractComponents{
	WebDriver driver;
	public Productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart =By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	//get product list
	public List<WebElement> productList() 
	{
		waitForElementToAppear(productsBy);
		return products;
		
	}
	public WebElement getProductByName(String ProductName) 
	{
		WebElement prod =productList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		
		return prod;
	}
	 
	public void addProductToCart(String ProductName) {
		WebElement prod=getProductByName(ProductName);
		if (prod == null) {
	        throw new RuntimeException("Product not found: " + ProductName);//In getProductByName(), the product list retrieval might return null if the product is not found.
		}
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	
		
		
	}

}
