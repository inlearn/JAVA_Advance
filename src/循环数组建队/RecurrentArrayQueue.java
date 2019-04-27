package 循环数组建队;

import java.util.Arrays;

public class RecurrentArrayQueue {
    public static void main(String []args)
    {
        MyQueue q1=new MyQueue(8);
        q1.push(9);q1.push(9);q1.push(9);
        System.out.println(q1.pop());
    }




}
class MyQueue
{
    private int len;//数组长度
    private int []array;
    public MyQueue(int len) {
        if(len<0)
            throw new IllegalArgumentException("长度必须大于等于0");
        this.len = len;
        array=new int[len];
    }
    //建立一个数组

    //建立一个头指针，一个尾指针，开始时相等为0;
   private int front=0;
   private int tail=0;
   private int size=0;




    //增加一个队尾
    public void push(int num)
    {
        if(size<len)
        {
            //System.out.println("本来是一个exception,一会再写");
            //System.out.println(Arrays.toString(array));
            array[tail]=num;
            tail=tail+1<len?tail+1:0;
            size++;
        }
        else throw new ArrayIndexOutOfBoundsException("数太多，存不下了");
    }



    //删除队头,返回队头
    public int pop()
    {
        if(size>0)
        {
                size--;
                int frontnum=array[front];
                front=front+1>len?front+1:0;
            //System.out.println(Arrays.toString(array));
                return frontnum;
        }
        else return 0;

    }




        //是否空
    public boolean isEmpty()
    {
        return size>0;
    }

}