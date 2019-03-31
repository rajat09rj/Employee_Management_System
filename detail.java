import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class detail  implements ActionListener 
{
JFrame f;
JLabel id,id1;
JButton b1,b2,b3,b4;
detail()
{

 f=new JFrame("Employee Detail");
f.setVisible(true);
f.setSize(700,500);
f.setLocation(400,100);
f.setBackground(Color.white);
f.setLayout(null);


id=new JLabel();
id.setBounds(0,0,700,500);
id.setLayout(null);
ImageIcon img=new ImageIcon("12.jpg");
id.setIcon(img);



 id1=new JLabel("Employee Detail:");
id1.setBounds(440,20,200,40);
id1.setFont(new Font("serif",Font.BOLD,25));
id1.setForeground(Color.black);
id.add(id1);
f.add(id);

 b1=new JButton("Add");
b1.setBounds(420,80,100,40);
b1.setFont(new Font("serif",Font.BOLD,15));
b1.addActionListener(this);
id.add(b1);


 b2=new JButton("View");
b2.setBounds(530,80,100,40);
b2.setFont(new Font("serif",Font.BOLD,15));
b2.addActionListener(this);
id.add(b2);

 b3=new JButton("Remove");
b3.setBounds(420,140,100,40);
b3.setFont(new Font("serif",Font.BOLD,15));
b3.addActionListener(this);
id.add(b3);

 b4=new JButton("Update");
b4.setBounds(530,140,100,40);
b4.setFont(new Font("serif",Font.BOLD,15));
b4.addActionListener(this);
id.add(b4);

/* b5=new JButton("Encrypt");
b5.setBounds(420,200,100,40);
b5.setFont(new Font("serif",Font.BOLD,15));
b5.addActionListener(this);
id.add(b5);

 b6=new JButton("Decrypt");
b6.setBounds(530,200,100,40);
b6.setFont(new Font("serif",Font.BOLD,15));
b6.addActionListener(this);
id.add(b6);*/
}
public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b1)
{
f.setVisible(false);
add a=new add();
}


if(ae.getSource()==b2)
{
f.setVisible(false);
view v=new view();
}

if(ae.getSource()==b3)
{
f.setVisible(false);
remove r=new remove();
}

if(ae.getSource()==b4)
{
f.setVisible(false);
search s=new search();
}
}
public static void main(String[ ] arg)
{
detail d=new detail();
}

}