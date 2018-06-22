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


 class LambdaTest
{
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("ddd", 35000);
        staff[1] = new Employee("dd", 75000);
        staff[2] = new Employee("d", 38000);
        var newStaff = (Employee) (staff[0].clone());
        newStaff.setName("debug");
        System.out.println(newStaff.getName());
        newStaff.sort(staff);

        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());


        var t = new Timer(1000, event ->
        {
            System.out.println("At the tone, the time is " + new Date());
            Toolkit.getDefaultToolkit().beep();
        });
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }



}


