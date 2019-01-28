package testng_prac;

public class DataProviderObject
{
	private int age;
	private int sal;
	
	public DataProviderObject(int age, int sal)
	{
		this.age = age;
		this.sal = sal;
	}
	public void setage(int age)
	{
		this.age = age;
	}
	public int getage()
	{
		return age;
	}
	public void setsal(int sal)
	{
		this.sal = sal;
	}
	public int getsal()
	{
		return sal;
	}
	
}
