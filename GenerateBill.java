// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class GenerateBill extends JFrame implements ActionListener {
    
    //components of swing
    JTextArea area;
    JLabel dmeter;
    JButton bill, print;
    JComboBox cmonth;
    String meter;
    
    GenerateBill(String meter){
        
        //storing formal to actual
        this.meter=meter;
        
        //property of the frame
        setSize(750,700);
        setLocation(470,50);
        setLayout(new BorderLayout(){});
        setResizable(false);
        
        //icon image for this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
        
        //panel with name panel
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        panel.setBackground(Color.CYAN);
         panel1.setBackground(Color.CYAN);
        
        //label with name heading
        JLabel heading=new JLabel("Generate Bill");
        dmeter=new JLabel("");
        
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
        
        //textArea with name area
        area=new JTextArea(50,15);
        area.setFont(new Font("Tahoma",Font.ITALIC,18));
        area.setLineWrap(true);
        area.setEditable(false);
        area.setText("\n\n\n\t\t-------click on the-----------\n\t\tGenerate Bill Button to get\n\t\tthe bill of Selected MONTH\t\t\n\n\n");
        
        //scrollpane with name js
        JScrollPane js=new JScrollPane(area);
        
        //button with name bill
        bill=new JButton("GENERATE BILL");
        bill.setBackground(Color.BLACK);
        bill.setForeground(Color.WHITE);
        bill.addActionListener(this);
        
        //button with name print
        print=new JButton("PRINT BILL");
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        
        //adding components to the panel
        panel.add(heading);
        panel.add(dmeter);
        panel.add(cmonth);
        panel1.add(bill);
        panel1.add(print);
        add(panel,"North");
        add(panel1,"South");
        add(js,"Center");
        
         //visible to all    
        setVisible(true);
    }
    
    public @Override void actionPerformed(ActionEvent e){
        
        //checking which button is clicked
     if(e.getSource()==bill){
        try{
            
            //connecting with server
            Connect c=new Connect();
           
            //set text to textArea 
            String month=(String)cmonth.getSelectedItem();
            area.setText("\t  North Bihar Power Distribution Company \n    ELECTRICITY BILL GENERATED FOR THE MONTH OF "+month+", 2024\n\n\n");
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            if(rs.next()){
                try{
                    //printing customer data for a specific meter number
                    area.append("\n    Customer Name_:"+rs.getString("name"));
                    area.append("\n    Meter Number__: "+rs.getString("meter_no"));
                    area.append("\n    Address_______: "+rs.getString("address"));
                    area.append("\n    City__________: "+rs.getString("city"));
                    area.append("\n    State_________: "+rs.getString("state"));
                    area.append("\n    Email-ID______: "+rs.getString("email"));
                    area.append("\n    Phone Number_: "+rs.getString("phone"));
                    area.append("\n   ---------------------------------------------------------------");
                    area.append("\n");
                }catch(Exception aee){
                    // if problem arises then it show a message 
                    JOptionPane.showMessageDialog(null, "Data not found ");
              
                } 
            }
            
            rs=c.s.executeQuery("select * from meter_info where meter_no='"+meter+"'");
            
            if(rs.next()){
                try{
                    
                    //printing meter related data for a specific meter number
                    area.append("\n    Meter Location_:"+rs.getString("meter_location"));
                    area.append("\n    Meter Type____: "+rs.getString("meter_type"));
                    area.append("\n    Phase Code____: "+rs.getString("phase_code"));
                    area.append("\n    Bill Type______: "+rs.getString("bill_type"));
                    area.append("\n    Days_________: "+rs.getString("days"));
                    area.append("\n   ---------------------------------------------------------------");
                    area.append("\n");
                    
                }catch(Exception aee){
                    // if   problem arises then it show a message 
                    JOptionPane.showMessageDialog(null, "Server not responding");

                } 
            }
            
             rs=c.s.executeQuery("select * from tax ");
            
            if(rs.next()){
                try{
                    
                    //printing data like costing rate and charges
                    area.append("\n     Cost_Per_Unit_____:"+rs.getString("cost_per_unit"));
                    area.append("\n    Meter_Rent_________: "+rs.getString("meter_rent"));
                    area.append("\n    Service_Charge_____: "+rs.getString("service_charge"));
                    area.append("\n    Service_Tax________: "+rs.getString("service_tax"));
                    area.append("\n    Swaccha_Bharat_Tax_: "+rs.getString("swacch_bharat_tax"));
                    area.append("\n    Fixed_Tax__________: "+rs.getString("fixed_tax"));
                    area.append("\n   ---------------------------------------------------------------");
                    area.append("\n");
                    
                }catch(Exception aee){
                    
                    // if   problem arises then it show a message 
                    JOptionPane.showMessageDialog(null, "Server not responding");
              
                } 
            }
            
             rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"' AND month='"+month+"'");
            
            if(rs.next()){
                try{
                
                    //printing units and month for specific meter number
                    area.append("\n    Month__________:"+rs.getString("month"));
                    area.append("\n    Unit_Consumed__: "+rs.getString("units"));
                    area.append("\n    Total_Payable__: "+rs.getString("totalbill"));
                    area.append("\n    Status_________: "+rs.getString("status"));
                    area.append("\n   ---------------------------------------------------------------");
                    area.append("\n");
                    
                }catch(Exception aee){
                    
                    // if   problem arises then it show a message 
                    JOptionPane.showMessageDialog(null, "Server not responding");
              
                } 
            }
                
        }catch(Exception ae){
            
              // if problem arises then it show a message 
              JOptionPane.showMessageDialog(null, "Data not found or server problem");
              
        }
     }else{
          try{
              
                //printing data
                area.print();
            }catch(Exception ae){
                  
                // if problem arises then it show a message 
               JOptionPane.showMessageDialog(null, "Printer not working");
              
            }
        } 
    }

    
    public static void main(String args[]) {
        
      //creating obj for testing this frame  
      new GenerateBill("");
    }
}
