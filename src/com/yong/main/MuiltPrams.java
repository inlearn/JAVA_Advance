package com.yong.main;

public class MuiltPrams {


    private static double max(double ... values)
    {
        double largest=Double.MIN_VALUE;
        for(double v:values)
            if(v>largest)
                largest=v;
        return largest;
    }
    public static void main(String [] args)
    {
        double max_num=max(3,1,40.4,-5);
        System.out.println(Double.toString(max_num));
    }



}
