package com.security.rest.dao;

import com.security.rest.model.Employee;
import com.security.rest.model.Employees;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO 
{
    private static Employees list = new Employees();
    
    static 
    {
        list.getEmployeeList().add(new Employee(1, "vk", "05", "vk@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "ale", "solemone", "ale@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "rahul", "dravid", "rd@gmail.com"));
    }
    
    public Employees getAllEmployees() 
    {
        return list;
    }
    
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
