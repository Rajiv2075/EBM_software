// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;



public class Signup extends JFrame implements ActionListener  {

        //swing components with specific variable name
        JButton create,back;
        JLabel heading, lmeter, lusername, lname, lpassword, lspassword ;
        JTextField tmeter,  tpassword, tusername, tname, tspassword;
        JPanel panel;
        JComboBox accountType;
    
    //constructor of Signup class
    Signup(){
        
        //Here, some frame property we implements for this frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        setSize(850,450);
        setLocation(300,150);
        
        //A image icon of this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
        
        // Jpanel with name panel
        panel=new JPanel();
        panel.setBounds(30,30,750,350);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,236),2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        
        //adding panel with frame
        add(panel);
        
        // Jlabel with name heading
        heading=new JLabel("Create Account As");
        heading.setBounds(100,50,150,30);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma",Font.BOLD,14));
        //adding heading in panel
        panel.add(heading);
        
         // JComoboBox with name accountType
        String[] values={"Admin","Customer"};
        accountType=new JComboBox(values);
        accountType.setBounds(300,50,150,30);
        accountType.setSelectedItem("Customer");
       
        //adding heading in panel
        panel.add(accountType);
        
        // JLabel with name lmeter
        lmeter=new JLabel("Meter Number");
        lmeter.setBounds(100,100,150,30);
        lmeter.setForeground(Color.BLACK);
        lmeter.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lmeter);
        
         // JTextField with name tmeter
        tmeter=new JTextField();
        tmeter.setBounds(300,100,150,30);
        tmeter.setForeground(Color.BLACK);
        tmeter.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(tmeter);
        
         // JLabel with name lspassword
        lspassword=new JLabel("Security Password");
        lspassword.setBounds(0,0,0,0);
        lspassword.setForeground(Color.BLACK);
        lspassword.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lspassword);

         // JTextField with name lspassword
        tspassword=new JTextField();
        tspassword.setBounds(0,0,0,0);
        tspassword.setForeground(Color.BLACK);
        tspassword.setFont(new Font("Tahoma",Font.BOLD,14));
        tspassword.setEditable(false);
        panel.add(tspassword);
        
         // JLabel with name lusername
        lusername=new JLabel("username");
        lusername.setBounds(100, 150, 150 ,30 );
        lusername.setForeground(Color.BLACK);
        lusername.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lusername);    
        
         // JTextField with name tusername
        tusername=new JTextField();
        tusername.setBounds(300, 150, 150,30 );
        tusername.setForeground(Color.BLACK);
        tusername.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(tusername);
        
         // JLabel with name lname
        lname=new JLabel("Name");
        lname.setBounds(100, 200, 150 ,30 );
        lname.setForeground(Color.BLACK);
        lname.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lname);  
        
         // JTextField with name tname
        tname=new JTextField();
        tname.setBounds(300, 200, 150,30 );
        tname.setForeground(Color.BLACK);
        tname.setFont(new Font("Tahoma",Font.BOLD,14));
        tname.setEditable(false);
        panel.add(tname);
        
        //Here, we add FocusListener when user their meter number if the meter number existing then his name automatically displays in  name label
        tmeter.addFocusListener(new FocusListener(){
            
            public @Override void focusGained(FocusEvent e){}
            
            public @Override void focusLost(FocusEvent e){
            
                try{
                    
                    // connection stablish with database
                    Connect c=new Connect();
                    ResultSet rs=c.s.executeQuery("select * from login where meter_no='"+tmeter.getText()+"'");
                    
                    //search and access the name and set in label of name
                    while(rs.next()){
                       tname.setText(rs.getString("name"));
                    }
                }catch(Exception ae){
                    //if any Exception arises then it show a message
                    JOptionPane.showMessageDialog(null, "User not registered");
                
                }
            };
        });
        
        //JLabel with variable name lpassword
        lpassword=new JLabel("Password");
        lpassword.setBounds(100, 250, 150 ,30 );
        lpassword.setForeground(Color.BLACK);
        lpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lpassword);    
        
        //JTextField with name tpassword
        tpassword=new JTextField();
        tpassword.setBounds(300, 250, 150,30 );
        tpassword.setForeground(Color.BLACK);
        tpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(tpassword);
        
        //if user select different accountType then some property add and some property removes in the signup frame
        accountType.addItemListener(new ItemListener(){
          
            public @Override void itemStateChanged(ItemEvent e){
                String user=(String)accountType.getSelectedItem();
                if(user.equals("Admin")){
                    
                    //label and textfield of meter will disable if user choose admin
                    lmeter.setVisible(false);
                    tmeter.setVisible(false);
                    
                    //label and textfield of password will enable if user choose admin
                    lspassword.setBounds(100,100,150,30);
                    tspassword.setBounds(300,100,150,30);

                    // textfield of password and name will editable if user choose admin
                    tspassword.setEditable(true); 
                     tname.setEditable(true);
                    
                    //label and textfield of password will visible if user choose admin
                    lspassword.setVisible(true);
                    tspassword.setVisible(true);
                   
                }else{
                    
                    tspassword.setBounds(300,0,0,30);
                    
                    // label and textfield with password name will disable
                    lspassword.setVisible(false);
                    tspassword.setVisible(false);
                    
                    //label and textfield will visible for user
                    lmeter.setVisible(true);
                    tmeter.setVisible(true);
                    
                    //txtfield with tname will not editable 
                    tname.setEditable(false);
                 }           
            }  
        });
        
        //button with create name and added actionlistener
        create=new JButton("CREATE");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(150,300,100,30);
        panel.add(create);
        create.addActionListener(this);
        
        //button with back name and added actionlistener
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(320,300,100,30);
        panel.add(back);
        back.addActionListener(this);
        
        //signup image for frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        //label with image name where put on the image of signup frame
        JLabel image=new JLabel(i3);
        image.setBounds(500,30,250,250);
        panel.add(image);
        
        //frame will visible for all 
        setVisible(true);     
    }
    
    //here, define the action performed when button is clicked
    public @Override void actionPerformed(ActionEvent e){
        
        //if user click on create butoon these action is performed
        if(e.getSource()==create){
            
            //stores data that user inserted
            String atype=(String)accountType.getSelectedItem();
            String susername=tusername.getText();
            String sname=tname.getText();
            String spassword=tpassword.getText();
            String smeter=tmeter.getText();
            String password=(String)tspassword.getText();
            
            try{
                
                //connection stablish with database
                Connect c=new Connect();
                
                //string variable with name query
                String query=null;
                
                
                //if user select admin
                if(atype.equals("Admin")){
                    
                    //checking password is right or not
                    if(password.equals("12345")){
                        
                        //this insert query will executed
                        query="insert into login values('' , '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"')";
                        c.s.executeUpdate(query);
                        
                        //after execution of the query this message will display
                        JOptionPane.showMessageDialog(null, "Account Created Successfully");
                        
                        //the frame will close and open a login frame
                        setVisible(false);
                        new Login();
                        
                     }else{
                        
                        //diplay a message, close the frame and open a signup frame
                        JOptionPane.showMessageDialog(null, "Wrong Password");
                        setVisible(false);
                        new Signup();
                    }
                }else{
                    
                    //checking tname have  value or not
                    if (tname.getText().equals("")) {
                        
                        // tname have null value then it display this message
                        JOptionPane.showMessageDialog(null, "Not Registered Customer");
                        
                    } else {
                         
                        //A update query will execute
                       // System.out.println("------s" + tname.getText() + "p---------");
                        query = "update login set username= '" + susername + "', password='" + spassword + "', user='" + atype + "' where meter_no='" + smeter + "'";
                        c.s.executeUpdate(query);
                        
                        //after execution this message will display and close signup frame and open login frame
                        JOptionPane.showMessageDialog(null, "Account Created Successfully");
                        setVisible(false);
                        new Login();
                        
                    }
                } 
                
           
            }catch(Exception ae){
                
               //if error aries in connecting with server then it message will generate
               JOptionPane.showMessageDialog(null, "server not responding");
                        
            }
            
        }else if(e.getSource()==back){
            
            //if user click on back button then signup frame close and login frame open
            setVisible(false);
            new Login();
            
        }
    } 
    
   
    public static void main(String args[]) {
        
        //here new object for testing this class work well or not
        new Signup();
    }
}
