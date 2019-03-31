import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;
class front implements ActionListener         
{
JFrame f; 
JLabel id,l1;
JButton b;
ImageIcon img;
front()
{
 f=new JFrame("Front");
f.setVisible(true);
f.setSize(1360,750);
f.setLocation(0,0);
f.setBackground(Color.red);
f.setLayout(null);


b=new JButton("CLICK HERE TO CONTINUE");
b.setBounds(500,600,300,70);
b.addActionListener(this);


id=new JLabel();
id.setBounds(0,0,1360,750);
id.setLayout(null);
ImageIcon img=new ImageIcon("2.jpg");
id.setIcon(img);

JLabel lid=new JLabel("EMPLOYEE TRACKING SYSTEM");
lid.setBounds(150,30,1500,100);
lid.setFont(new Font("serif",Font.PLAIN,70));
lid.setForeground(Color.red);
id.add(lid);

id.add(b);
f.add(id);
while(true){
	lid.setVisible(false);
	try{Thread.sleep(500);}catch(Exception e){} 
	lid.setVisible(true);
	try{Thread.sleep(500);}catch(Exception e){}
}
}
public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b)
{
f.setVisible(false);
login l=new login();
}
}
public static void main(String[] arg)
{
front f=new front();
}
}