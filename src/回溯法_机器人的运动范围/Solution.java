package 回溯法_机器人的运动范围;

public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean [][]visited=new boolean[rows][cols];

        return  movingCountCore(threshold,0,0,rows,cols,visited);
    }

    public int movingCountCore(int threshold,int row,int col,int rows,int cols,boolean [][]visited)
    {
        int count=0;
        if(ableVisit(row,col,rows,cols,threshold,visited))
        {
            visited[row][col]=true;
            count= 1+movingCountCore(threshold,row,col-1,rows,cols,visited)+movingCountCore(threshold,row,col+1,rows,cols,visited)+
                    movingCountCore(threshold,row-1,col,rows,cols,visited)+movingCountCore(threshold,row+1,col,rows,cols,visited);
        }
        return count;
    }

    public boolean ableVisit(int row,int col,int rows,int cols,int threshold,boolean[][]visited)
    {
        return 0<=row&&row<rows&&col<cols&&0<=col&&((getDigitSum(row)+getDigitSum(col))<=threshold)&&!visited[row][col];
    }
    public int getDigitSum(int num)
    {
        int sum=0;
        while(num>0)
        {
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}