package javaswingproject;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class resultpage{
    Vector<String> elements=new Vector<String>();
    JFrame jf;
    JPanel jp;
    JList j1;
    JButton b1,b2;
    JScrollPane sp;
    public static String id;
    resultpage(String abc , String xyz)
    {   System.out.println(abc+" "+xyz );
        jf=new JFrame();
        jp=new JPanel(new GridLayout(3,1));
        b1=new JButton("Submit");
        b2=new JButton("Exit");
        String url="jdbc:derby://localhost:1527/mohit0001";
        String username="mohit";
        String password="mohit";
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            ResultSet resultset=statement.executeQuery("select * from compdata where cname='"+abc+"' and yearr='"+xyz+"'");

            while(resultset.next())
            {
                elements.add(resultset.getInt(("id"))+"----------------------> "+resultset.getString(("sname")));
            }
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        j1=new JList(elements);
        j1.setSelectedIndex(0);
        jp.add(j1);
        sp = new JScrollPane();
        sp.setViewportView(j1);
        j1.setLayoutOrientation(JList.VERTICAL);
        jp.add(sp);
        jp.add(b1);
        jp.add(b2);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            id= j1.getSelectedValue().toString();
            id =id.substring(0, 4);
            System.out.println(id);
            user_profile us=new user_profile(id);
            jf.dispose();
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.exit(0);
            }
        });
        jf.add(jp,BorderLayout.CENTER);
        jf.setTitle("Result Page");
        jf.setSize(450,350);
        jf.setVisible(true);
    }
}
