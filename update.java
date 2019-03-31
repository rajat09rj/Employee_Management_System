import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
class update extends add  implements ActionListener
{
JFrame f;
JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1;
JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
JButton b,b1,b2,b3; 
String id_emp;
update(String idaa)
{
super(0);
 f=new JFrame("update Employee details");
f.setVisible(true);
f.setSize(900,500);
f.setLocation(400,0);
f.setBackground(Color.white);
f.setLayout(null);

id_emp=idaa;
id15=new JLabel();
id15.setBounds(0,0,900,500);
id15.setLayout(null);
ImageIcon img=new ImageIcon("7.jpg");
id15.setIcon(img);

 id8 = new JLabel("Update Employee Detail:");
id8.setBounds(50,10,500,50);
id8.setFont(new Font("serif",Font.ITALIC,40));
id8.setForeground(Color.black);
id15.add(id8);
f.add(id15);


 id1 = new JLabel("Name:");
id1.setBounds(50,100,100,30);
id1.setFont(new Font("serif",Font.BOLD,20));
id15.add(id1);

 t1=new JTextField();
t1.setBounds(200,100,150,30);
id15.add(t1);

id2 = new JLabel("Father's Name:");
id2.setBounds(400,100,200,30);
id2.setFont(new Font("serif",Font.BOLD,20));
id15.add(id2);

t2=new JTextField();
t2.setBounds(600,100,150,30);
id15.add(t2);

 id3= new JLabel("Address:");
id3.setBounds(50,150,100,30);
id3.setFont(new Font("serif",Font.BOLD,20));
id15.add(id3);

 t3=new JTextField();
t3.setBounds(200,150,150,30);
id15.add(t3);

 id4= new JLabel("Mobile No:");
id4.setBounds(400,150,100,30);
id4.setFont(new Font("serif",Font.BOLD,20));
id15.add(id4);

 t4=new JTextField();
t4.setBounds(600,150,150,30);
id15.add(t4);

 id5= new JLabel("Email Id:");
id5.setBounds(50,200,100,30);
id5.setFont(new Font("serif",Font.BOLD,20));
id15.add(id5);

 t5=new JTextField();
t5.setBounds(200,200,150,30);
id15.add(t5);

 id6= new JLabel("Education:");
id6.setBounds(400,200,100,30);
id6.setFont(new Font("serif",Font.BOLD,20));
id15.add(id6);

 t6=new JTextField();
t6.setBounds(600,200,150,30);
id15.add(t6);

 id7= new JLabel("Job Post:");
id7.setBounds(50,250,100,30);
id7.setFont(new Font("serif",Font.BOLD,20));
id15.add(id7);

 t7=new JTextField();
t7.setBounds(200,250,150,30);
id15.add(t7);

id9= new JLabel("Aadhar No:");
id9.setBounds(400,250,100,30);
id9.setFont(new Font("serif",Font.BOLD,20));
id15.add(id9);

 t8=new JTextField();
t8.setBounds(600,250,150,30);
id15.add(t8);

id10= new JLabel("Employee Id:");
id10.setBounds(50,300,150,30);
id10.setFont(new Font("serif",Font.BOLD,20));
id15.add(id10);
f.setVisible(false);
 t9=new JTextField();
t9.setBounds(200,300,150,30);
id15.add(t9);



b=new JButton("update");
b.setBounds(250,400,100,30);
b.addActionListener(this);
id15.add(b);

 b1=new JButton("Cancel");
b1.setBounds(450,400,100,30);
b1.addActionListener(this);
id15.add(b1);
showData(idaa);
}
int i=0;
String age,dat;
void showData(String s){
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rajat","root","");
PreparedStatement ps=con.prepareStatement("select * from add54  where employee_id = ?");
ps.setString(1,s);
ResultSet rs=ps.executeQuery();
if(rs.next()){
f.setVisible(true);
i=1;
t1.setText(rs.getString(1));
t2.setText(rs.getString(2));
t3.setText(rs.getString(5));
t4.setText(rs.getString(6));
t5.setText(rs.getString(7));
t6.setText(rs.getString(8));
t7.setText(rs.getString(9));
t8.setText(rs.getString(10));
t9.setText(rs.getString(11));

age=rs.getString(3);

dat=rs.getString(4);

}
if(i==0)
JOptionPane.showMessageDialog(null,"Id not found");
new search();
}catch(Exception ex){

}


}



public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b && i==1)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rajat","root","");


PreparedStatement ps=con.prepareStatement("update add54 set name=?,father_name=?,age=?,dob=?,address=?,mobile=?,email_id=?,education=?,job_post=?,aadhar_no=?,employee_id=? where employee_id=?");

ps.setString(12,id_emp);
ps.setString(1,t1.getText());
ps.setString(2,t2.getText());
ps.setString(3,age);
ps.setString(4,dat);
ps.setString(5,t3.getText());
ps.setString(6,t4.getText());
ps.setString(7,t5.getText());
ps.setString(8,t6.getText());
ps.setString(9,t7.getText());
ps.setString(10,t8.getText());
ps.setString(11,t9.getText());
ps.executeUpdate();
JOptionPane.showMessageDialog(null,"successfully updated");
f.setVisible(false);
search s=new search();

}
catch(Exception e)
{
System.out.println("The error is:"+e);

}


}

if(ae.getSource()==b1)
{

f.setVisible(false);
detail d=new detail();

}
}
/*public static void main(String[ ] arg)
{
update u=new update();
}*/
}