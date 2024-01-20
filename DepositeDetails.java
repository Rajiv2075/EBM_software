// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class DepositeDetails extends JFrame implements ActionListener{
    
    //swing components with specific variable name
    JComboBox cmeter, cmonth;
    JTable table;
    JButton search, print;
    
    DepositeDetails(){
        
        //tittle display
        super("Deposit Details");
        
        //property applies for this frame
        setSize(800,600);
        setResizable(false);
        setLocation(250,110);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);   
        
        //A icon for this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
      
        //label with name lmeter
        JLabel lmeter=new JLabel("SEARCH BY METER No.");
        lmeter.setBounds(30,20,150,30);
        add(lmeter);
        
        //comboBox with name cmeter
        cmeter=new JComboBox();
        cmeter.setBounds(200,20,150,30);
        add(cmeter);
        
        try{
            
            //connecting to database
            Connect c=new Connect();
            
            //query execute
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                cmeter.addItem(rs.getString("meter_no"));
            }
        }catch(Exception e){
               // if problem arises then it show a message 
                    JOptionPane.showMessageDialog(null, "Not data found");
                    
        }
        
        //label with name lmonth
        JLabel lmonth=new JLabel("SEARCH BY MONTH ");
        lmonth.setBounds(380,20,150,30);
        add(lmonth);
        
        //comboBox with name cmonth
        cmonth=new JComboBox();
        cmonth.setBounds(520,20,150,30);
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
        add(cmonth);
        
        //creating table with name table
        table=new JTable();
        table.setBounds(20,30,500,400);
        
        try{
            
            //connecting to database
            Connect c=new Connect();
            ResultSet rs=c.s.executeQuery("select * from bill");
            
            //copy all the data from database from a specific table
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            // if problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Data not found or server problem");
                    
        }
        
        //Jscrollpane with name sp
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(20,130,750,400);
        add(sp);
        
        //buttom with name search
        search=new JButton("SEARCH");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(50,70,100,30);
        add(search);
        search.addActionListener(this);
        
        //buttom with name search
        print=new JButton("PRINT");
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setBounds(200,70,100,30);
        add(print);
        print.addActionListener(this);
        
        //visible this frame to all
        setVisible(true);  
    }

    public @Override void actionPerformed(ActionEvent e){
        
        //checking which button is clicked
        if(e.getSource()==search){
            //query will execute
           String query="select * from bill where meter_no='"+cmeter.getSelectedItem()+"' and month='"+cmonth.getSelectedItem()+"'";
        
           try{
               
               //connecting with database
               Connect c=new Connect();
               ResultSet rs=c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
               
           }catch(Exception ae){
               // if problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Data not found or server problem");
              
           }
        
        }else{
            
            try{
                table.print();
              }catch(Exception ae){
               // if   problem arises then it show a message 
               JOptionPane.showMessageDialog(null, "Server not responding");
              
            }
        }
    }
    
    public static void main(String args[]) {
        
        //creating obj for testing this frame
      new DepositeDetails();
    }
}
