package 快排中的partition;

import java.util.Arrays;

//把数组a中小于等于num的放左边，大于num的放右边
public class QuickSortPartition {

    public static void partition(int []a,int num)
    {
        int low=-1;//小于等于num的范围
        for(int current=0;current<a.length;current++)
        {
            if(a[current]<=num)//如果当前的数小于等于num
            {//将当前数与low的下一个数交换，low的范围自增
                if(low!=current)
                {
                    int temp = a[low + 1];
                    a[low + 1] = a[current];
                    a[current] = temp;
                }
                low++;
            }
        }
    }

    public static void main(String []args)
    {
        int []arr={2,3,6,31,8,2};
        int num=4;
        partition(arr,num);

        System.out.println(Arrays.toString(arr));
    }




}

