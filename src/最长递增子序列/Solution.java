package 最长递增子序列;

import java.util.Arrays;

/**
 * 从一个数组中找到最长的递增子序列的长度
 * 如{1，4，3，2，6，5}
 * 最长为{1，4，6}为3
 * 或者{1，3，5}为3
 * 等
 */

public class Solution {
    public static void main(String[] args) {
        int []arr={1,4,3,2,6,5};
        System.out.println(lenOfList(arr));
    }


    public static int lenOfList(int []arr)
    {
        int []dp=new int [arr.length];
        for (int i = 0; i <arr.length ; i++) {
            dp[i]=1;
        }
        int tmax=1;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if(arr[i]>arr[j])
                    dp[i]=max(1,dp[j]+1);
            }
        }

        System.out.println(Arrays.toString(dp));
        for (int i = 0; i <arr.length ; i++) {
            tmax=tmax>dp[i]?tmax:dp[i];
        }
        return tmax;
    }

    public  static int max(int num1,int num2)
    {
        return num1<num2?num2:num1;
    }




}
