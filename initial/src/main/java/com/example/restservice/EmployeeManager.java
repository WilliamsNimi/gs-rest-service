package com.example.restservice;

import com.example.restservice.Employees;

public class EmployeeManager {


    private static Employees list = new Employees();
    public EmployeeManager(){
        super();
        Employee emp1 = new Employee("1", "Nimi", "Williams", "Williamson.nimi@gmail.com", "Software Architect");
        Employee emp2 = new Employee("2", "Nimi", "Williams", "Williamson.nimi@gmail.com", "Software Architect");
        Employee emp3 = new Employee("3", "Nimi", "Williams", "Williamson.nimi@gmail.com", "Software Architect");
        list.getEmployeeList().add(emp1);
        list.getEmployeeList().add(emp2);
        list.getEmployeeList().add(emp3);
    }

    public Employees getAllEmployees(){
        return list;
    }

    public void addEmployee(Employee emp){
        list.getEmployeeList().add(emp);
    }
}
    
