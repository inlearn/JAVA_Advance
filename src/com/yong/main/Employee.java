package com.yong.main;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private final String name;
    private double salary;
    private Date hireday;

    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name=name;
        this.salary=salary;
        GregorianCalendar calender=new GregorianCalendar(year,month-1,day);
        this.hireday=calender.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireday() {
        return hireday;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void riseSalary(double byPercent)
    {
        double raise = this.salary*byPercent;
        this.salary+=raise;
    }

    public int compareTo(Employee e)
    {
        return Double.compare(this.salary,e.salary);
    }

    public boolean equals(Object other)
    {
        if(this==other)//如果内存地址相等
            return true;
        if(other==null)//如果other等于null不等
            return false;
        if(this.getClass()!=other.getClass())//如果类名不等，则不等
            return false;
        Employee otherObj=(Employee)other;//如果类等，把other转为Employee
        return this.getSalary() == otherObj.getSalary() && this.getName().equals(otherObj.getName())&& this.getHireday().equals(otherObj.getHireday());
        //最后return三个值是否都相等
    }

    public int hashCode()
    {
       return Objects.hash(name,salary,hireday);
    }


    public static void main(String[] args) {
        Employee employee1=new Employee("y",2000.0,20,2,20);
        Employee employee2=new Employee("y",2000.0,20,2,20);
        System.out.println(employee1.equals(employee2));
        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());
    }
}
