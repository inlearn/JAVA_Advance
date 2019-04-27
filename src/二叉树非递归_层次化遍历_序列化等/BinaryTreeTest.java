package 二叉树非递归_层次化遍历_序列化等;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    private int value;
    private Node left = null;
    private Node right = null;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}


public class BinaryTreeTest {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);

        //preOrder(node1);
        //inOrder(node1);
        //postOrder(node1);
        System.out.println("中序序列化二叉树:"+serializeTree(node1));
        Queue<String> st1 = new LinkedList<>();
        st1 = process(serializeTree(node1));
        Node node11 = reSerializeTree(st1);//中序重建二叉树
        System.out.println("----");
        System.out.println("中序序列化二叉树"+serializeTree(node11));//中序序列化二叉树


        System.out.println("层次序列化二叉树"+printTreeByLevel(node1));

        String levelString=printTreeByLevel(node1);
        Node levelNode=buildTreeByLevel(levelString);
        System.out.println("层次重建二叉树后的层次序列化"+printTreeByLevel(levelNode));

    }


    //判断一棵树是不是二叉排序树
    //按中序遍历的非递归写好，再改
    public static boolean IsBalance(Node node)
    {
        Stack<Node> stack=new Stack<>();
        if(node!=null) {
            stack.push(node);
            Node head = node;
            int pre = Integer.MIN_VALUE;
            while (!stack.isEmpty() || head != null) {
                if (head != null)//如果当前结点不为空，将当前结点压入栈中，然后将当前结点设置为左孩子
                {
                    stack.push(head);
                    head = head.getLeft();
                } else//如果当前结点为空，从栈里拿一个打印，然后让当前结点为当前结点的右孩子
                {
                    head = stack.pop();
                    if (head.getValue() > pre) {
                        pre=head.getValue();
                    }
                    else
                        return false;
                    System.out.println(head.getValue());
                    head = head.getRight();
                }

            }
        }
        return true;
    }





    //层次建树
    public static Node buildTreeByLevel(String str) {
        //层次建树
        //1.先在队中加一个结点，
        //2。弹出，把后面两个加入左右，
        //3 后面两个加入队，循环进行
        //一个普通的树，空结点用#表示
        String[] strings = str.split(",");
        Queue<Node> queue = new LinkedList<>();
        if (strings[0].equals("#"))
            return null;
        else {
            Node head = new Node(Integer.valueOf(strings[0]));
            queue.offer(head);
        }
        Node head=queue.peek();
        int i = 1;
        while (!queue.isEmpty()) {
            Node current=queue.poll();
            if(!strings[i].equals("#")){
                int value1= Integer.valueOf(strings[i++]);
                Node leftNode=new Node(value1);
                current.setLeft(leftNode);
                queue.offer(leftNode);
            }
            else{
                current.setLeft(null);
            }

            if(!strings[i].equals("#")) {
                int value2 = Integer.valueOf(strings[i++]);
                Node rightNode=new Node(value2);
                current.setRight(rightNode);
                queue.offer(rightNode);
            }
            else
                current.setRight(null);
        }


       return head;
    }


    //层次序列化树
    public static String printTreeByLevel(Node node) {
        //层次遍历，用队列，
        //1.先把头压入队列，出队的同时把左右孩子压入队列
        //2.出队一个结点，把它左右孩子压入
        //3.队列为空停止
        Queue<Node> queue = new LinkedList<>();
        if (node != null) {
            queue.offer(node);
        }
        Node head = null;
        String res = node.getValue() + ",";
        while (!queue.isEmpty()) {
            head = queue.poll();

            if (head.getLeft() != null) {
                queue.offer(head.getLeft());
                res += head.getLeft().getValue() + ",";
            } else
                res += "#,";
            if (head.getRight() != null) {
                queue.offer(head.getRight());
                res += head.getRight().getValue() + ",";
            } else
                res += "#,";
        }
        return res;
    }

    //序列化二叉树
    public static String serializeTree(Node T) {
        //用前序的方法序列化，空结点用#表示，用，分隔
        Node head = T;
        if (head == null)
            return "#,";

        String res = head.getValue() + ",";
        res += serializeTree(head.getLeft());
        res += serializeTree(head.getRight());
        return res;
    }

    //把序列化后的字串转成队列
    public static Queue<String> process(String str) {
        Queue<String> queue = new LinkedList<>();
        String[] arr = str.split(",");
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        return queue;
    }


    //反序列化二叉树,输入一个队列，返回一个node头
    public static Node reSerializeTree(Queue<String> queue) {
        String s1 = queue.poll();
        if (s1.equals("#"))
            return null;

        Node head = new Node(Integer.valueOf(s1));//新建一个以s1为值的结点
        head.setLeft(reSerializeTree(queue));//序列化左
        head.setRight(reSerializeTree(queue));//序列化右

        return head;


    }


    public static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#"))
            return null;
        Node head = new Node(Integer.valueOf(value));
        head.setLeft(reconPreOrder(queue));
        head.setRight(reconPreOrder(queue));
        return head;
    }


    //前序非递归
    public static void preOrder(Node T) {
        System.out.print("前序遍历：");
        Node head = T;
        //System.out.println(head.getValue());
        if (head != null) {
            Stack<Node> stack = new Stack<>();//准备一个栈
            stack.push(head);//如果头结点不为空，头结点压栈

            while (!stack.isEmpty()) {//如果栈不空
                head = stack.pop();//从栈里弹出一个，打印
                System.out.print(head.getValue() + ",");
                if (head.getRight() != null)//如果左子树不空，左子树进栈
                    stack.push(head.getRight());
                if (head.getLeft() != null)//如果右子树不空，右子树进栈
                    stack.push(head.getLeft());
            }
        }

    }

    public static void inOrder(Node T) {
        System.out.print("中序遍历：");
        Node head = T;
        //当stack或者head不为空循环

        //如果head不为空，left进栈,head更新为head.left，

        //否则弹出一个为当前head，访问它，head更新为head.right

        if (head != null) {
            Stack<Node> stack = new Stack<>();

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.getLeft();
                } else {
                    head = stack.pop();
                    System.out.print(head.getValue() + ",");
                    head = head.getRight();
                }
            }
        }
    }

    public static void postOrder(Node T) {
        //后序遍历 左->右->根
        //因为前序遍历为 根->左->右，可以先改成根->右->左，存到一个栈里，再倒出来 产生左->右->根
        System.out.print("后序遍历：");
        Node head = T;
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        if (head != null) {

            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                //System.out.print(head.getValue()+",");
                stack2.push(head);
                if (head.getLeft() != null)
                    stack.push(head.getLeft());
                if (head.getRight() != null)
                    stack.push(head.getRight());
            }
        }
        while (!stack2.isEmpty()) {
            head = stack2.pop();
            System.out.print(head.getValue() + ",");
        }
    }


}

class BinaryTree {


}
