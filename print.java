 import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.stage.FileChooser;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import java.sql.*;
class print implements ActionListener
{
JFrame f;
JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id9,id10,id11,id12,id13,id14,id15,id16,id17,lab;
String E_id,E_name,E_father,E_address,E_mobile,E_email,E_education,E_job;
JButton b,b1;
Blob blob;
BufferedImage  bufferedImage;
 ImageIcon icon;
print(String E_id)
{

try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rajat","root","");

PreparedStatement ps=con.prepareStatement(" select * from add54 where (employee_id=?) ");

ps.setString(1,E_id);
ResultSet rs=ps.executeQuery();

while(rs.next())
{


E_id=rs.getString("employee_id");
E_name=rs.getString("name");
E_father=rs.getString("father_name");
E_address=rs.getString("address");
E_mobile=rs.getString("mobile");
E_email=rs.getString("email_id");
E_education=rs.getString("education");
E_job=rs.getString("job_post");

 blob = rs.getBlob("Image");
              int blobLength = (int) blob.length();
   byte[] blobAsBytes = blob.getBytes(1, blobLength);
  
  icon=new ImageIcon(new ImageIcon(blobAsBytes).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
 }
     

}catch(Exception e)
{
//JOptionPane.showMessageDialog(null,"Error in Select"+e);
e.printStackTrace();
}
 f=new JFrame("print");
f.setVisible(true);
f.setSize(595,642);
f.setLocation(400,0);
f.setBackground(Color.white);
f.setLayout(null);

 
lab=new JLabel();
lab.setBounds(430,100,100,100);
lab.setIcon(icon);
f.add(lab);


id9=new JLabel();
id9.setBounds(0,0,595,642);
id9.setLayout(null);
ImageIcon img=new ImageIcon("16.jpg");
id9.setIcon(img);

id8 = new JLabel("Employee Detail Is:");
id8.setBounds(50,10,250,30);
f.add(id8);
id8.setFont(new Font("serif",Font.BOLD,25));
id9.add(id8);
f.add(id9);

 id = new JLabel("Employee Id:");
id.setBounds(50,70,120,30);
id.setFont(new Font("serif",Font.BOLD,20));
id9.add(id);

 aid = new JLabel(E_id);
aid.setBounds(170,70,200,30);
aid.setFont(new Font("serif",Font.BOLD,20));
id9.add(aid);

 id10=new JLabel();
id10.setBounds(200,70,150,30);
id9.add(id10);

 id1 = new JLabel("Name:");
id1.setBounds(50,120,100,30);
id1.setFont(new Font("serif",Font.BOLD,20));
id9.add(id1);

 aid1 = new JLabel(E_name);
aid1.setBounds(130,120,300,30);
aid1.setFont(new Font("serif",Font.BOLD,20));
id9.add(aid1);

 id11=new JLabel();
id11.setBounds(200,120,150,30);
id9.add(id11);

 id2 = new JLabel("Father's Name:");
id2.setBounds(50,170,200,30);
id2.setFont(new Font("serif",Font.BOLD,20));
id9.add(id2);

 aid2 = new JLabel(E_father);
aid2.setBounds(200,170,300,30);
aid2.setFont(new Font("serif",Font.BOLD,20));
id9.add(aid2);
 
id12=new JLabel();
id12.setBounds(200,170,150,30);
id9.add(id12);

 id3= new JLabel("Address:");
id3.setBounds(50,220,100,30);
id3.setFont(new Font("serif",Font.BOLD,20));
id9.add(id3);

 aid3= new JLabel(E_address);
aid3.setBounds(150,220,300,30);
aid3.setFont(new Font("serif",Font.BOLD,20));
id9.add(aid3);

 id13=new JLabel();
id13.setBounds(200,220,150,30);
id9.add(id13);

 id4= new JLabel("Mobile No:");
id4.setBounds(50,270,100,30);
id4.setFont(new Font("serif",Font.BOLD,20));
id9.add(id4);

 aid4= new JLabel(E_mobile);
aid4.setBounds(150,270,300,30);
aid4.setFont(new Font("serif",Font.BOLD,20));
id9.add(aid4);

id14=new JLabel();
id14.setBounds(200,270,150,30);
id9.add(id14);

 id5= new JLabel("Email Id:");
id5.setBounds(50,320,100,30);
id5.setFont(new Font("serif",Font.BOLD,20));
id9.add(id5);

 aid5= new JLabel(E_email);
aid5.setBounds(150,320,300,30);
aid5.setFont(new Font("serif",Font.BOLD,20));
id9.add(aid5);

id15=new JLabel();
id15.setBounds(200,320,150,30);
id9.add(id15);

 id6= new JLabel("Education:");
id6.setBounds(50,370,100,30);
id6.setFont(new Font("serif",Font.BOLD,20));
id9.add(id6);

 aid6= new JLabel(E_education);
aid6.setBounds(150,370,300,30);
aid6.setFont(new Font("serif",Font.BOLD,20));
id9.add(aid6);

 id16=new JLabel();
id16.setBounds(200,370,150,30);
id9.add(id16);

 id7= new JLabel("Job Post:");
id7.setBounds(50,420,100,30);
id7.setFont(new Font("serif",Font.BOLD,20));
id9.add(id7);

 aid7= new JLabel(E_job);
aid7.setBounds(150,420,300,30);
aid7.setFont(new Font("serif",Font.BOLD,20));
id9.add(aid7);

id17=new JLabel();
id17.setBounds(200,420,150,30);
id9.add(id17);

 b=new JButton("Print");
b.setBounds(100,520,100,30);
b.addActionListener(this);
id9.add(b);

 b1=new JButton("cancel");
b1.setBounds(250,520,100,30);
b1.addActionListener(this);
id9.add(b1);


}
public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b)
{
JOptionPane.showMessageDialog(null,"printed successfully");
f.setVisible(false);
detail d=new detail();
}

if(ae.getSource()==b1)
{
f.setVisible(false);
view v=new view();
}
}

}