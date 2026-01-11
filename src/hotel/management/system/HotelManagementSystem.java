package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener { // actionlistner helps to catch whatever actiobn performed on button/ through this we can know that button is clicked
    
    HotelManagementSystem() {  /* Constructor */
    //  setSize(1366, 565); /* frame size length breath*/
    //  setLocation(100, 100); /* left top through this we can set location of frame*/
        setBounds(100, 100, 1366, 565);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg")); /* ImageIcon is a class */
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565); //locationx, locationy, lenght, breadth
        add(image);
        
        JLabel text = new JLabel("Hotel Management System"); // here we add text on image through JLabel
        text.setBounds(20, 430, 1000, 90); //lrft, top, length, breadth from frame
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);
        
        setVisible(true); /* by default it is false */
        
        while(true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();   //through this 3 line button click ke baad kya krna h 
       
    }

    public static void main(String[] args) {
        new HotelManagementSystem(); /* class object */
    }
    
}
