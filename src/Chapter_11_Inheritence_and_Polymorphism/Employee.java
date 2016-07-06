package Chapter_11_Inheritence_and_Polymorphism;
import Chapter_10_Object_Oriented_Thinking.MyDate;

public class Employee extends Person
{
	private String office;
	private double salary;
	private String dateHired;
	static private MyDate date = new MyDate();
	
	public Employee()
	{
		this ("Bensonhurst", 80000, (date.getMonth() + "/" + date.getDay() + "/" + date.getYear()));
	}
	
	public Employee(String office, double salary, String dateHired)
	{
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}
	
	public String toString()
	{
		return (getName() + " " + getOffice());
	}
	
	public String getOffice()
	{
		return office;
	}
	
	public void setOffice(String office)
	{
		this.office = office;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public String getDateHired()
	{
		return dateHired;
	}
	
	public void setDateHired(String dateHired)
	{
		this.dateHired = dateHired;
	}
}
