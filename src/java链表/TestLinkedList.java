package java链表;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
    public static void main(String[] args) {
        List<String> staff=new LinkedList<>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        Iterator iter =staff.iterator();
        String first =(String) iter.next();
        String second=(String) iter.next();
        iter.remove();
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }

}
