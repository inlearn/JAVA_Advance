package heapSortAlgorithm;

import java.util.Arrays;

public class HeapSortAlgorithm {
    private static int size;

    private static int[] createArr(int max,int num)//生成一个数组，长度随机，值随机
    {
        int []arr=new int[(int)(num*Math.random())];
        for(int i=0;i<arr.length;i++)
        {
            int temp=(int)(Math.random()*max)-(int)(Math.random()*max);//一个两个数的差值
            arr[i]=temp;
        }
        return arr;
    }
    private static void rightMethod(int [] arr)
    {
        Arrays.sort(arr);
    }


    public static void main(String []args)
    {
        int testTime=1000;
        int max=20;
        int num=10;
        boolean success=true;
        for (int i = 0; i <testTime ; i++) {

            int[]arr1=createArr(max,num);
            int[]arr2=arr1.clone();
            int[]arr3=arr1.clone();

            //bubbleSort(arr2);
            //heapSort(arr2);
            //selectSort(arr2);
            insertSort(arr2);
            rightMethod(arr3);

            if(i%500==0&&i!=0)
            {System.out.println(Arrays.toString(arr1));System.out.println(Arrays.toString(arr2));System.out.println(Arrays.toString(arr3));}

            if(!isEqual(arr2,arr3))
            {
                System.out.println(Arrays.toString(arr1));System.out.println(Arrays.toString(arr2));System.out.println(Arrays.toString(arr3));
                success=false;

                break;
            }


        }
        if(success)
            System.out.println("经过"+testTime+"次表明，所写算法正确");
        else
            System.out.println("所写算法不正确");
    }


    public static void bubbleSort(int []arr)//冒泡排序
    {
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr.length-i-1;j++)
                if(arr[j]>arr[j+1])
                {
                    swap(arr,j,j+1);
                }
    }

    public static void selectSort(int [] arr)//选择排序
    {
        for(int i=0;i<arr.length-1;i++) {
            int small = i;
            for (int j = i+1; j < arr.length; j++)
                if(arr[small]>arr[j]){//每次找最小的，记录下它的位置，第一次最小的假设在i位置
                    small=j;
                }
            if(small!=i)
                swap(arr,i,small);
        }
    }

    private static void heapSort(int[]arr)//堆排序
    {
        for(int i=0;i<arr.length;i++)//建堆
        {
            heapInsert(arr,i);
        }


        //在建好的堆里，把最大的交换到最后，size--,heapilified
        while(size>0)
        {
            swap(arr,0,--size);
            heaplified(arr,0);
            //System.out.println(size);
        }
    }


    private static void heapInsert(int[]arr,int i)
    {

        //建立最大堆的过程，num与父结点i/2值 比较，如果大于则交换，一直交换次数为logN
        while(arr[i]>arr[(i-1)/2]){
            swap(arr,i,(i-1)/2);
            i=(i-1)/2;
        }
       // System.out.println(Arrays.toString(arr));
        size++;
    }

    private static void heaplified(int[]arr,int i)
    {
        //将先找到index左右孩子的大值，再与index处的值比较，将较大值换上来
        //左孩子 2*i+1  左孩子2*i+2
        while(2*i+1<size){

        int left=2*i+1;
        int larger=left+1<size&&arr[left]<arr[left+1]?left+1:left;

        if(arr[i]<arr[larger])
        {
            swap(arr,i,larger);
            i=larger;
        }
        else break;//如果i位置不小于左右孩子，退出循环
          //System.out.println(Arrays.toString(arr));
        }
    }

    //插入排序
    public static void insertSort(int[] arr)
    {
        //把第一个数看成一个递增序列，将其它的数插入，

        for (int i = 1; i <arr.length ; i++) {
            int current=arr[i];//当前要插入的值，从1开始
            int j=i-1;//j是i前面的一个数
            while(j>=0&&arr[j]>current)//如果j>=0，j比要插入的数大，把此位置的数移动到后面，向前比较
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=current;//找到要插入的位置j+1，把current插入
        }
    }





    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private static boolean isEqual(int []arr1,int[]arr2)//判断两个数组是否相等
    {
        if(arr1==null&&arr2!=null||arr1!=null&&arr2==null)
            return false;
        if(arr1==null&&arr2==null)
            return true;
        if(arr1.length!=arr2.length)
            return false;
        for (int i = 0; i <arr1.length ; i++) {
            if(arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }

}
