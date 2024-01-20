// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdateInformation extends JFrame implements ActionListener{
    
    //swing components with specific variable name
    JLabel dname, dmeter;
    JTextField dadd, dcity, dstate, demail, dphone;
    JButton back, update;
    String meter;
    
    UpdateInformation(String meter){
        //storing value formal to actual argument
        this.meter=meter;
        
        //property applied on  this frame
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        setResizable(false);
        setSize(1050,600);
        setLocation(250,100);
        
        // Image icon for this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
      
        //label with name heading
        JLabel heading =new JLabel("UPDATE  CUSTOMER  INFORMATION");
        heading.setBounds(250,20,500,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBackground(Color.white);
        heading.setForeground(Color.black);
        add(heading);
        
        //lname with name lname
        JLabel lname =new JLabel("NAME");
        lname.setBounds(100,100,150,30);
        lname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lname);
        
        //label with name dname
        dname =new JLabel("");
        dname.setBounds(300,100,200,30);
        dname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(dname);
        
        // label with name lmeter
        JLabel lmeter =new JLabel("METER NUMBER");
        lmeter.setBounds(100,150,150,30);
        lmeter.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lmeter);
        
        // label with name dmeter
        dmeter =new JLabel("");
        dmeter.setBounds(300,150,200,30);
        dmeter.setFont(new Font("Tahoma",Font.BOLD,16));
        add(dmeter);
        
        // label with name ladd
        JLabel ladd =new JLabel("ADDRESS");
        ladd.setBounds(100,200,150,30);
        ladd.setFont(new Font("Tahoma",Font.BOLD,16));
        add(ladd);
        
        // textfield with name dadd
        dadd =new JTextField();
        dadd.setBounds(300,200,200,30);
        dadd.setFont(new Font("Tahoma",Font.BOLD,16));
        add(dadd);
        
        // label with name lcity
        JLabel lcity =new JLabel("CITY");
        lcity.setBounds(100,250,150,30);
        lcity.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lcity);
        
        // textfield with name dcity
        dcity =new JTextField();
        dcity.setBounds(300,250,200,30);
        dcity.setFont(new Font("Tahoma",Font.BOLD,16));
        add(dcity);
        
        // label with name lstate
        JLabel lstate =new JLabel("STATE");
        lstate.setBounds(100,300,150,30);
        lstate.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lstate);
        
        // textfield with name dstate
        dstate =new JTextField();
        dstate.setBounds(300,300,200,30);
        dstate.setFont(new Font("Tahoma",Font.BOLD,16));
        add(dstate);
        
        // label with name lemail
        JLabel lemail =new JLabel("EMAIL-ID");
        lemail.setBounds(100,350,150,30);
        lemail.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lemail);
        
        // textfield with name demail
        demail =new JTextField();
        demail.setBounds(300,350,200,30);
        demail.setFont(new Font("Tahoma",Font.BOLD,16));
        add(demail);
        
        // label with name lphone
        JLabel lphone =new JLabel("PHONE NUMBER");
        lphone.setBounds(100,400,150,30);
        lphone.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lphone);
        
        // textfield with name dphone
        dphone =new JTextField();
        dphone.setBounds(300,400,200,30);
        dphone.setFont(new Font("Tahoma",Font.BOLD,16));
        add(dphone);
        
        try{
            
            //connecting with database
            Connect c=new Connect();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            
            while(rs.next()){
                
                //accessing and set all data from database table
                dname.setText(rs.getString("name"));
                dmeter.setText(rs.getString("meter_no"));
                dadd.setText(rs.getString("address"));
                dcity.setText(rs.getString("city"));
                dstate.setText(rs.getString("state"));
                demail.setText(rs.getString("email"));
                dphone.setText(rs.getString("phone"));
            }
            
            
        }catch(Exception e){
            // if   problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Server not responding");
              
        }
        
        //button with name back
        back=new JButton("CANCEL");
        back.setBounds(330,500,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);
        
        //button with update
        update=new JButton("UPDATE");
        update.setBounds(120,500,150,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);
        update.addActionListener(this);
        
        //image for background
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(600,90,400,350);
        add(image);
        
        
        //visible frame to all
        setVisible(true);
    }

    public @Override void actionPerformed(ActionEvent e){
        
        //checking which button is clicked
        if(e.getSource()==back){
            
            //back then frame close
            setVisible(false);
            
        }else{
            
            //storing data from user and send for update
            String name=dname.getText();
            String meter=dmeter.getText();
            String address=dadd.getText();
            String city=dcity.getText();
            String state=dstate.getText();
            String email=demail.getText();
            String phone=dphone.getText();
        
            try{

                //connecting database
                Connect c=new Connect();
                String query="update customer set address= '"+address+"', city='"+city+"', state='"+state+"', email='"+email+"',phone='"+phone+"' where meter_no='"+meter+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);


            }catch(Exception ae){
                // if   problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Server not responding");
              
            }
        } 
    }
    
    public static void main(String args[]) {
        
         //creating obj for testing this frame
        new UpdateInformation("");
    }
}
