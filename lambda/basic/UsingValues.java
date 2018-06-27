package basic;
import javax.swing.*;
import java.awt.event.*;
import java.util.function.*;

class TestUsingValues
{

 public static void main(String args[])
 {
     UsingValues obj=new UsingValues();
     obj.setSize(400,400);
     obj.setVisible(true);
     obj.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


 }

}
 class UsingValues extends JFrame
{

    private JButton button;


    UsingValues()
    {
        super("main windows");
        button=new JButton("Click me");
        add(button);
        button.addActionListener( event->
                System.out.println("The button was clicked"));

    }

}
