package 优先级队列;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<LocalDate> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(LocalDate.of(1906,12,9));
        priorityQueue.add(LocalDate.of(1815,12,10));
        priorityQueue.add(LocalDate.of(1903,12,3));
        priorityQueue.add(LocalDate.of(1910,6,22));
        System.out.println("Iterating over elements");
        for (LocalDate localDate : priorityQueue) {
            System.out.println(localDate);
        }

        System.out.println("Removing elements");
        while(!priorityQueue.isEmpty())
        {
            System.out.println(priorityQueue.remove());
        }
    }
}
