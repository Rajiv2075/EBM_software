// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import java.sql.*;
import javax.swing.JOptionPane;


public class Connect {
    
    // create reference of the following class
    Connection c;
    Statement s;
    
    
    Connect(){
        try{
            
            //we call through DriverManager that have method getConnection in which you pass path of the mysql , system name and password
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "system");
           
            //here, we call method createStatement through c obj 
            s=c.createStatement();
            
        }catch(Exception e){
            
               // if   problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Database not connected");  
           }   
    }

    public static void main(String args[]) {
        
    }
}
