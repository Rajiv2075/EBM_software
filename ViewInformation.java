// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class ViewInformation extends JFrame implements ActionListener {
    
     //swing components with specific variable name
    JLabel dname, dmeter, dadd, dcity, dstate, demail, dphone;
    JButton back;
    String meter;
    
    ViewInformation(String meter){
        
        //store value formal to actual
        this.meter=meter;
        
        //property for this frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        setSize(900,670);
        setLocation(250,100);
        
        //Image icon for this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
      
        //jlabel with name heading
        JLabel heading =new JLabel("VIEW  CUSTOMER  INFORMATION");
        heading.setBounds(250,20,500,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBackground(Color.white);
        heading.setForeground(Color.BLUE);
        add(heading);
        
        //label with name lname
        JLabel lname =new JLabel("NAME");
        lname.setBounds(100,100,150,30);
        lname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lname);
        
        //label with name dname
        dname =new JLabel("");
        dname.setBounds(300,100,200,30);
        dname.setFont(new Font("Tahoma",Font.BOLD,16));
        dname.setForeground(Color.MAGENTA);
        add(dname);
        
        //label with name lmeter
        JLabel lmeter =new JLabel("METER NUMBER");
        lmeter.setBounds(100,150,150,30);
        lmeter.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lmeter);
        
        //label with name dmeter
        dmeter =new JLabel("");
        dmeter.setBounds(300,150,200,30);
        dmeter.setFont(new Font("Tahoma",Font.BOLD,16));
        dmeter.setForeground(Color.RED);
        add(dmeter);
        
        //label with name ladd
        JLabel ladd =new JLabel("ADDRESS");
        ladd.setBounds(100,200,150,30);
        ladd.setFont(new Font("Tahoma",Font.BOLD,16));
        add(ladd);
        
        //label with name dadd
        dadd =new JLabel("");
        dadd.setBounds(300,200,200,30);
        dadd.setFont(new Font("Tahoma",Font.BOLD,16));
        dadd.setForeground(Color.MAGENTA);
        add(dadd);
        
        //label with name lcity
        JLabel lcity =new JLabel("CITY");
        lcity.setBounds(  500,100,200,30  );
        lcity.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lcity);
        
        //label with name dcity
        dcity =new JLabel("");
        dcity.setBounds( 720,100,200,30  );
        dcity.setFont(new Font("Tahoma",Font.BOLD,16));
        dcity.setForeground(Color.MAGENTA);
        add(dcity);
        
        //label with name lstate
        JLabel lstate =new JLabel("STATE");
        lstate.setBounds(500,150,200,30);
        lstate.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lstate);
        
        //label with name dstate
        dstate =new JLabel("");
        dstate.setBounds(720,150,200,30);
        dstate.setFont(new Font("Tahoma",Font.BOLD,16));
        dstate.setForeground(Color.MAGENTA);
        add(dstate);
        
        ////label with name lemail
        JLabel lemail =new JLabel("EMAIL-ID");
        lemail.setBounds(100,250,150,30);
        lemail.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lemail);
        
        //label with name demail
        demail =new JLabel("");
        demail.setBounds(300,250,350,30 );
        demail.setFont(new Font("Tahoma",Font.BOLD,16));
        demail.setForeground(Color.MAGENTA);
        add(demail);
        
        //label with name lphone
        JLabel lphone =new JLabel("PHONE NUMBER");
        lphone.setBounds(500,200,200,30);
        lphone.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lphone);
        
        //label with name dphone
        dphone =new JLabel("");
        dphone.setBounds(720,200,200,30);
        dphone.setFont(new Font("Tahoma",Font.BOLD,16));
        dphone.setForeground(Color.MAGENTA);
        add(dphone);
        
        try{
            
            //connecting with database
            Connect c=new Connect();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            
            while(rs.next()){
                
                //accessing and set data from table
                dname.setText(rs.getString("name"));
                dmeter.setText(rs.getString("meter_no"));
                dadd.setText(rs.getString("address"));
                dcity.setText(rs.getString("city"));
                dstate.setText(rs.getString("state"));
                demail.setText(rs.getString("email"));
                dphone.setText(rs.getString("phone"));
            }
            
            
        }catch(Exception e){
           
              // if problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Data not found or server problem");
              
        }
        
        //button with name back
        back=new JButton("BACK");
        back.setBounds(350,320,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);
        
        //image of the frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,320,700,300);
        add(image);
        
        //visible to all
        setVisible(true);
    }
    
    public @Override void actionPerformed(ActionEvent e){
        
        //checking which data create
        if(e.getSource()==back){
            
            setVisible(false);
        }
        
    }

    
    public static void main(String args[]) {
        
         //creating obj for testing this frame
        new ViewInformation("");
    }
}
