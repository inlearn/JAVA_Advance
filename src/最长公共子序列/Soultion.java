package 最长公共子序列;

import java.util.Arrays;

public class Soultion {
    public static void main(String[] args) {
        char []str1=new char[]{'a','b','c','d'};
//        char []str2=new char[]{'a','b','c','d'};
        char []str2=new char[]{'c','x','b','y','d','z'};



        System.out.println(longestCommon(str1,str2));
    }


    public static int longestCommon(char []str1,char[]str2)
    {
        //从0开始
        int m=str1.length,n=str2.length;
        int [][]dp=new int[m][n];//建一个数组，存着str1的前i个字符组成的串与str2的前j个字符组成的串的最长子串
        //求以str1的0号与str2的dp组的值,str1为行，str2为列
        for (int j = 0; j <n ; j++) {
            dp[0][j]=str1[0]==str2[j]?1:0;
        }
        //求以str2的0号与str1的dp组的值
        for(int i=0;i<m;i++)
            dp[i][0]=str1[i]==str2[0]?1:0;

        /*递推公式，如果str1[i]==str2[j],dp[i][j]=dp[i-1][j-1]+1
        如果str1[i]!=str2[j],dp[i][j]=max(dp[i][j-1],dp[i-1][j])
        */
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n; j++) {

                dp[i][j]=str1[i]==str2[j]?dp[i-1][j-1]+1:max(dp[i-1][j],dp[i][j-1]);

            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[m-1][n-1];
    }

    public static int max(int num1,int num2)
    {
        return num1>num2?num1:num2;
    }
}
