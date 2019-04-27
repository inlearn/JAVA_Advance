package javaCollections;

import java.util.Scanner;
import java.util.Stack;

public class CollectionsTest {
}

class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            stack1.push(i);
        }
        for (int i = 0; i < 5; i++) {
            stack1.pop();
        }
        while (!stack1.empty()) {
            System.out.println(stack1.peek());
            stack1.pop();
            // System.out.println(j);
        }
    }
}

//双栈法计算算术表达示的值
//一个操作符的栈，一个数的栈，左括号忽略，把操作符与数分别压栈，遇到右括号弹出数与运算符，把结果压入到数栈
//当处理完表达式，数栈里的值即为结果
//(1+((2+3)*(4*5)))

class doubleStack {
    public static void main(String[] args) {
        String string = "(1+((2+3)*(4*5)))";

        Stack<Character> op = new Stack<>();
        Stack<Double> num = new Stack<>();
        double value;
        char operation;
        for (int i = 0; i < string.length(); i++) {
            char it = string.charAt(i);
            if (it == '(') {
                continue;
            } else if (it == '+' || it == '-' || it == '*' || it == '/')
                op.push(it);
            else if (it == ')') {
                value = num.pop();
                operation=op.pop();

                if(operation=='+')
                {
                    value+=num.pop();
                    num.push(value);
                }
                if(operation=='-')
                {
                    value-=num.pop();
                    num.push(value);
                }
                if(operation=='*')
                {
                    value*=num.pop();
                    num.push(value);
                }
                if(operation=='/')
                {
                    value/=num.pop();
                    num.push(value);
                }





            }
            else
            {
                num.push((double)(it-'0'));
            }
        }

        System.out.println(num.peek());


    }
}
