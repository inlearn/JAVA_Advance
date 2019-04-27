package 王道5_6floyd最短路;

//弗洛伊德算法适合计算所有结点之间的最短路径
import java.util.Arrays;

public class ShortestSolution {
    //题目，一个二维矩阵，行数为路数，每一行是
    // 结点x,结点y，cost
    //一共有n个结点，结点从1开始编号
    public static void main(String[] args) {
        //int n=3;
        //int [][]arr=new int[][]{{1,2,5},{2,3,5},{3,1,2}};
        int n=4;
        int [][]arr=new int[][]{{1,2,1},{1,3,2},{1,4,5},{2,4,2},{3,4,3}};


        //第一步，将结点对应的权值存到二维矩阵，同一个结点距离0，无穷大定义为-1，如果结点之间没有路，那么为-1
        int [][]costArr=new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j <n+1 ; j++) {
                costArr[i][j]=-1;
            }
            costArr[i][i]=0;//自己到自己的长度为0
        }
        for(int []row:arr)
        {
            costArr[row[0]][row[1]]=costArr[row[1]][row[0]]=row[2];
        }
        //System.out.println(Arrays.deepToString(costArr));
        for (int k = 1; k <n+1 ; k++) {
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    if(costArr[k][i]==-1||costArr[k][j]==-1)//如果任意一个结点到k的距离为无穷，则不能更新
                        continue;
                    if(costArr[k][i]+costArr[k][j]<costArr[i][j]||costArr[i][j]==-1)//如果两个结点到k的距离之和小于原来的，更新为新值
                        costArr[i][j]=costArr[k][i]+costArr[k][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(costArr));
        System.out.println(costArr[1][4]);//输出两结点之间最短的距离
    }




}
