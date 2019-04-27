package 王道5_7_迪杰斯特拉最短路径;

import java.util.*;

public class DijkstraSolution {
    public ArrayList<Integer> findRouth(int []tree,int x)//找到点0到任意点的
    {

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(Global.arr));
        int size=Global.vertexs.length;
        //1.新建一个邻接链表
        LinkedList<Node>[]linkedLists=new LinkedList[size];
        for (int i = 0; i < size; i++) {
            linkedLists[i]=new LinkedList<>();
            linkedLists[i].add(new Node(Global.vertexs[i],0));
        }
        //System.out.println(Arrays.deepToString(linkedLists));
        for (int[] ints : Global.arr) {
            linkedLists[ints[0]].add(new Node(ints[1],ints[2]));
            linkedLists[ints[1]].add(new Node(ints[0],ints[2]));
        }
        System.out.println(Arrays.deepToString(linkedLists));
        //2.创建优先级队列，遍历邻接表
        //创建是否访问过的表，创建已访问的表
        //创建parent表，记录位置
        PriorityQueue<Node> priorityQueue=new PriorityQueue<>();
        ArrayList<Node>arrayList=new ArrayList<>();//已拿出
        int []visited=new int[size];//已访问的数，初始为0代表都未访问

        //假如从第一个结点0开始到结点3
        priorityQueue.add(new Node(0,0));

        //定义一个parent 数组，代表parent
        int []parent=new int[size];
        for (int i = 0; i < size; i++) {
            parent[i]=-1;
        }
        //定义一个distance数组，用来存放到此结点的最小值
        int []distance=new int[size];
        for (int i = 0; i < size; i++) {
            distance[i]=Integer.MAX_VALUE;
        }
        distance[0]=0;
        while(!priorityQueue.isEmpty())
        {
            Node node=priorityQueue.remove();
            arrayList.add(node);
            visited[node.id]=1;
            LinkedList nodes=linkedLists[node.id];//这是拿出来的结点的直接相连的结点
            //添加到优先级队列
            Iterator<Node> iterator=nodes.iterator();
            while(iterator.hasNext())
            {   Node next=iterator.next();
                if(visited[next.id]!=1){
                    if(node.cost+next.cost<distance[next.id])
                    {
                        distance[next.id]=node.cost+next.cost;
                        parent[next.id]=node.id;
                    }

                    System.out.println(node.id+"->"+next.id);
                    priorityQueue.add(new Node(next.id,node.cost+next.cost));
                }

            }

        }
        System.out.println(Arrays.toString(visited));
        System.out.println(arrayList.toString());
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(distance));




    }


}

class Global
{
    static int []vertexs=new int[]{0,1,2,3};//结点从0开始编号
//    static int [][]arr=new int[][]{{1,2,1},{1,3,2},{1,4,5},{2,4,2},{3,4,3}};
    static int [][]arr=new int[][]{{0,1,1},{0,2,2},{0,3,5},{1,3,2},{2,3,3}};
}
class Node implements Comparable<Node>
{
    public int id;
    public int cost;

    public Node(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return id + ":"+cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }
}