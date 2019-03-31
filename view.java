import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class view implements ActionListener
{
JFrame f;
JTextField t;
JLabel l,l5;
JButton b,b2;

view()
{
f=new JFrame("View");
f.setSize(500,270);
f.setLocation(300,50);
f.setVisible(true);
f.setBackground(Color.green);
f.setLayout(null);

l5=new JLabel();
l5.setBounds(0,0,500,270);
l5.setLayout(null);
ImageIcon img=new ImageIcon("20.jpg");
l5.setIcon(img);


l=new JLabel("Employee Id");
l.setVisible(true);
l.setBounds(40,50,250,30);
l.setForeground(Color.white);
Font F1=new Font("serif",Font.BOLD,30);
l.setFont(F1); 
l5.add(l);
f.add(l5);




t=new JTextField();
t.setBounds(240,50,220,30);
l5.add(t);

 

b=new JButton("Search");
b.setBounds(240,150,100,30);
b.addActionListener(this);
l5.add(b);


b2=new JButton("Cancel");
b2.setBounds(360,150,100,30);
b2.addActionListener(this);
l5.add(b2);
}

public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b2)
{
f.setVisible(false);
detail d=new detail();
}

if(ae.getSource()==b)
{
f.setVisible(false);
print p=new print(t.getText());
}

}
public static void main(String[]ar)
{
view v=new view();
}
}