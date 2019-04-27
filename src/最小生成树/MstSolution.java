package 最小生成树;

import java.util.Arrays;

public class MstSolution {

    private static int findRoot(int[]tree,int x)
    {
        if(tree[x]==-1)return x;
        else{
            int temp=findRoot(tree,tree[x]);
            tree[x]=temp;
            return temp;
        }
    }


    public static void main(String[] args) {

        int [][]arr=new int[][]{{0,1,1},{0,2,2},{1,2,4}};
//        int [][]arr=new int[][]{{0,1,1},{0,2,4},{0,3,1},{1,2,3},{1,3,2},{2,3,5}};
        int length=arr.length;
        Edge[]edges=new Edge[length];
        for (int i = 0; i < length; i++) {
            edges[i] = new Edge(arr[i][0], arr[i][1], arr[i][2]);
            //把两个结点与权值加入到边的矩阵中
        }
        Arrays.sort(edges);
        //将边的数组按权值排序
        int []tree=new int[length];
        for (int i = 0; i < length ; i++) {
            tree[i]=-1;//初始化并查集，各自为自己的根
        }

        int ans=0;//最小生成树权值和
        for (int i = 0; i < length; i++) {
            int rootA=findRoot(tree,edges[i].getA());
            int rootB=findRoot(tree,edges[i].getB());
            if(rootA!=rootB)//如果两个结点属于不同的集合，则选用该边
            {
                tree[rootA]=rootB;//如果根不相同，把根a的根设置为b根
                ans+=edges[i].getCost();
            }
        }
        System.out.printf("最小的连接距离是%d\n",ans);

    }
}

class Edge implements Comparable<Edge>
{
    private int a,b;
    private int cost;

    public Edge(int a, int b,int cost) {
        this.a = a;
        this.b = b;
        this.cost=cost;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost-o.cost;
    }
}

