package 循环数组建队;

public class Solution {

    public static void main(String [] args)
    {
Find(3,new int[4][5]);
    }

        public static boolean Find(int target, int [][] array) {
            int clen=array[0].length;
            int rlen=array.length;
            int n=0;
            for(;n<clen-1&&n<rlen-1;n++)
            {
                if(array[n][n]>target)
                {
                    n=n-1;
                    break;
                }
            }
            //在n-1行，n-1,n-1列
            for(int i=n;i<rlen;i++)
            {

            }




            return true;
        }
    }