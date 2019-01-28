package testng_prac;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Param
{
			
	@Test
	@Parameters("Username")
    public void parameterTest(String myName)
	{
    System.out.println("Parameterized value is : " + myName);
    }
	@Test
	public void Testcase3()
	{
		System.out.println("Testcase3");
	}
	
	
	@DataProvider(name = "Data")
	public static Object[][] DataProviderData()
	{
		return new Object[][] {{2, true}, {6, false}};
	}
	
	@Test(dataProvider = "Data")
	public void DataProviderTest(int value, boolean result)
	{
		System.out.println("Value is "+value+" Result is "+result);
	}
	
	@DataProvider(name = "newObject")
	public static Object[][] DataProviderObjectData()
	{
		return new Object[][] {{new DataProviderObject(32, 0)}};
	}
	
	@Test(dataProvider = "newObject")
	public void DataProviderObjectTest(DataProviderObject myparam)
	{
		System.out.println("Age is "+myparam.getage()+"Sal is "+myparam.getsal());
	}
	
	
}
