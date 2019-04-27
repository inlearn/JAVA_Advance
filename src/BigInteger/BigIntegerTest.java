package BigInteger;
import java.math.*;
import java.util.*;
public class BigIntegerTest {
    public static void main(String []args)
    {    Scanner in = new Scanner(System.in);
        System.out.println("请输入几个数");
        int num1=in.nextInt();
        System.out.println("请输入抽几个数");
        int num2=in.nextInt();

        BigInteger num3=BigInteger.valueOf(1);

        for(int i=1;i<=num2;i++)
        {
            num3=num3.multiply(BigInteger.valueOf(num1+1-i)).divide(BigInteger.valueOf(i));
        }
        System.out.println("your odds is 1 out of "+num3);
    }




}
