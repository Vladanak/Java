package com.company.lIST;
import com.company.Sotrudniki.Sotrudniki;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeesManager implements Comparator<Sotrudniki>
{
	List<Sotrudniki> employeeList;

	public EmployeesManager()
	{
		employeeList = new ArrayList<Sotrudniki>();
	}

	private EmployeesManager(List<Sotrudniki> employeeList)
	{
		this.employeeList = employeeList;
	}

	public List<Sotrudniki> getEmployeeList()
	{
		return employeeList;
	}

	public void setEmployeeList(List<Sotrudniki> employeeList)
	{
		this.employeeList = employeeList;
	}

	public boolean add(Sotrudniki employee)
	{
		this.employeeList.add(employee);
		return true;
	}

	public boolean remove(Sotrudniki employee)
	{
		this.employeeList.remove(employee);
		return true;
	}

	public void printEmployees()
	{
		for (Sotrudniki employee : employeeList)
		{
			Sotrudniki.getLOG().info(employee.toString());
		}
	}

	@Override
	public int compare(Sotrudniki o1, Sotrudniki o2)
	{
		if(o1.GetZarplata() == o2.GetZarplata()) return 0;
		else if(o1.GetZarplata() > o2.GetZarplata()) return 1;
		else return -1;
	}
}
