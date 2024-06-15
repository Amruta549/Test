
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Result extends JFrame implements ActionListener
{
   
    Result(String name,int result)
    {
        setBounds(150,55,1020,600);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icons/res.png"));
        JLabel img=new JLabel(i3);
        img.setBounds(70,30,410,245);
        add(img);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/down6.jpg"));
        JLabel img1=new JLabel(i4);
        img1.setBounds(0,480,1020,230);
        add(img1);

        JLabel display=new JLabel("The  Result  is  "+ result);
        display.setBounds(570,300,300,30);
        display.setFont(new Font("Tahoma",Font.PLAIN,28));
        display.setForeground(Color.GREEN);
        add(display);

        JButton submit=new JButton("Try Again");
        submit.setBounds(730,380,140,35);
        submit.setFont(new Font("Calibri",Font.BOLD,18));
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        
        add(submit);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }

    public static void main(String args[])
    {
        new Result("User",0);
    }
}
