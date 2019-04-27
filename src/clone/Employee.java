package clone;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name,double salary)
    {
        this.name=name;
        this.salary=salary;
        hireDay=new Date();
    }

    public Employee clone() throws CloneNotSupportedException
    {
        //call Object.clone
        Employee cloned=(Employee)super.clone();

        //clone mutable fields
        cloned.hireDay=(Date)hireDay.clone();
        return cloned;
    }

    public void setHireDay(int year,int month,int day)
    {
        Date newHireDay=new GregorianCalendar(year,month-1,day).getTime();
        //example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent)
    {
        double raise=byPercent*this.salary;
        this.salary+=raise;
    }

    public String toString()
    {
        return "employee[name=" +name+",salary="+salary+",hireDay="+hireDay+"]";
    }
}
