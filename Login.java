// Importing some java packages for swing and use of some property of awt, sql and event
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    //swing components with specific variable name
    JButton login,cancel,signup;
    JTextField tusername, tpassword ;
    JComboBox logginin;
    
    //constructor of Login class
    Login(){
         
        //Here, some frame property we implements for login frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,400);
        setLocation(300,150);
        
        // A image icon for this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
        
        // username Label               
        JLabel lusername=new JLabel("username");
        lusername.setBounds(300, 40, 120,30 );
        add(lusername);    
        
        //username TextField
        tusername=new JTextField();
        tusername.setBounds(450, 40, 170,30 );
        add(tusername); 
        
        //password Label
        JLabel lpassword=new JLabel("password");
        lpassword.setBounds(300, 80, 120,30 );
        add(lpassword);  
        
        //Password TextField
        tpassword=new JTextField();
        tpassword.setBounds(450, 80, 170,30 );
        add(tpassword); 
         
        //Loging in as "Label"
        JLabel loggininas=new JLabel("Loging in as");
        loggininas.setBounds(300, 120, 120,30 );
        add(loggininas);  
        
        // Loging in as JComboBox
        String[] values={"Admin","customer"};
        logginin=new JComboBox(values);
        logginin.setBounds(450, 120, 170,30 );
        add(logginin);
        
        // A image icon for login button
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2=i1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        
        // login button
        login=new JButton("Login",new ImageIcon(i2));
        login.setBounds(320,180,100,20);
        add(login);
        login.addActionListener(this);
        
        // A image icon for cancel button
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4=i3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);

        //cancel button
        cancel=new JButton("cancel",new ImageIcon(i4));
        cancel.setBounds(450,180,100,20);
        add(cancel);
        cancel.addActionListener(this);
        
        // A image icon for signup button
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6=i5.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        
        //signup button
        signup=new JButton("signup",new ImageIcon(i6));
        signup.setBounds(380,220,100,20);
        add(signup);
        signup.addActionListener(this);
        
        // A image for login frame
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8=i7.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image=new JLabel(i9);
        image.setBounds(0,0,250,250);
        add(image);
        
        //visible for frame for all
        setVisible(true); 
    }
    
    // The method in which action performed
    public @Override void actionPerformed(ActionEvent e){
        
        //checking which button user is click
        if(e.getSource()==login){
            
            // store the data given by user
            String susername=tusername.getText();
            String spassword=tpassword.getText();
            String user=(String)logginin.getSelectedItem();
            
            try{
                //connect to database for data assess
                Connect c=new Connect();
                
                //The query I have to send in database for accessing/collecting data
                String query="select * from login where username= '"+susername+"' and password='"+spassword+"' and user= '"+user+"'";
                
                //store the value that receive from database through query
                ResultSet rs=c.s.executeQuery(query);
                
                //checking user is valid or not 
                if(rs.next()){
                    
                    //Here, we store the meter number of valid user
                    String meter=rs.getString("meter_no");
                    setVisible(false);
                    new Project(user,meter);
                    
                }else{
                    // if user not valid then it show a message 
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    tusername.setText("");
                    tpassword.setText("");
                }
                
            }catch(Exception ae){
                
                //if any Exception arises then it show a message
                JOptionPane.showMessageDialog(null, "Server not responding");
                setVisible(false);
                new Login();
            }  
            
        }else if(e.getSource()==cancel){
            
            //property apply on the frame
            setVisible(false);
            
        }else if(e.getSource()==signup){

            //property apply on the frame and open the signup frame
            setVisible(false);
            new Signup();
            
        }
    } 

    
    public static void main(String args[]) {
        
        //we create a object for constructor call and checking of this module
        new Login();
    }
}
