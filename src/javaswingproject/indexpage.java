package javaswingproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class indexpage implements ItemListener
{
public JFrame jf;
public JPanel p;
public JLabel l1,l2,l3,l4;
public JComboBox c1,c2;
public JButton sub,cancel;
String s1[]={"2000-2001","2001-2002","2002-2003","2003-2004","2004-2005","2005-2006","2006-2007"};
String s2[]={"Microsoft","Netflix","Amazon","Flipkart","Google"};
indexpage()
{
jf=new JFrame();

c1=new JComboBox(s1);
c2=new JComboBox(s2);
c1.setSelectedIndex(0);
c2.setSelectedIndex(0);
l1=new JLabel("Select Year");
l2=new JLabel("Select Company");
l3=new JLabel("Selected Year:2000-2001");
l4=new JLabel("Selected Company:None");
sub=new JButton("Submit");
cancel=new JButton("Exit");
p=new JPanel(new GridLayout(4,1));
jf.add(p,BorderLayout.CENTER);
p.add(l1);
p.add(c1);
p.add(l2);
p.add(c2);
p.add(l3);
p.add(l4);
p.add(sub);
p.add(cancel);
l2.setVisible(false);
c2.setVisible(false);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c1.addItemListener(new ItemListener()
{
public void itemStateChanged(ItemEvent ae)
{
l3.setText("Selected Year:"+c1.getSelectedItem());
l4.setText("Selected Company:Microsoft");
l2.setVisible(true);
c2.setVisible(true);
}
}
);
c2.addItemListener(this);
sub.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
System.out.println("SUCCESSFULLY SELECTED "+c1.getSelectedItem()+" "+c2.getSelectedItem());

String abc=c1.getSelectedItem().toString();
abc = abc.substring(0, 4);
System.out.println(abc);
resultpage r=new resultpage(c2.getSelectedItem().toString(),abc);
jf.dispose();
}
}
);
cancel.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
System.exit(0);
}
}
);

jf.setTitle("Selection PAGE");
jf.setSize(450,350);
jf.setVisible(true);
} 
public void itemStateChanged(ItemEvent e)
{
if(e.getSource()==c2)
{
l4.setText("Selected Course:"+c2.getSelectedItem());
}
}
}