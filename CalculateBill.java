// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;



public class CalculateBill extends JFrame implements ActionListener{
    
    //components of swing
    JTextField lbunit;
    JLabel  lbadd;
    JButton next, back;
    JComboBox meternumber, cmonth;
    
    CalculateBill(){
        
        //property of frame
        setSize(800,500);
        setLocation(300,200);
        setResizable(false);
        
        //image icon for this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
      
        //panel with name p
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        //label with name heading
        JLabel heading=new JLabel("Calculate Electricity Bill");
        heading.setBounds(150,15,300,30);
        heading.setFont(new Font("tahoma",Font.BOLD,24));
        heading.setForeground(Color.RED);
        p.add(heading);
        
        //label name with lmeter
        JLabel lmeter=new JLabel("Meter Number");
        lmeter.setFont(new Font("tahoma",Font.BOLD,16));
        lmeter.setBounds(100,80,150,30);
        p.add(lmeter);
        
        //comboBox with name meternumber
        meternumber=new JComboBox();
        try{
            
            //connecting database
            Connect c=new Connect();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                
                //adding all meter number to comboBox  
                meternumber.addItem(rs.getString("meter_no"));
            }
        
        }catch(Exception ae){
           
              // if problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Data not found or server problem");
              
        }
        
        meternumber.setBounds(300,80,180,30);
        p.add(meternumber);
        
        //label with name lname       
        JLabel lname=new JLabel("Name");
        lname.setFont(new Font("tahoma",Font.BOLD,16));
        lname.setBounds(100,130,150,30);
        p.add(lname);
        
        //label with name lbname
        JLabel lbname=new JLabel();
        lbname.setFont(new Font("tahoma",Font.BOLD,16));
        lbname.setBounds(300,130,250,30);
        p.add(lbname);
        
        //label with name  ladd
        JLabel ladd=new JLabel("Address");
        ladd.setFont(new Font("tahoma",Font.BOLD,16));
        ladd.setBounds(100,180,150,30);
        p.add(ladd);
        
        //label with name lbadd
        lbadd=new JLabel();
        lbadd.setFont(new Font("tahoma",Font.BOLD,16));
        lbadd.setBounds(300,180,250,30);
        
        try{
            
            //connecting database
            Connect c=new Connect();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no= '"+meternumber.getSelectedItem()+"'");
            
            while(rs.next()){
                
                //set text to label lbname and lbadd
                lbname.setText(rs.getString("name"));
                lbadd.setText(rs.getString("address"));
            }
            
        }catch(Exception ae){
            // if problem arises then it show a message 
            JOptionPane.showMessageDialog(null, "Data not found or server problem");
              
        }
       
        meternumber.addItemListener(new ItemListener (){
        public @Override void itemStateChanged(ItemEvent ie){
            
            try{
                
                Connect c=new Connect();
                ResultSet rs=c.s.executeQuery("select * from customer where meter_no= '"+meternumber.getSelectedItem()+"'");

                while(rs.next()){
                    lbname.setText(rs.getString("name"));
                    lbadd.setText(rs.getString("address"));
                }
            
           }catch(Exception ae){
               
               // if problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Data not found or server problem");          
           }
        }
        });
        p.add(lbadd);
        
       // label with name lunit
        JLabel lunit=new JLabel("Unit Consumed ");
        lunit.setFont(new Font("tahoma",Font.BOLD,16));
        lunit.setBounds(100,230,150,30);
        p.add(lunit);
        
        //textfield with name lbunit
        lbunit=new JTextField();
        lbunit.setBounds(300,230,180,30);
        p.add(lbunit);
        
        //label with  name lmonth
        JLabel lmonth=new JLabel("Month ");
        lmonth.setFont(new Font("tahoma",Font.BOLD,16));
        lmonth.setBounds(100,280,150,30);
        p.add(lmonth);
        
        //comboBox with name cmonth
        cmonth=new JComboBox();
        cmonth.addItem("JANUARY");
        cmonth.addItem("FEBRUARY");
        cmonth.addItem("MARCH");
        cmonth.addItem("APRIL");
        cmonth.addItem("MAY");
        cmonth.addItem("JUNE");
        cmonth.addItem("JULY");
        cmonth.addItem("AUGUST");
        cmonth.addItem("SEPTEMBER");
        cmonth.addItem("OCTOBER");
        cmonth.addItem("NOVEMBER");
        cmonth.addItem("DECEMBER");
        cmonth.setBounds(300,280,180,30);
        p.add(cmonth);
        
        //button with name next
        next=new JButton("SUBMIT");
        next.setBounds(120,400,150,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        p.add(next);
        next.addActionListener(this);
        
        //button with name back
        back=new JButton("CANCEL");
        back.setBounds(330,400,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        p.add(back);
        back.addActionListener(this);
        
        //setLayout and add their position
        setLayout(new BorderLayout ());
        add(p,"Center");
        
        //image that set on this frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image,"West");
        
        //property with frame
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public @Override void actionPerformed(ActionEvent e){
        
        //checking which button clicked
        if(e.getSource()==next){
            
            //storing data that entered by user
            String smeter=(String)meternumber.getSelectedItem();
            String sunit=(String)lbunit.getText();
            String month=(String)cmonth.getSelectedItem();
            
            //intialise variable
            int totalbill=0;
            int unit_consumed=Integer.parseInt(sunit);
                     
            String query="select * from tax";
            
            try{
                
                // connecting database
                Connect c=new Connect();
                ResultSet rs=c.s.executeQuery(query);
                
                while(rs.next()){
                    
                  // calculating bill
                  totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                  totalbill +=Integer.parseInt(rs.getString("meter_rent"));
                  totalbill +=Integer.parseInt(rs.getString("service_charge"));
                  totalbill +=Integer.parseInt(rs.getString("service_tax"));
                  totalbill +=Integer.parseInt(rs.getString("swacch_bharat_tax"));
                  totalbill +=Integer.parseInt(rs.getString("fixed_tax"));
                }
            }catch(Exception ae){
                
                // if problem arises then it show a message 
                JOptionPane.showMessageDialog(null, "Data not found or server problem");
              
            }
            
            //query that execute 
            
            String query2="insert into bill values('"+smeter+"', '"+month+"', '"+sunit+"', '"+totalbill+"','Not Paid')";
            
            try{
                
                //connecting databases
                Connect c=new Connect();
                c.s.executeUpdate(query2);
                
                //after completion
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                lbunit.setText("");
               
                
            }catch(Exception ae){
                
                // if problem arises then it show a message 
               JOptionPane.showMessageDialog(null, "Data not found or server problem");
              
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String args[]) {
        
        //creating obj for testing this frame
        new CalculateBill();
    }
}
