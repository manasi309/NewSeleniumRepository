package test.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PS {
	public void doThis()
	{
		System.out.println("I am here");
	}
	@BeforeTest
	public void before() {
		System.out.println("I am first");
	}
	@AfterTest()
	public void after(){
		System.out.println("I am last");
	}
	{
		
	}
	

}
