package javaswingproject;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;

public class user_profile {
    JFrame jf;
    JPanel jp;
    JButton submit,cancel;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JLabel l11,l12,l13,l14,l15,l16,l17,l18;
    user_profile(String xyz)
    {
        jf =new JFrame("USER PROFILE");
        jp=new JPanel(new GridLayout(10,1));
        submit=new JButton("Go Back");
        cancel=new JButton("Exit");
        l1=new JLabel("  id : ");
        l2=new JLabel();
        l3=new JLabel("  User Name : ");
        l4=new JLabel();
        l5=new JLabel("  Company Name : ");
        l6=new JLabel();
        l7=new JLabel("  Year of Joining Company : ");
        l8=new JLabel();
        l9=new JLabel("  Father Name : ");
        l10=new JLabel();
        l11=new JLabel("  Marks Percentage : ");
        l12=new JLabel();
        l13=new JLabel("  User's Age : ");
        l14=new JLabel();
        l15=new JLabel("  User's Email Address  : ");
        l16=new JLabel();
        l17=new JLabel("  User's Mobile  Number");
        l18=new JLabel();
        String url="jdbc:derby://localhost:1527/mohit0001";
        String username="mohit";
        String password="mohit";
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from compdata where id='"+xyz+"'");
            while(rs.next())
            {
                l2.setText(rs.getString("id"));
                l4.setText(rs.getString("sname"));
                l6.setText(rs.getString("cname"));
                l8.setText(rs.getString("yearr"));
                l10.setText(rs.getString("fathername"));
                l12.setText(rs.getString("percentage"));
                l14.setText(rs.getString("age"));
                l16.setText(rs.getString("email"));
                l18.setText(rs.getString("phone"));

            }
            con.close();
        }
        catch(Exception e) {
        System.out.println(e);
        }

        jf.add(jp,BorderLayout.CENTER);
        jp.add(l1);
        jp.add(l2);
        jp.add(l3);
        jp.add(l4);
        jp.add(l5);
        jp.add(l6);
        jp.add(l7);
        jp.add(l8);
        jp.add(l9);
        jp.add(l10);
        jp.add(l11);
        jp.add(l12);
        jp.add(l13);
        jp.add(l14);
        jp.add(l15);
        jp.add(l16);
        jp.add(l17);
        jp.add(l18);
        jp.add(submit);
        jp.add(cancel);
        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            indexpage i= new indexpage();
            jf.dispose();
            }
        });
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }


        });
        jf.setSize(450,800);
        jf.setVisible(true);
    }
}
