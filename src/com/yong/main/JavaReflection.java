package com.yong.main;

import java.util.Date;

public class JavaReflection {




    public static void main(String [] args)
    {
        Employee e= new Employee("wangyong",20000,2020,2,3) ;
        Class c1=e.getClass();
        System.out.println(c1);













    }






}
