package test.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import test.AbstractComponents.AbstractComponents;

public class PlaceOrderpage extends AbstractComponents {
WebDriver driver;
	
	public PlaceOrderpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	By serachAppear=By.cssSelector(".ta-results");
	
	@FindBy(css=".ta-item:nth-child(3)")
	WebElement searchclick;
	
	@FindBy(css=".btnn.action__submit")
	WebElement placeOrder;
	

	public void placeOrder(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(serachAppear);
		searchclick.click();
		
		
	}
	
		
		public void Submit() 
		{
			placeOrder.click();
			
		}
		
		
	
		
	
		
		
	}
