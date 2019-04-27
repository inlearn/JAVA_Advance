package 最小生成树2;

import java.util.Arrays;

public class MstSolution_points {
    public static int findRoot(int []tree,int x)
    {
        if(tree[x]==-1)return x;
        else{
            int temp = findRoot(tree, tree[x]);
            tree[x]=temp;
            return temp;
        }
    }
    public static void main(String[] args) {
        double [][]arr=new double[][]{{1,1},{2,2},{2,4}};

        //第1将点编号，从0开始编，第一个点为0
        int length=arr.length;
        //System.out.println(length);
        Point []points=new Point[length];
        for (int i = 0; i < length; i++) {
            points[i]=new Point(arr[i][0],arr[i][1],i);
        }
        //第2，计算出各边的权重
        int edgeNum=(length-1)*length/2;
        //System.out.println(edgeNum);
        Edge []edges=new Edge[edgeNum];
        //两重循环计算edge
        int k=0;
        for (int i = 0; i <length ; i++) {
            for (int j = i+1; j <length ; j++) {
                edges[k++]=new Edge(points[i],points[j]);
            }
        }

        //3，排序，最小生成树
        Arrays.sort(edges);

        //初始化树
        int []tree=new int[length];
        for (int i = 0; i < length; i++) {
            tree[i]=-1;
        }
        double minCost=0;
        for (int i = 0; i < edgeNum; i++) {
            int rootA=findRoot(tree,edges[i].getP1().getId());
            int rootB=findRoot(tree,edges[i].getP2().getId());
            if(rootA!=rootB)
            {
                tree[rootA]=rootB;
                minCost+=edges[i].getCost();
            }
        }

        System.out.printf("连接所有点最小的值为%f\n",minCost);
    }
}

class Edge implements Comparable<Edge>{
    //存有两个结点的编号，权值f
    //实现comparable接口，对边进行排序
    private Point p1,p2;
    private double cost;

    public Edge(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.cost = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge o) {
        return (int)(this.cost-o.cost);
    }
}

class Point{
    private double x,y;
    private int id;

    public Point(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getId() {
        return id;
    }
}


