
package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class PayBill extends JFrame implements ActionListener{
    
    JLabel dmeter, dname, dunit, dtotal, dstatus ;
    JComboBox cmonth;
    JButton pay, back;
    String meter;
    
    PayBill(String meter){
        this.meter=meter;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(980,700);
        setLocation(250,50);
        
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
        
        getContentPane().setBackground(Color.CYAN);
      
        
        JLabel heading =new JLabel("ELECTRICITY  BILL ");
        heading.setBounds(360,5,500,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        heading.setBackground(Color.white);
        heading.setForeground(Color.black);
        add(heading);
        
        JLabel lmeter =new JLabel("Meter Number");
        lmeter.setBounds(40,100,150,30);
        lmeter.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lmeter);
        
        dmeter =new JLabel("");
        dmeter.setBounds(300,100,250,30);
        dmeter.setFont(new Font("Tahoma",Font.BOLD,16));
        add(dmeter);
        
        JLabel lname =new JLabel("Name  ");
        lname.setBounds(40,180,150,30);
        lname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lname);
        
        dname =new JLabel("");
        dname.setBounds(300,180,250,30);
        dname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(dname);
        
        JLabel lmonth =new JLabel("Month  ");
        lmonth.setBounds(40,260,150,30);
        lmonth.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lmonth);
        
        cmonth =new JComboBox();
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
        cmonth.setBounds(300,260,200,30);
        cmonth.setFont(new Font("Tahoma",Font.BOLD,14));
        add(cmonth);
        
        JLabel lunit =new JLabel("Units ");
        lunit.setBounds(40,340,150,30);
        lunit.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lunit);
        
        dunit =new JLabel("");
        dunit.setBounds(300,340,250,30);
        dunit.setFont(new Font("Tahoma",Font.BOLD,16));
        add(dunit);
        
        JLabel ltotal =new JLabel("Total Bill ");
        ltotal.setBounds(40,420,150,30);
        ltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(ltotal);
        
        dtotal =new JLabel("");
        dtotal.setBounds(300,420,250,30);
        dtotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(dtotal);
        
        JLabel lstatus =new JLabel("Status ");
        lstatus.setBounds(40,500,150,30);
        lstatus.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lstatus);
        
        dstatus =new JLabel("");
        dstatus.setBounds(300,500,250,30);
        dstatus.setFont(new Font("Tahoma",Font.BOLD,16));
        dstatus.setForeground(Color.red);
        add(dstatus);
        
        try{
            
           Connect c=new Connect();
           ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            
           while(rs.next()){
               dmeter.setText(meter);
               dname.setText(rs.getString("name"));
           }
           
           rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"' AND month='"+cmonth.getSelectedItem()+"'");
            
           while(rs.next()){
               dunit.setText(rs.getString("units"));
               dtotal.setText(rs.getString("totalbill"));
               dstatus.setText(rs.getString("status"));
               
           }
           
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cmonth.addItemListener(new ItemListener(){
        
            public @Override void itemStateChanged(ItemEvent e){
                
                try{
            
                    Connect c=new Connect();
                    ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");

                    while(rs.next()){
                        dmeter.setText(meter);
                        dname.setText(rs.getString("name"));
                    }

                    rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"' AND month='"+cmonth.getSelectedItem()+"'");

                    while(rs.next()){
                        dunit.setText(rs.getString("units"));
                        dtotal.setText(rs.getString("totalbill"));
                        dstatus.setText(rs.getString("status"));

                    }

                  }catch(Exception ae){
                     ae.printStackTrace();
                }
                
            }
        
        });
        
        pay=new JButton("PAY ");
        pay.setBounds(80,580,150,30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        add(pay);
        pay.addActionListener(this);
        
        back=new JButton("BACK");
        back.setBounds(300,580,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2=i1.getImage().getScaledInstance(650,350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,140,600,300);
        image.setBackground(Color.WHITE);
        add(image);
        
        
        setVisible(true);
    }
    
    public @Override void actionPerformed(ActionEvent e){
        
        if(e.getSource()==pay){
            
            try{
                Connect c=new Connect();
                c.s.executeUpdate("update bill set status='Paid' where meter_no='"+meter+"' AND month='"+cmonth.getSelectedItem()+"'");
                
            }catch(Exception ae){
                ae.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(null, "BILL PAID  Successfully");

            setVisible(false);
          //  new Paytm(meter);
            
        }else{
            setVisible(false);
        }
        
    }

    
    public static void main(String args[]) {
       new PayBill("");
    }
}
