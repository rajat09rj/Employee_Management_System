import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.stage.FileChooser;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
class add  implements ActionListener
{
JFrame f;
JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16,id17,lab,lab1;
JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
JButton b,b1,b2,b3;
 public int count=0;
    public static InputStream is,is1;
//.............  
public static File file,compressedImageFile;
    public static Image scaled;
    private File chooseFile;
    private String imageString;
    public static ByteArrayOutputStream boas;
add(int i){
}
add()
{
 f=new JFrame("Add Employee");
f.setVisible(true);
f.setSize(900,700);
f.setLocation(400,0);
f.setBackground(Color.white);
f.setLayout(null);


id15=new JLabel();
id15.setBounds(0,0,900,700);
id15.setLayout(null);
ImageIcon img=new ImageIcon("7.jpg");
id15.setIcon(img);

 id8 = new JLabel("Add New Employee Detail:");
id8.setBounds(50,10,500,50);
id8.setFont(new Font("serif",Font.ITALIC,25));
id8.setForeground(Color.black);
id15.add(id8);
f.add(id15);


 id1 = new JLabel("Name:");
id1.setBounds(50,60,100,30);
id1.setFont(new Font("serif",Font.BOLD,20));
id15.add(id1);

 t1=new JTextField();
t1.setBounds(200,60,150,30);
id15.add(t1);

id2 = new JLabel("Father's Name:");
id2.setBounds(400,60,200,30);
id2.setFont(new Font("serif",Font.BOLD,20));
id15.add(id2);

t2=new JTextField();
t2.setBounds(600,60,150,30);
id15.add(t2);

 id3= new JLabel("Age:");
id3.setBounds(50,110,100,30);
id3.setFont(new Font("serif",Font.BOLD,20));
id15.add(id3);

 t3=new JTextField();
t3.setBounds(200,110,150,30);
id15.add(t3);

 id4= new JLabel("Date Of Birth:");
id4.setBounds(400,110,200,30);
id4.setFont(new Font("serif",Font.BOLD,20));
id15.add(id4);

 t4=new JTextField();
t4.setBounds(600,110,150,30);
id15.add(t4);

 id5= new JLabel("Address:");
id5.setBounds(50,160,100,30);
id5.setFont(new Font("serif",Font.BOLD,20));
id15.add(id5);

 t5=new JTextField();
t5.setBounds(200,160,150,30);
id15.add(t5);

 id6= new JLabel("Mobile NO:");
id6.setBounds(400,160,100,30);
id6.setFont(new Font("serif",Font.BOLD,20));
id15.add(id6);

 t6=new JTextField();
t6.setBounds(600,160,150,30);
id15.add(t6);

 id7= new JLabel("Email Id:");
id7.setBounds(50,210,100,30);
id7.setFont(new Font("serif",Font.BOLD,20));
id15.add(id7);

 t7=new JTextField();
t7.setBounds(200,210,150,30);
id15.add(t7);

id9= new JLabel("Education:");
id9.setBounds(400,210,100,30);
id9.setFont(new Font("serif",Font.BOLD,20));
id15.add(id9);

t8=new JTextField();
t8.setBounds(600,210,150,30);
id15.add(t8);

id10= new JLabel("Job Post:");
id10.setBounds(50,250,100,30);
id10.setFont(new Font("serif",Font.BOLD,20));
id15.add(id10);

t9=new JTextField();
t9.setBounds(200,250,150,30);
id15.add(t9);


id11= new JLabel("Aadhar No:");
id11.setBounds(400,250,100,30);
id11.setFont(new Font("serif",Font.BOLD,20));
id15.add(id11);

 t10=new JTextField();
t10.setBounds(600,250,150,30);
id15.add(t10);

id12= new JLabel("Employee Id:");
id12.setBounds(50,300,150,30);
id12.setFont(new Font("serif",Font.BOLD,20));
id15.add(id12);

t11=new JTextField();
t11.setBounds(200,300,150,30);
id15.add(t11);

id16= new JLabel("Id proof                          :");
id16.setBounds(50,350,150,30);
id16.setFont(new Font("serif",Font.BOLD,20));
id15.add(id16);

 t12=new JTextField();
t12.setBounds(200,350,150,30);
id15.add(t12);

b2=new JButton("Browse");
b2.setBounds(350,350,100,30);
b2.addActionListener(this);
id15.add(b2);

id17= new JLabel("Image:");
id17.setBounds(400,300,150,30);
id17.setFont(new Font("serif",Font.BOLD,20));
id15.add(id17);

 t13=new JTextField();
t13.setBounds(600,300,150,30);
id15.add(t13);

b3=new JButton("browse");
b3.setBounds(750,300,100,30);
b3.addActionListener(this);
id15.add(b3);

lab=new JLabel();
		lab.setBounds(200,350,250,200);
		id15.add(lab);

lab1=new JLabel("");
		lab1.setBounds(600,350,250,200);
		id15.add(lab1);



b=new JButton("Submit");
b.setBounds(250,600,100,30);
b.addActionListener(this);
id15.add(b);

 b1=new JButton("Cancel");
b1.setBounds(450,600,100,30);
b1.addActionListener(this);
id15.add(b1);
}


public void imagefolder()
    {
        try
     {

         JFileChooser filechooser=new JFileChooser();
         filechooser.setMultiSelectionEnabled(false);
         filechooser.showOpenDialog(f);
         
         chooseFile=filechooser.getSelectedFile();
         
         if(chooseFile.length()>71680)
                    {
                     compressedImageFile=new File("tempImage.jpg");
                   BufferedImage image=ImageIO.read(chooseFile); 
                    FileOutputStream os=new FileOutputStream(compressedImageFile);
                    Iterator<ImageWriter>writers=ImageIO.getImageWritersByFormatName("jpg");
                    ImageWriter writer=(ImageWriter) writers.next();
                    
                    
                    ImageOutputStream ios=ImageIO.createImageOutputStream(os);
                    writer.setOutput(ios);
                    ImageWriteParam param=writer.getDefaultWriteParam();
                    
                    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                    param.setCompressionQuality(0.20f);
                    writer.write(null,new IIOImage(image,null,null),param);
                    
                    os.close();
                    ios.close();
                    writer.dispose();
                    
                  
                    }
     else
         {
             compressedImageFile=chooseFile;
         }
     BufferedImage buimage=ImageIO.read(compressedImageFile);
     boas=new ByteArrayOutputStream();
     ImageIO.write(buimage, "jpg", boas);
     byte []ba=boas.toByteArray();
     imageString=Base64.getEncoder().encodeToString(ba);
     BufferedImage bimb=ImageIO.read(compressedImageFile);
     scaled=bimb.getScaledInstance(lab.getWidth(),lab.getHeight(), Image.SCALE_SMOOTH);
     ImageIcon icon=new ImageIcon(scaled);
     lab.setIcon(icon);
    is = new ByteArrayInputStream(ba);
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null,"e");
     } 
    }

