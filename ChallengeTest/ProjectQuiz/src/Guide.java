
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Guide extends JFrame implements ActionListener
{
    String name;
    JButton back,start;
    Guide(String name)
    {
        this.name=name;
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel head=new JLabel("Get Ready "+name+" the rules are");
        head.setBounds(400,25,500,45);
        head.setFont(new Font("Segoe UI Black",Font.BOLD,25));
        head.setForeground(Color.WHITE);
        add(head);

        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("icons/rule1.png"));
        JLabel img=new JLabel(i2);
        img.setBounds(100,60,186,132);
        add(img);

        JLabel rule=new JLabel();
        rule.setBounds(400,80,500,350);
        rule.setFont(new Font("Times New Roman",Font.PLAIN,16));
        rule.setForeground(Color.ORANGE);
        rule.setText(
            "<html>"+ 
                "1. The total time allowed for the quiz is 130s" + "<br><br>" +
                "2. The total number of questions in the quiz are 10." + "<br><br>" +
                "3. The questions include multiple choice." + "<br><br>" +
                "4. 10 marks are awarded for each correct answer." + "<br><br>" +
                "5. You can skip questions and cannot go back to previous question." + "<br><br>" +
                "6. There is a option of Hint which can be used only once." + "<br><br>" +
                "7. When time expires the test will get automatically submitted and result is displayed." + "<br><br>" +
                //"8. Instructions on what to do if you encounter technical problems during the quiz" + "<br><br>" +
            "<html>"
        );
        add(rule);

        start=new JButton("Start");               
        start.setBounds(200,280,120,28);
        start.setBackground(Color.BLUE);
        start.setForeground(Color.YELLOW);
        start.addActionListener(this);
        add(start);

        back=new JButton("Back");                      
        back.setBounds(40,280,120,28);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.YELLOW);
        back.addActionListener(this);
        add(back);

        setSize(1000,500);
        setLocation(150,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
        else{
            setVisible(false);
            new Quiz(name);
        }
    }

    public static void main(String[] args)
    {
        new Guide("User");
    }
}