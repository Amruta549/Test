
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener
{
    String questions[][]=new String[10][5];
    String ans[][]=new String[10][2];
    String ticked[][]=new String[10][1];
    JLabel num,q;
    JRadioButton a,b,c,d;
    JButton next,submit,hint;
    ButtonGroup grp;

    public static int timer=13;
    public static int count=0;
    public static boolean selected=false;
    public static int result=0;

    String name;
    Quiz(String name)
    {
        this.name=name;
        setBounds(150,55,1020,600);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel img=new JLabel(i3);
        img.setBounds(0,10,320,222);
        add(img);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/down6.jpg"));
        JLabel img1=new JLabel(i4);
        img1.setBounds(0,480,1020,230);
        add(img1);

        num=new JLabel();
        num.setBounds(320,110,50,30);
        num.setFont(new Font("Tahoma",Font.PLAIN,16));
        num.setForeground(Color.ORANGE);
        add(num);

        q=new JLabel();
        q.setBounds(350,100,900,50);
        q.setFont(new Font("Tahoma",Font.PLAIN,16));
        q.setForeground(Color.ORANGE);
        add(q);

        questions[0][0] = "What is the name of the new AI language model released by OpenAI in 2024 ?";
        questions[0][1] = "GPT-3";
        questions[0][2] = "GPT-6";
        questions[0][3] = "GPT-5";
        questions[0][4] = "GPT-4";

        questions[1][0] = "Which company became the first to reach a market capitalization of $3 trillion in 2024 ?";
        questions[1][1] = "Apple";
        questions[1][2] = "Google";
        questions[1][3] = "Microsoft";
        questions[1][4] = "Amazon";

        questions[2][0] = "What new feature did Zoom introduce in its platform update in 2024?";
        questions[2][1] = "Virtual Reality Meetings";
        questions[2][2] = "Real time translations";
        questions[2][3] = "AI meeting summaries";
        questions[2][4] = "Enhanced Encryption";

        questions[3][0] = "What is the name of the latest version of the Android operating system launched in 2024?";
        questions[3][1] = "Android 12";
        questions[3][2] = "Android 15";
        questions[3][3] = "Android 13";
        questions[3][4] = "Android 14";

        questions[4][0] = "Which cloud computing service provider announced its quantum computing service expansion in early 2024?";
        questions[4][1] = "Amazon Web Services";
        questions[4][2] = "Google Cloud";
        questions[4][3] = "Microsoft Azure";
        questions[4][4] = "IBM Cloud";

        questions[5][0] = "What is the name of the new AI coding assistant launched by GitHub in 2024?";
        questions[5][1] = "Copilot X";
        questions[5][2] = "CodeMate";
        questions[5][3] = "CodeMaster";
        questions[5][4] = "AI DevHelper";

        questions[6][0] = "Which software development framework introduced a new version with enhanced support for web assembly in 2024?";
        questions[6][1] = "Angular";
        questions[6][2] = "Vue.js";
        questions[6][3] = "Blazor";
        questions[6][4] = "React";

        questions[7][0] = "Which database technology company released a major update for its cloud-based database platform in 2024?";
        questions[7][1] = "Oracle";
        questions[7][2] = "PostgreSQL";
        questions[7][3] = "Redis Labs";
        questions[7][4] = "MongoDB";

        questions[8][0] = "Which cybersecurity company launched an advanced AI-driven threat detection system in 2024?";
        questions[8][1] = "Norton";
        questions[8][2] = "Palo Alto Networks";
        questions[8][3] = "CrowdStrike";
        questions[8][4] = "McAfee";

        questions[9][0] = "Which open-source project achieved its 1.0 release milestone in 2024, widely adopted for building serverless applications?";
        questions[9][1] = "Knative";
        questions[9][2] = "Kubernetes";
        questions[9][3] = "Apache Kafka";
        questions[9][4] = "TensorFlow";
	

        ans[0][1] = "GPT-5";
        ans[1][1] = "Apple";
        ans[2][1] = "AI meeting summaries";
        ans[3][1] = "Android 14";
        ans[4][1] = "Google Cloud";
        ans[5][1] = "Copilot X";
        ans[6][1] = "Blazor";
        ans[7][1] = "MongoDB";
        ans[8][1] = "Palo Alto Networks";
        ans[9][1] = "Knative";
        
        a=new JRadioButton();
        a.setBounds(450,155,400,30);
        a.setFont(new Font("Arial",Font.PLAIN,18));
        a.setBackground(Color.BLACK);
        a.setForeground(Color.WHITE);
        add(a);

        b=new JRadioButton();
        b.setBounds(450,195,400,30);
        b.setFont(new Font("Arial",Font.PLAIN,18));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        add(b);

        c=new JRadioButton();
        c.setBounds(450,235,400,30);
        c.setFont(new Font("Arial",Font.PLAIN,18));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        add(c);

        d=new JRadioButton();
        d.setBounds(450,275,400,30);
        d.setFont(new Font("Arial",Font.PLAIN,18));
        d.setBackground(Color.BLACK);
        d.setForeground(Color.WHITE);
        add(d);
        
        grp=new ButtonGroup();              //ButtonGroup
        grp.add(a);
        grp.add(b);
        grp.add(c);
        grp.add(d);

        hint=new JButton("Hint");
        hint.setBounds(25,420,110,35);
        hint.setFont(new Font("Calibri",Font.BOLD,18));
        hint.setBackground(Color.BLACK);
        hint.setForeground(Color.WHITE);
        hint.addActionListener(this);
        add(hint);

        next=new JButton("Next");
        next.setBounds(470,380,140,35);
        next.setFont(new Font("Calibri",Font.BOLD,18));
        next.setBackground(Color.ORANGE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        submit=new JButton("Submit");
        submit.setBounds(730,380,140,35);
        submit.setFont(new Font("Calibri",Font.BOLD,18));
        submit.setBackground(Color.ORANGE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        begin(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next){
            repaint();

            a.setEnabled(true);
            b.setEnabled(true);
            c.setEnabled(true);
            d.setEnabled(true);

            selected=true;
            if(grp.getSelection()!=null){
                ticked[count][0]=grp.getSelection().getActionCommand();      //val of the opt
            } else {
                ticked[count][0]="";
            }

            if(count==8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            begin(count);
        }
        else if(ae.getSource()==hint)
        {
            if(count==9||count==8||count==6||count==4||count==2)
            {
                b.setEnabled(false);
                c.setEnabled(false);
            }
            else
            {
                a.setEnabled(false);
                d.setEnabled(false);
            }
            hint.setEnabled(false);
        }
        else if(ae.getSource()==submit)
        {
            selected=true;
            if(grp.getSelection()!=null)
                ticked[count][0]=grp.getSelection().getActionCommand();      //val of the opt
            else 
                ticked[count][0]="";
                
            for(int i=0;i<ticked.length;i++)
            {
                if(ticked[i][0].equals(ans[i][1]))
                    result=result+10;
            }
            setVisible(false);
            //result frame
            new Result(name,result);
        }
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        String time= "Time left " +timer+ " s";
        g.setColor(Color.RED);
        g.setFont(new Font("Arial",Font.CENTER_BASELINE,14));
        if(timer>0)
        {
            g.drawString(time,900,90);
        } 
        else 
        {
            g.drawString("Times up",900,90);
        }

        timer--;
        try{
            Thread.sleep(1000);
            repaint();
            }catch(Exception e){
                e.printStackTrace();
            }

        if(selected){                                            //answered
            selected=false;
            timer=13;
        }
        else if (timer<0)
        {                                                       //not answered
            timer=13;
            a.setEnabled(true);
            b.setEnabled(true);
            c.setEnabled(true);
            d.setEnabled(true);

            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            //submit button case
            if(count==9)
            {
                if(grp.getSelection()!=null)
                    ticked[count][0]=grp.getSelection().getActionCommand();      //val of the opt
                else 
                    ticked[count][0]="";
                
                for(int i=0;i<ticked.length;i++)
                {
                    if(ticked[i][0].equals(ans[i][1]))
                        result=result+10;
                }
                setVisible(false);
                //result frame
                new Result(name,result);
            }
            else //next button case
            {
                if(grp.getSelection()!=null)
                    ticked[count][0]=grp.getSelection().getActionCommand();      //val of the opt
                else 
                    ticked[count][0]="";
                count++;
                begin(count);
            }
        }
    }

    public void begin(int idx)
    {
        num.setText(""+ (idx+1) +". ");
        q.setText(questions[idx][0]);
        a.setText(questions[idx][1]);
        a.setActionCommand(questions[count][1]);
        b.setText(questions[idx][2]);
        b.setActionCommand(questions[count][2]);
        c.setText(questions[idx][3]);
        c.setActionCommand(questions[count][3]);
        d.setText(questions[idx][4]);
        d.setActionCommand(questions[count][4]);
        grp.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