public void imagefolder3()
    {
        try
     {

         JFileChooser filechooser=new JFileChooser();
         filechooser.setMultiSelectionEnabled(false);
         filechooser.showOpenDialog(f);
         
         chooseFile=filechooser.getSelectedFile();
         
         if(chooseFile.length()>71680)
                    {
                     compressedImageFile=new File("tempImage.jpg");
                   BufferedImage image=ImageIO.read(chooseFile); 
                    FileOutputStream os=new FileOutputStream(compressedImageFile);
                    Iterator<ImageWriter>writers=ImageIO.getImageWritersByFormatName("jpg");
                    ImageWriter writer=(ImageWriter) writers.next();
                    
                    
                    ImageOutputStream ios=ImageIO.createImageOutputStream(os);
                    writer.setOutput(ios);
                    ImageWriteParam param=writer.getDefaultWriteParam();
                    
                    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                    param.setCompressionQuality(0.20f);
                    writer.write(null,new IIOImage(image,null,null),param);
                    
                    os.close();
                    ios.close();
                    writer.dispose();
                    
                  
                    }
     else
         {
             compressedImageFile=chooseFile;
         }
     BufferedImage buimage=ImageIO.read(compressedImageFile);
     boas=new ByteArrayOutputStream();
     ImageIO.write(buimage, "jpg", boas);
     byte []ba=boas.toByteArray();
     imageString=Base64.getEncoder().encodeToString(ba);
     BufferedImage bimb=ImageIO.read(compressedImageFile);
     scaled=bimb.getScaledInstance(lab1.getWidth(),lab1.getHeight(), Image.SCALE_SMOOTH);
     ImageIcon icon=new ImageIcon(scaled);
     lab1.setIcon(icon);
    is1 = new ByteArrayInputStream(ba);
     }
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null,"e");
     } 
    }




public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rajat","root","");
PreparedStatement ps=con.prepareStatement("Insert into add54 values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
ps.setString(1,t1.getText());
ps.setString(2,t2.getText());
ps.setString(3,t3.getText());
ps.setString(4,t4.getText());
ps.setString(5,t5.getText());
ps.setString(6,t6.getText());
ps.setString(7,t7.getText());
ps.setString(8,t8.getText());
ps.setString(9,t9.getText());
ps.setString(10,t10.getText());
ps.setString(11,t11.getText());
ps.setBlob(12,is);
ps.setBlob(13,is1);
ps.executeUpdate();
JOptionPane.showMessageDialog(null,"successfully inserted!!");
con.close();
f.setVisible(false);
detail d=new detail();
t.setText("");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");

}
catch(Exception e)
{
System.out.println("The error is:"+e);
}
}
if(ae.getSource()==b2)
{

imagefolder();
}
if(ae.getSource()==b3)
{

imagefolder3();
}


if(ae.getSource()==b1)
{

f.setVisible(false);
detail d=new detail();

}
}
public static void main(String[ ] arg)
{
add a=new add();
}
}