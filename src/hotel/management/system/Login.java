package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    //through this inteerface (actionlistener) we know that button is clicked, this interface comes under awt.event package
    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    
    Login() { //constructor
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30); //left, top, length, breadth 
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);
        
        login = new JButton("Login"); //through JButton we create button
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); //through this konse button pe click hua h
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); //through this we can adjust size of image with lenght, height
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // we cannot directly place Image class in JLabel 
        image.setBounds(350, 10, 200, 200);
        add(image);
        
        setBounds(500, 200, 600, 300);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();
            
            try {
                Conn c = new Conn();
                
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "' ";
                
                ResultSet rs = c.s.executeQuery(query); // this resultset comes in sql package
                
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
