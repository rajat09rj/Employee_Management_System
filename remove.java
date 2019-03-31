import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class remove implements ActionListener
{
JFrame f;
JTextField t;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JButton b,b1,b2,b3;

remove()
{
f=new JFrame("Remove");
f.setSize(500,500);
f.setLocation(300,50);
f.setVisible(true);
f.setBackground(Color.green);
f.setLayout(null);

l5=new JLabel();
l5.setBounds(0,0,500,500);
l5.setLayout(null);
ImageIcon img=new ImageIcon("5.jpg");
l5.setIcon(img);



f.add(l5);


l1=new JLabel("Employee Id");
l1.setBounds(50,50,250,30);
l1.setForeground(Color.white);
Font F2=new Font("serif",Font.BOLD,30); 
l1.setFont(F2);
l5.add(l1);

t=new JTextField();
t.setBounds(250,50,150,30);
l5.add(t);


b=new JButton("Search");
b.setBounds(200,100,100,30);
b.addActionListener(this);
l5.add(b);

b3=new JButton("back");
b3.setBounds(360,100,100,30);
b3.addActionListener(this);
l5.add(b3);


l2=new JLabel("Name:");
l2.setBounds(50,150,250,30);
l2.setForeground(Color.white);
Font F3=new Font("serif",Font.BOLD,20); 
l2.setFont(F3);
l5.add(l2);


l6=new JLabel();
l6.setBounds(150,150,250,30);
l6.setForeground(Color.white);
Font F6=new Font("serif",Font.BOLD,20); 
l6.setFont(F6);
l5.add(l6);



l3=new JLabel("Mobile No:");
l3.setBounds(50,200,250,30);
l3.setForeground(Color.white);
Font F4=new Font("serif",Font.BOLD,20); 
l3.setFont(F4);
l5.add(l3);


l7=new JLabel();
l7.setBounds(150,200,250,30);
l7.setForeground(Color.white);
Font F7=new Font("serif",Font.BOLD,20); 
l7.setFont(F7);
l5.add(l7);



l4=new JLabel("Email Id:");
l4.setBounds(50,250,250,30);
l4.setForeground(Color.white);
Font F5=new Font("serif",Font.BOLD,20); 
l4.setFont(F5);
l5.add(l4);

l8=new JLabel();
l8.setBounds(150,250,250,30);
l8.setForeground(Color.white);
Font F8=new Font("serif",Font.BOLD,20); 
l2.setFont(F8);
l5.add(l8);

b1=new JButton("Remove");
b1.setBounds(120,300,100,30);
b1.addActionListener(this);
l5.add(b1);


b2=new JButton("Cancel");
b2.setBounds(300,300,100,30);
b2.addActionListener(this);
l5.add(b2);
l2.setVisible(false);
l3.setVisible(false);
l4.setVisible(false);
b1.setVisible(false);
b2.setVisible(false);
}

public void actionPerformed(ActionEvent ae)
{


if(ae.getSource()==b)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rajat","root","");
PreparedStatement ps=con.prepareStatement("select name,mobile,email_id from add54  where employee_id = ?");
ps.setString(1,t.getText());
ResultSet rs=ps.executeQuery();
int i=0;
if(rs.next()){
String name=rs.getString(1);
String mob=rs.getString(2);
String email=rs.getString(3);
//***************************************************
l2.setVisible(true);
l3.setVisible(true);
l4.setVisible(true);
b1.setVisible(true);
b2.setVisible(true);
i=1;
l6.setText(name);
l7.setText(mob);
l8.setText(email);
}
if(i==0)
JOptionPane.showMessageDialog(null,"Id not found");
}catch(Exception ex){

}
}

if(ae.getSource()==b1)
{
try
{
System.out.println("deleing data");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rajat","root","");
PreparedStatement ps=con.prepareStatement("delete from add54 where employee_id=?");
ps.setString(1,t.getText());
ps.executeUpdate();
	JOptionPane.showMessageDialog(null,"deleted successfully");
l2.setVisible(false);
l3.setVisible(false);
l4.setVisible(false);
l6.setVisible(false);
l7.setVisible(false);
l8.setVisible(false);
b1.setVisible(false);
b2.setVisible(false);


}catch(Exception ex){
	JOptionPane.showMessageDialog(null,"Exception occured while delting record "+ex);
}

}

if(ae.getSource()==b2)
{
f.setVisible(false);
detail d=new detail();
}
if(ae.getSource()==b3)
{
f.setVisible(false);
detail d=new detail();
}
}

public static void main(String[]ar)
{
remove r=new remove();
}
}