import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
    JButton Guide,back;
    JTextField txt;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/level.jpg"));
        JLabel img=new JLabel(i1);
        img.setBounds(375,0,600,500);
        add(img);

        JLabel head=new JLabel("Let's try");
        head.setBounds(100,60,300,45);
        head.setFont(new Font("Segoe UI Black",Font.BOLD,35));
        head.setForeground(Color.BLACK);
        add(head);

        JLabel name=new JLabel("Enter registered name");
        name.setBounds(70,150,300,20);
        name.setFont(new Font("Verdana",Font.BOLD,16));
        name.setForeground(Color.BLACK);
        add(name);

        txt=new JTextField();                               //Text feild
        txt.setBounds(30,210,300,30);
        txt.setFont(new Font("Calibri",Font.BOLD,20));
        add(txt);
        
        Guide=new JButton("Guildlines");               //guide button
        Guide.setBounds(200,280,120,28);
        Guide.setBackground(Color.BLUE);
        Guide.setForeground(Color.YELLOW);
        Guide.addActionListener(this);
        add(Guide);

        back=new JButton("Back");                      //back button
        back.setBounds(40,280,120,28);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.YELLOW);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        setSize(1000,500);
        setLocation(150,100);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
        }
        else if(ae.getSource()==Guide)
        {
            String name=txt.getText();
            setVisible(false);
            new Guide(name);
        }
    }
    public static void main(String[] args) 
    {
        new Login();
    }
}