package HashMapGetRandom左视频题;

import java.util.HashMap;

/**
 *实现一个结构，记录字符串，使add，remove,getRandom的时间复杂度O(1)
 */

class MyHashset
{
    private HashMap<Integer,String> num_str=new HashMap<>();
    private HashMap<String,Integer> str_num=new HashMap<>();
    private int size=-1;


    public void put(String str)
    {
        size++;
        num_str.put(size, str);
        str_num.put(str,size);
    }

    public String getRandom()
    {
        int randIndex = (int) (Math.random() * size);
        //System.out.println("rand到的index  "+randIndex);
        //System.out.println("size的值  "+size);
        return num_str.get(randIndex);
    }

    public void remove(String str)
    {
        if(str_num.containsKey(str))
        {
            //把最后一个的值更新到删除的位置
            int num=str_num.get(str);//要删除的str对应的num
            /*System.out.println("要删的num   "+num);
            System.out.println("要删的str   "+str);*/
            String lastStr=num_str.get(size);
            System.out.println("size的值"+size);
            System.out.println("最后一个字符"+lastStr);
            num_str.put(num,lastStr);
            str_num.put(lastStr,num);

            str_num.remove(str);
            num_str.remove(size);
            //size--;
        }
    }

    public String toString()
    {
        return num_str.toString()+str_num.toString()+size;
    }

}





public class HashTest {


    public static void main(String[] args) {
        MyHashset myHashset =new MyHashset();
        myHashset.put("a");
        myHashset.put("b");
        myHashset.put("c");
        myHashset.put("d");
        myHashset.put("e");
        myHashset.remove("c");
        myHashset.remove("a");
        for (int i = 0; i <10 ; i++) {
            System.out.println(myHashset.getRandom());
        }
        System.out.println(myHashset.toString());
    }






}
