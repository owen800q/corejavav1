package corejava1.ch06;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of packages.
 *
 * @author Cay Horstmann
 * @version 1.11 2004-02-19
 */


class LambdaTest {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("ddd", 35000));
        staff.add(new Employee("dd", 75000));
        staff.add(new Employee("d", 38000));


        System.out.println("Before removal:");
        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

        System.out.println("After removing the first obj.:");
        staff.removeIf(e -> e.getName().equals("ddd"));
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
                /*
        var t = new Timer(1000, event ->
        {
            System.out.println("At the tone, the time is " + new Date());
            Toolkit.getDefaultToolkit().beep();
        });
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    */
        //repreatMessage("Hello world", 1000);
        //JOptionPane.showMessageDialog(null, "Quit program?");
        //System.exit(0);
        repeat(10,()->System.out.println("Hello world"+new Date()));

    }


        public static void repreatMessage(String text, int delay) {
           int i=0;
            new Timer(delay, (ActionEvent event) ->
            {
                ;
                System.out.println(text+new Date());
                Toolkit.getDefaultToolkit().beep();
            }).start();
        }

        public static void repeat(int n,Runnable action)
        {
            for(int i=0;i<n;i++)
                action.run();
        }
}


