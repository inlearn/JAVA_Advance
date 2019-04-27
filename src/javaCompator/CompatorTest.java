package javaCompator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CompatorTest {

    public static void main(String []args)
    {
        Student t1=new Student(1,"wangYong","17317827416");
        Student t2=new Student(2,"luikanshan","13067757416");

        PriorityQueue<Student> stack=new PriorityQueue<>(new mycompator());
        PriorityQueue<Student> stack2=new PriorityQueue<>((Student s1,Student s2)->{return s1.getId()-s2.getId();});

        stack.add(t1);
        stack.add(t2);
        stack.add(t1);
        stack.add(t2);
        stack2.add(t1);
        stack2.add(t2);



        while(!stack.isEmpty())
        {
            Student std=stack.poll();
            System.out.println(std.toString());
        }
        while(!stack2.isEmpty())
        {
            Student std=stack2.poll();
            System.out.println(std.toString());
        }
    }






}

class mycompator implements Comparator<Student>
{

    public int compare(Student s1,Student s2)
    {
        return s2.getId()-s1.getId();
    }
}

class Student
{
    private int id;
    private String name;
    private String phone;


    public Student(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}