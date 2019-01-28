package testng_prac;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_annotations
{
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("In the beforeSuite");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("In the afterSuite");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("In the beforeTest");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("In the afterTest");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("In the beforeClass");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("In the afterClass");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("In the beforeMethod");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("In the afterMethod");
	}
	
	@Test
	public void testcase1()
	{
		System.out.println("In the TestCase1");
	}
	@Test
	public void testcase2()
	{
		System.out.println("In the TestCase2");
	}
	
}
