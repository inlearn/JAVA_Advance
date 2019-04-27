package 递归__左视频;

import java.util.Arrays;

public class maxtest {

    public static int getMax1(int[] arr)
    {
        if(arr.length<2)
            return arr[0];
        int[]subarr= Arrays.copyOfRange(arr,1,arr.length);
        return arr[0]>getMax1(subarr)?arr[0]:getMax1(subarr);
    }
    public static int getMax(int[]arr,int l,int r)
    {
        if(l==r)
            return arr[l];
        int mid=(l+r)/2;

       int leftMax= getMax(arr,l,mid);
       int rightMax=getMax(arr,mid+1,r);
       return Math.max(leftMax,rightMax);
    }



    public static void main(String []args)
    {
        int []arr={4,5,2,3};
        System.out.println( getMax(arr,0,arr.length-1));


    }


}
