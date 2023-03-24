package javaswingproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class mainpage
{
public JFrame jf;
public JPanel panel;
public JLabel pass_label,user_label;
public JButton submit,cancel;
public JTextField username_text;
public JPasswordField password_text;
public static String cdate;
mainpage()
{
jf=new JFrame(); 
user_label=new JLabel("User Name : ");
username_text=new JTextField();
pass_label=new JLabel("Password : ");
password_text=new JPasswordField();
submit=new JButton("Submit");
cancel=new JButton("Exit");
panel=new JPanel(new GridLayout(3,1));
panel.add(user_label);
panel.add(username_text);
panel.add(pass_label);
panel.add(password_text);
panel.add(submit);
panel.add(cancel);

jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
submit.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
String user=username_text.getText();
String pass=String.valueOf(password_text.getPassword());
if(user.equals("mohit") && pass.equals(cdate))
{
System.out.println("SUCCESS");
indexpage i=new indexpage();
jf.dispose();
}
else
{
System.out.println("ERROR");
JOptionPane.showMessageDialog(null, "ERROR WRONG PASSWORD OR USERNAME");
}
}
}
);
cancel.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
System.exit(0);
}
});
jf.add(panel,BorderLayout.CENTER);
jf.setTitle("LOGIN PAGE");
jf.setSize(450,350);
jf.setVisible(true);
} 
public static void main(String[] args)
{
mainpage m=new mainpage();
SimpleDateFormat df=new SimpleDateFormat("ddMMyyyy");
Date d=new Date();
cdate=df.format(d);
System.out.println(cdate);
}
}