// Importing some java packages for swing and use of some property of awt,util, sql and event
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;



public class NewCustomer extends JFrame implements ActionListener{
    
    //swing components with specific variable name
    JTextField tname, tadd, tcity, tstate, temail, tphone;
    JLabel lbmeter;
    JButton next, back;
    
    NewCustomer(){
        
        //Here, some frame property we implements for this frame
        setSize(800,550);
        setLocation(300,200);
        setResizable(false);
        
        //A image icon of  this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
        
        //Jpanel with name p
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        //label with name heading
        JLabel heading=new JLabel("New Customer");
        heading.setBounds(200,10,200,30);
        heading.setFont(new Font("tahoma",Font.BOLD,24));
        p.add(heading);
        
        //label with lname
        JLabel lname=new JLabel("Customer Name ");
        lname.setFont(new Font("tahoma",Font.BOLD,16));
        lname.setBounds(100,80,200,30);
        p.add(lname);
        
        //textfield with tname
        tname=new JTextField();
        tname.setBounds(300,80,250,30);
        p.add(tname);
        
        //label with lmeter
        JLabel lmeter=new JLabel("Meter Number ");
        lmeter.setFont(new Font("tahoma",Font.BOLD,16));
        lmeter.setBounds(100,130,150,30);
        p.add(lmeter);
        
        //label with lbmeter
        lbmeter=new JLabel("");
        lbmeter.setFont(new Font("tahoma",Font.BOLD,16));
        lbmeter.setBounds(300,130,150,30);
        p.add(lbmeter);
        
        // It generates random number for meter using Random class
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        String num = "" + Math.abs(number);

        try {
            
            //connection stablish with database
            Connect c = new Connect();

            // Check if the generated meter number already exists in the database
            String query = "SELECT * FROM bill WHERE meter_no = '" + num + "'";
            ResultSet rs = c.s.executeQuery(query);
                
            // If the meter number already exists, generate a new one until a unique one is found
            while (rs.next()) {
                number = ran.nextLong() % 1000000;
                num = "" + Math.abs(number);
                
                // Recheck if the new meter number exists in the database
                rs = c.s.executeQuery("SELECT * FROM bill WHERE meter_no = '" + num + "'");
            }

            // Now 'num' contains a unique meter number, you can use it as needed
            lbmeter.setText(num);

        } catch (Exception e) {
             // if user not valid then it show a message 
             JOptionPane.showMessageDialog(null, "Server Error");
                    
        }
    
        //label with ladd
        JLabel ladd=new JLabel("Address ");
        ladd.setFont(new Font("tahoma",Font.BOLD,16));
        ladd.setBounds(100,180,150,30);
        p.add(ladd);
        
        //JTextField with tadd
        tadd=new JTextField();
        tadd.setBounds(300,180,250,30);
        p.add(tadd);
        
        //label with lcity
        JLabel lcity=new JLabel("City ");
        lcity.setFont(new Font("tahoma",Font.BOLD,16));
        lcity.setBounds(100,230,150,30);
        p.add(lcity);
        
        //JTextField with tcity
        tcity=new JTextField();
        tcity.setBounds(300,230,250,30);
        p.add(tcity);
        
        //label with lstate
        JLabel lstate=new JLabel("State ");
        lstate.setFont(new Font("tahoma",Font.BOLD,16));
        lstate.setBounds(100,280,150,30);
        p.add(lstate);
        
        //JTextField with tstate
        tstate=new JTextField();
        tstate.setBounds(300,280,250,30);
        p.add(tstate);
        
        //label with lemail
        JLabel lemail=new JLabel("Email-ID ");
        lemail.setFont(new Font("tahoma",Font.BOLD,16));
        lemail.setBounds(100,330,150,30);
        p.add(lemail);
        
        //JTextField with temail
        temail=new JTextField();
        temail.setBounds(300,330,250,30);
        p.add(temail);
        
        //label with lphone
        JLabel lphone=new JLabel("Phone No.");
        lphone.setFont(new Font("tahoma",Font.BOLD,16));
        lphone.setBounds(100,380,150,30);
        p.add(lphone);
        
        //JTextField with tphone
        tphone=new JTextField();
        tphone.setBounds(300,380,250,30);
        p.add(tphone);
        
        //button with next name
        next=new JButton("NEXT");
        next.setBounds(150,450,150,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        p.add(next);
        next.addActionListener(this);
        
        //button with back name
        back=new JButton("BACK");
        back.setBounds(350,450,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        p.add(back);
        back.addActionListener(this);
        
        //setLayout for this frame
        setLayout(new BorderLayout ());
        add(p,"Center");
        
        //A image that put in this frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image,"West");
        
        //some other property applied for this frame
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public @Override void actionPerformed(ActionEvent e){
        
        if(e.getSource()==next){
            String sname=tname.getText();
            String smeter=lbmeter.getText();
            String sadd=tadd.getText();
            String scity=tcity.getText();
            String sstate=tstate.getText();
            String semail=temail.getText();
            String sphone=tphone.getText();
            
            //query for 
            String query1="insert into customer values('"+sname+"', '"+smeter+"', '"+sadd+"', '"+scity+"', '"+sstate+"', '"+semail+"', '"+sphone+"')";
            String query2="insert into login values('"+smeter+"' ,'', '"+sname+"', '', 'Customer')";
            
            try{
                
                //connecting with database
                Connect c=new Connect();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                //current frame disable
                setVisible(false);
                
                //new Frame ppen
                new MeterInfo(smeter);
                
                
            }catch(Exception ae){
                //if any Exception arises then it show a message
                JOptionPane.showMessageDialog(null, "Server not responding");
                
            }
            
            
        }else{
            
            //if user click on back then frame close
            setVisible(false);
            
        }
    }

    
    public static void main(String args[]) {
        
        //we create a object for constructor call and checking of this module
        new NewCustomer();
    }
}
