package com.yong.main;

import java.util.*;

public class EmployeeTestComparable{
   public static void main(String [] args){
        Employee []staff=new Employee[3];
        staff[0]=new Employee("wangYong",100,20,2,13);
        staff[1]=new Employee("zhanSanFeng",1000,2020,3,12);
        staff[2]=new Employee("LuiXiang",998,2020,3,13);


        Arrays.sort(staff);

        for(Employee e:staff)
        {
            System.out.println(e.getName()+"的工资是:"+e.getSalary());
        }


    }





}
