package corejava1.ch06;
import java.awt.event.ActionListener;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;

 class Employee implements Comparable<Employee>,Cloneable
{
   private String name;
   private double salary;
   private LocalDate hireDay;

   public Employee(String name, double salary)
   {
      this.name = name;
      this.salary = salary;

   }
    public Object clone() {
        return new Employee( this );
    }
   public Employee(Employee obj){
       this.name=obj.name;
       this.salary=obj.salary;
       this.hireDay=obj.hireDay;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public LocalDate getHireDay()
   {
      return hireDay;
   }
   public void setName(String aName)
   {
       name=aName;
   }
   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   public int compareTo(Employee obj)
   {
      //Employee obj=(Employee) otherObject;
      //eturn Double.compare(this.salary,obj.salary);
      return this.getName().length()-obj.getName().length();
   }




    /**
     * Lambda expression

     */
    /*
    (String first, String second)->

    {
        if(first.length()<second.length()) return -1;
        else if(first.length()>second.length()) return 1;
        else return 0;
    }

    /**
     * A Lambda expression has no parameters, just supply empty parentheses
     */

    /* ()->
    {
        //do something
    }
    */

    /**
     * If a method has a single parameter with inferred type,
     * you can omit the parentheses.
     */
 /*   ActionListener listener=event->
            System.out.println("The time is "+ new Date());
*/
   public  void sort(Employee[] a)
   {
      Employee temp=null;
      for(int i=0;i<a.length;i++)
      {
         for(int j=i+1;j<a.length;j++)
         {
            if(a[i].compareTo(a[j])>0)
            {
               temp=a[i];
               a[i]=a[j];
               a[j]=temp;
            }
         }
      }
   }




}
