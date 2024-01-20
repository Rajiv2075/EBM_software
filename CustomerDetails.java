// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import java.awt.*;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class CustomerDetails extends JFrame implements ActionListener{
    
    //swing components with specific variable name
    JComboBox cmeter, cmonth;
    JTable table;
    JButton search, print;
    
    CustomerDetails(){
        
        //tittle
        super("Customer Details");
        
        //property for this frame
        getContentPane().setBackground(Color.cyan);
        setSize(1200,700);
        setLocation(200,100);
        
        //image icon for this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
        
        
        //creating table with name table
        table=new JTable();
        
        try{
            
            //connecting to server
            Connect c=new Connect();
            ResultSet rs=c.s.executeQuery("select * from customer");
            
            //storing data for server
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setFont(new Font("tahoma",Font.PLAIN,14));
        }catch(Exception e){
             // if   problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Server not responding");
              
        }
        
        //creating jscrollpane with name sp
        JScrollPane sp=new JScrollPane(table);
        add(sp);
       
        //button with name print 
        print=new JButton("Print");
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        add(print,"South");
        print.addActionListener(this);
        
        //property of visible to all
        setVisible(true);  
    }

    public @Override void actionPerformed(ActionEvent e){
        
            try{
                
                //print table 
                table.print();
                
            }catch(Exception ae){
                  
                // if   problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Printer not responding");
              
            }
    }
    
    public static void main(String args[]) {
       
        // //creating obj for testing this frame
      new CustomerDetails();
    }
}
