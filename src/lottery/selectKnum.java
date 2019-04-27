package lottery;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 从n个数中，抽取k个不同的数，并把抽取的数排序后以数组的形式打印
 */


public class selectKnum {

    public static void main(String [] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入最大的数");
            int n = in.nextInt();

            System.out.println("请输入抽几个数");
            int k = in.nextInt();

            if (k > n)
                System.exit(0);
            //定义一个数组，初始化为1-n;
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }

            //定义一个数组存放k个数
            int[] result = new int[k];

            //随机取一个下标
            for (int i = 0; i < k; i++, n--) {
                int index = (int) (n * Math.random());
                result[i] = arr[index];
                arr[index] = arr[n - 1];
            }


            System.out.println(Arrays.toString(result));

            Arrays.sort(result);

            System.out.println(Arrays.toString(result));
        }

    }
}
