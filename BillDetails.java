// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class BillDetails extends JFrame {

    BillDetails(String meter){
        
        //property of the frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        setSize(850,700);
        setLocation(250,100);
        this.setBackground(Color.CYAN);
        
        //image icon of this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
        
        //creating table with name table
        JTable table=new JTable();
        
        try{
            
            //connecting database
            Connect c=new Connect();
            String query="select * from bill where meter_no = '"+meter+"'";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            //scrollpane with name sp
            JScrollPane sp=new JScrollPane(table);
            sp.setBounds(0,0,850,700);
            add(sp);
            
        }catch(Exception e){
              // if problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Data not found or server problem");
              
        }
        
        setVisible(true);
    }
    
    public static void main(String args[]) {
        
          //creating obj for testing this frame
        new BillDetails("");
    }
}
