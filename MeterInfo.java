// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MeterInfo extends JFrame implements ActionListener{
    
    //swing components with specific variable name
    JButton next, back;
    JComboBox meterlocation , metertype, phasecode, billtype;
    String meternumber;
    
    MeterInfo(String meternumber){
        
        //storing meter number which value is passed when object is created
        this.meternumber=meternumber;
        
        //property applied on this this frame
        setSize(900,550);
        setLocation(300,200);
        setResizable(false);
        getContentPane().setBackground(Color.cyan);
        
        // A image icon for this frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
      
        //Jpanel with name p        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        //Jlabel with name heading
        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(200,10,300,30);
        heading.setFont(new Font("tahoma",Font.BOLD,24));
        p.add(heading);
        
        //JLabel with name lmeter
        JLabel lmeter=new JLabel("Meter Number");
        lmeter.setFont(new Font("tahoma",Font.BOLD,16));
        lmeter.setBounds(100,80,150,30);
        p.add(lmeter);
        
        //JLabel with name lbmeter
        JLabel lbmeter=new JLabel(meternumber);
        lbmeter.setFont(new Font("tahoma",Font.BOLD,16));
        lbmeter.setBounds(300,80,250,30);
        p.add(lbmeter);
        
        //JLabel with name lmeterlocation
        JLabel lmeterlocation=new JLabel("Meter Location");
        lmeterlocation.setFont(new Font("tahoma",Font.BOLD,16));
        lmeterlocation.setBounds(100,130,150,30);
        p.add(lmeterlocation);
        
        //ComboBox with name meterlocation
        meterlocation= new JComboBox();
        meterlocation.addItem("Outside");
        meterlocation.addItem("Inside");
        meterlocation.setBounds(300,130,150,30);
        p.add(meterlocation);
        
        //JLabel with name lmetertype
        JLabel lmetertype=new JLabel("Meter Type");
        lmetertype.setFont(new Font("tahoma",Font.BOLD,16));
        lmetertype.setBounds(100,180,150,30);
        p.add(lmetertype);
        
        //JComboBox with name metertype
        metertype= new JComboBox();
        metertype.addItem("Electric Meter");
        metertype.addItem("Solar Meter");
        metertype.addItem("Smart Meter");
        metertype.setBounds(300,180,150,30);
        p.add(metertype);

        //JLabel with name lphase
        JLabel lphase=new JLabel("Phase Code");
        lphase.setFont(new Font("tahoma",Font.BOLD,16));
        lphase.setBounds(100,230,150,30);
        p.add(lphase);
        
        //ComboBox with name phasecode
        phasecode=new JComboBox();
        phasecode.addItem("011");
        phasecode.addItem("022");
        phasecode.addItem("033");
        phasecode.addItem("044");
        phasecode.addItem("055");
        phasecode.addItem("066");
        phasecode.addItem("077");
        phasecode.addItem("088");
        phasecode.addItem("099");
        phasecode.setBounds(300,230,150,30);
        p.add(phasecode);
        
        //JLabel with name lbilltype
        JLabel lbilltype=new JLabel("BILL Type ");
        lbilltype.setFont(new Font("tahoma",Font.BOLD,16));
        lbilltype.setBounds(100,280,250,30);
        p.add(lbilltype);
        
        //ComboBox with name billtype
        billtype= new JComboBox();
        billtype.addItem("Normal ");
        billtype.addItem("Industial ");
        billtype.setBounds(300,280,150,30);
        p.add(billtype);
        
        //JLabel with name ldays
        JLabel ldays=new JLabel("Days  ");
        ldays.setFont(new Font("tahoma",Font.BOLD,16));
        ldays.setBounds(100,330,150,30);
        p.add(ldays);
        
        //JLabel with name lbdays
        JLabel lbdays=new JLabel("30 Days");
        lbdays.setFont(new Font("tahoma",Font.BOLD,16));
        lbdays.setBounds(300,330,150,30);
        p.add(lbdays);
        
        //JLabel with name lnote
        JLabel lnote=new JLabel("Note");
        lnote.setFont(new Font("tahoma",Font.BOLD,16));
        lnote.setForeground(Color.red);
        lnote.setBounds(100,380,150,30);
        p.add(lnote);
        
        //JLabel with name lbnote
        JLabel note=new JLabel("By Default Bill is calculated for 30 days only");
        note.setFont(new Font("tahoma",Font.BOLD,16));
        note.setForeground(Color.red);
        note.setBounds(300,380,500,30);
        p.add(note);
        
        //button with name next
        next=new JButton("SUBMIT");
        next.setBounds(250,450,150,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        p.add(next);
        next.addActionListener(this);
        
        //layout of this frame
        setLayout(new BorderLayout ());
        add(p,"Center");
        
        //image on this frame
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image,"West");
        
        //other property of the frame
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public @Override void actionPerformed(ActionEvent e){
        
        if(e.getSource()==next){
            
            //store the value entered by user
            String meter=meternumber;
            String location=(String)meterlocation.getSelectedItem();
            String type=(String)metertype.getSelectedItem();
            String code=(String)phasecode.getSelectedItem();
            String btype=(String)billtype.getSelectedItem();
            String days="30";
            
            //query for inserting data
            String query="insert into meter_info values('"+meter+"', '"+location+"', '"+type+"', '"+code+"', '"+btype+"', '"+days+"')";
            
            try{
                
                //connecting with database
                Connect c=new Connect();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Meter number: "+meter+"\nYOUR PASSWORD (when you update your information): \'yourname\'+ \'meternumer\'(eg: rajiv236536)"+"\n\nNEW CUSTOMER ADDED SUCCESSFULLY");
                setVisible(false);
                
                //new Frame
                
               }catch(Exception ae){
                 // if problem arises then it show a message 
                    JOptionPane.showMessageDialog(null, "Server not responding");
                    setVisible(false);                    
            }
            
        }else{
            
            //click on back then frame will close
            setVisible(false);  
        }
    }

    public static void main(String args[]) {
        
        //we create a object for constructor call and checking of this module
        new MeterInfo("");
    }
}
