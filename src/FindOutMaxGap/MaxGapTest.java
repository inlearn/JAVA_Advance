package FindOutMaxGap;

import java.util.Arrays;

/**
 * 给一个数组，找出如果它排序之后的相邻两数的最大值
 * 桶排序的概念
 */

public class MaxGapTest {
    public static void main(String [] args)
    {
        int[]arr={98,4,3,3,4};

        System.out.println(getGap(arr));
    }

    private static int getGap(int []arr)
    {
        //如果数组为空或者长度小于2返回0
        if(arr==null||arr.length<2)
            return 0;


        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        //1.找到整个数组的最大，最小
        for (int i = 0; i <arr.length ; i++) {
            min=min>arr[i]?arr[i]:min;
            max=max<arr[i]?arr[i]:max;
        }


        boolean []hasNum=new boolean[arr.length+1];
        int []maxes=new int[arr.length+1];
        int[]mins=new int[arr.length+1];
        //2.把每个数划分到桶
        for (int i = 0; i <arr.length ; i++) {

            int index=getBucket(arr,min,max,arr[i]);
            maxes[index]=hasNum[index]? Math.max(maxes[index],arr[i]):arr[i];
            mins[index]=hasNum[index]?Math.min(mins[index],arr[i]):arr[i];
            hasNum[index]=true;

        }
        System.out.println(Arrays.toString(hasNum));
        System.out.println(Arrays.toString(maxes));
        System.out.println(Arrays.toString(mins));
        //3.找到一个桶中最小的数，与前一个非空桶最大数差值的最大值，即为最大差值
        int res=0;
        int lastMax=maxes[0];
        for (int i = 1; i <arr.length+1 ; i++) {

        if (hasNum[i])
        {
            res=Math.max(res,mins[i]-lastMax);//如果i有数，计算和上一个最大值的差，如果较大则收
            lastMax=maxes[i];//lastMax更新为当前的
        }
        }
        return res;


    }


    private static int getBucket(int []arr,int min,int max,int num)
    {
        return (int)(num-min)/(max-min)*(arr.length);
    }
}

