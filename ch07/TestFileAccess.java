package corejava1.ch07;

import java.nio.file.Paths;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class TestFileAccess {

    public static void main(String[] args) {
        class FileAccess implements ActionListener {

            private FileInputStream input;
            private BufferedReader buffer;


            public void actionPerformed(ActionEvent e) {

                String strLine;
                try {
                    input = new FileInputStream("/media/kwan/E0A801EAA801C050/javasrc/corejava/src/corejava1/ch07/file.txt");
                    buffer = new BufferedReader(new InputStreamReader(input));
                    //Read File Line By Line
                    while ((strLine = buffer.readLine()) != null) {
                        // Print the content on the console
                        System.out.println(strLine);
                    }
                } catch (IOException except) {
                    except.printStackTrace();
                    System.exit(0);
                }

                //Close the input stream
                finally {
                    if (buffer != null) {
                        try {
                            buffer.close();
                        } catch (Throwable t) { /* ensure close happens */ }
                    }

                    if (input != null) {
                        try {
                            input.close();
                        } catch (Throwable t) { /* ensure close happens */ }
                    }
                }
            }


        }
        FileAccess obj = new FileAccess();
        ActionListener listener = new FileAccess();
        Timer t = new Timer(1000, listener);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit the program?");
        System.exit(0);

        //System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());


    }

}



