import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class login  implements ActionListener    
{
JFrame f;
JLabel id,id1,id2,id3,id4,id5;
JTextField t1;
JPasswordField t2;
JButton b1,b2,b4;
String s1,s2,user_type;
JRadioButton rd_Admin,rd_emp;
ButtonGroup bg;
ImageIcon img;
login()
{
bg=new ButtonGroup();
 f=new JFrame("Login");
f.setVisible(true);
f.setSize(750,350);
f.setLocation(200,200);
f.setBackground(Color.white);
f.setLayout(null);

id=new JLabel();
id.setBounds(0,0,750,350);
id.setLayout(null); 
img=new ImageIcon("4.jpg");
id.setIcon(img);

 id1=new JLabel("Login");
id1.setBounds(100,0,100,50);
id1.setFont(new Font("serif",Font.BOLD,25));
id1.setForeground(Color.white);
id.add(id1);
f.add(id);

 id4=new JLabel("Admin");
id4.setBounds(50,40,70,40);
id4.setFont(new Font("serif",Font.BOLD,15));
id4.setForeground(Color.white);
id.add(id4);

rd_Admin=new JRadioButton();
rd_Admin.setBounds(20,50,20,20);
id.add(rd_Admin);
bg.add(rd_Admin);


 id5=new JLabel("Employee");
id5.setBounds(150,40,70,40);
id5.setFont(new Font("serif",Font.BOLD,15));
id5.setForeground(Color.white);
id.add(id5);

rd_emp=new JRadioButton();
rd_emp.setBounds(100,50,20,20);
id.add(rd_emp);
bg.add(rd_emp);

id2=new JLabel("Login Id");
id2.setBounds(20,80,100,40);
id2.setFont(new Font("serif",Font.BOLD,20));
id2.setForeground(Color.white);
id.add(id2);

id3=new JLabel("Password");
id3.setBounds(20,130,100,40);
id3.setFont(new Font("serif",Font.BOLD,20));
id3.setForeground(Color.white);
id.add(id3);


 t1=new JTextField();
t1.setBounds(130,80,150,40);
id.add(t1);

 t2=new JPasswordField();
t2.setBounds(130,130,150,40);
id.add(t2);


 b1=new JButton("Login");
b1.setBounds(30,200,100,40);
b1.setFont(new Font("serif",Font.BOLD,15));
b1.addActionListener(this);
id.add(b1);

 b2=new JButton("Cancel");
b2.setBounds(150,200,100,40);
b2.setFont(new Font("serif",Font.BOLD,15));
id.add(b2);
b2.addActionListener(this);

/* b4=new JButton("Forget Password");
b4.setBounds(70,250,150,25);
b4.setFont(new Font("serif",Font.BOLD,15));
id.add(b4);
b4.addActionListener(this);*/
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b2)
{
f.setVisible(false);

//JOptionPane.showMessageDialog(null, "");
}

/*if(ae.getSource()==b4)
{
f.setVisible(false);
forget f=new forget();
}*/
if(ae.getSource()==b1)
{
try
{

String s3=t1.getText();
String s4=String.valueOf(t2.getPassword());
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/rajat","root","");
Statement stat=con.createStatement();
if(rd_Admin.isSelected())
{
user_type="Admin";
String sql = "select * from admin";
      ResultSet rs = stat.executeQuery(sql);
rs.first();
            {
                 s1=rs.getString("log_in");
	s2=rs.getString("password");
                  if(s3.equals("") && s4.equals(""))
{
	 JOptionPane.showMessageDialog(null, "enter full detail");
                }
else
{
if(s1.equals(s3) && s2.equals(s4))
{
f.setVisible(false);
detail d=new detail();
}
else
JOptionPane.showMessageDialog(null, "you entered wrong id or password");
}
}}
else if (rd_emp.isSelected()){
user_type="Emp";
}
else{
JOptionPane.showMessageDialog(null,"Select User Type");
}}
catch(Exception ex)
    {
        JOptionPane.showMessageDialog(null, ex);
    }
}}
public static void main(String[ ] arg)
{
login l=new login();
}}