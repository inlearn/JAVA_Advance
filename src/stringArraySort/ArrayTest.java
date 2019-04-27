package stringArraySort;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Arr implements Comparator<String>//这个类实现Comparator接口
{
    public int compare(String a,String b)
    {
        return a.length()-b.length();//实现comparator接口中的compare方法
    }
}




public class ArrayTest {

    public static void main(String [] args)
    {
        String [] stringArr={"Bob","Alice","John"};//字符串数组
        Arr arrSort=new Arr();//新建一个实现Comparator的类的接口
        Arrays.sort(stringArr,arrSort);//排序：数组名，上面的类名
    for(String content:stringArr)
        System.out.println(content);
    System.out.println(Arrays.toString(stringArr));//用Arrays的toSting方法可以方便的将数组打印成String
    }

}

class LambdaTest
{
    public static void main(String [] args)
    {
        String [] string1={"bob","alice","john"};
        Arrays.sort(string1,(String a,String b)->a.length()-b.length());
        System.out.println(Arrays.toString(string1));

        Stack<String> mystack=new Stack<>();
        mystack.push("1");
        System.out.println(mystack.peek());
    }
}
