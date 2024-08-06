package com.example.restservice;


public class Employee {

    public Employee(String employee_id, String first_name, String last_name, String email, String title){
        super();
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
    }

    private String employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;

    public void setEmployeeID(String employee_id){
        this.employee_id = employee_id;
    }
    public String getEmployeeID(){
        return this.employee_id;
    }
    public void setFirstName(String first_name){
        this.first_name = first_name;
    }
    public String getFirstName(){
        return this.first_name;
    }
    public void setLastName(String last_name){
        this.last_name = last_name;
    }
    public String getLastName(){
        return this.last_name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String title(){
        return this.title;
    }
}
