package com.company.Director;
import com.company.Sotrudniki.Programmer;
import com.company.lIST.EmployeesManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.company.Sotrudniki.Sotrudniki;

public class Director {

    private class His_Car
    {
        ////////////////
    }

    private static Director director;

    public static Director getDirector()
    {
        if(director == null) director = new Director();
        return director;
    }

    public int getEmployeesCount(EmployeesManager manager)
    {
        return manager.getEmployeeList().size();
    }

    public void sortEmployeers(EmployeesManager manager)
    {
        Collections.sort(manager.getEmployeeList(),manager);
    }

    public Director() { }


}
