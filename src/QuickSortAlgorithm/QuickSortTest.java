package QuickSortAlgorithm;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr1 = new int[]{9,8,7,4,3,2,2,5,6,7};

//        int[] result = partition(arr1, 0, arr1.length - 1);
////        System.out.println(Arrays.toString(result));
////        System.out.println(Arrays.toString(arr1));
        quickSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);//将最后一个数与数组随机位置的数交换
            int[] p = partition(arr, left, right);//找到等于中间数的范围
            quickSort(arr, left, p[0] - 1);//排序前半部分
            quickSort(arr, p[1] + 1, right);//排序后半部分
        }
    }


    private static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right + 1;
        int current = left;
        while (current < more) {
            if (arr[current] < arr[right]) {
                swap(arr, current, less + 1);
                current++;
                less++;
            } else if (arr[current] > arr[right]) {
                swap(arr, current, more - 1);
                more--;
            } else {
                current++;
            }
        }
        //swap(arr,more,right);
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}



