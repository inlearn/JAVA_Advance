package com.yong.main;

public class Manager extends Employee {
    private double bonus;
    public Manager(String name,double salary,int year,int month,int day,double bonus)
    {
        super(name,salary,year,month-1,day);
        this.bonus=0;
    }

    public double getSalary()
    {
        double baseSalary=super.getSalary();
        return baseSalary+this.bonus;
    }

    public void setBonus(double bonus)
    {
        this.bonus=bonus;
    }
}
