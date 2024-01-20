// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;



public class Project extends JFrame implements ActionListener {
    
    //swing components with specific variable name
    String luser,lmeter;
    
    //constructor of Project class
    Project(String luser,String lmeter){
        
        //storing value that pass when object is created
        this.luser=luser;
        this.lmeter=lmeter;
        
        //Here, some frame property we implements for this frame
        setLocation(250,150);
        setSize(900,600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //A image icon of this  frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
        
        //It is the interface image or background image that added on JLabel
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 850, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        //A Menubar with name bar
        JMenuBar bar=new JMenuBar();
        setJMenuBar(bar);
        
        //Menu master in bar 
        JMenu master=new JMenu("MASTER");
        master.setForeground(Color.BLUE);
        
        // MenuItem with name newcustomer Added in master Menu 
        JMenuItem newcustomer= new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.white);
        //A image icon upon newcustomer
        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1=icon1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        // when you press ctrl+N then it open newcustomer frame and some action will performed in this frame
        newcustomer.setMnemonic('N');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        master.add(newcustomer);
        
         // MenuItem with name customerdetails Added in master Menu 
        JMenuItem customerdetails= new JMenuItem("Customer Details  ");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails.setBackground(Color.white);
        //A image icon upon customerdetails
        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2=icon2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        // when you press ctrl+A then it open customerdetails frame and some action will performed in this frame
        customerdetails.setMnemonic('A');
        customerdetails.addActionListener(this);
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        master.add(customerdetails);
        
         // MenuItem with name depositesdetails Added in master Menu 
        JMenuItem depositsdetails= new JMenuItem("Deposit Details  ");
        depositsdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositsdetails.setBackground(Color.white);
        //A image icon upon depositsdetails
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3=icon3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositsdetails.setIcon(new ImageIcon(image3));
        // when you press ctrl+D then it open depositsdetails frame and some action will performed in this frame
        depositsdetails.setMnemonic('D');
        depositsdetails.addActionListener(this);
        depositsdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        master.add(depositsdetails);
        
         // MenuItem with name calculatebill Added in master Menu 
        JMenuItem calculatebill= new JMenuItem("Calculate Bills ");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill.setBackground(Color.white);
        //A image icon upon calculatebill
        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image4=icon4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        // when you press ctrl+C then it open calculatebill frame and some action will performed in this frame
        calculatebill.setMnemonic('C');
        calculatebill.addActionListener(this);
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        master.add(calculatebill);
        
        // MenuItem with name newcustomer Added in master Menu 
        JMenuItem customerupdate= new JMenuItem("Customer Update");
        customerupdate.setFont(new Font("monospaced",Font.PLAIN,12));
        customerupdate.setBackground(Color.white);
        //A image icon upon newcustomer
        ImageIcon icon21=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image22=icon21.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerupdate.setIcon(new ImageIcon(image22));
        // when you press ctrl+Q then it open newcustomer frame and some action will performed in this frame
        customerupdate.setMnemonic('Q');
        customerupdate.addActionListener(this);
        customerupdate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
        master.add(customerupdate);
        
         //Menu info in bar 
        JMenu info=new JMenu("INFORMATION");
        info.setForeground(Color.RED);
       
         // MenuItem with name updateinformation Added in info Menu 
        JMenuItem updateinformation= new JMenuItem("Update Information ");
        updateinformation.setFont(new Font("monospaced",Font.PLAIN,12));
        updateinformation.setBackground(Color.white);
        //A image icon upon updateinformation
        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5=icon5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        updateinformation.setIcon(new ImageIcon(image5));
        // when you press ctrl+U then it open updateinformation frame and some action will performed in this frame/
        updateinformation.setMnemonic('U');
        updateinformation.addActionListener(this);
        updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        info.add(updateinformation);
        
        // MenuItem with name viewinfomation Added in info Menu 
        JMenuItem viewinformation= new JMenuItem("View Information ");
        viewinformation.setFont(new Font("monospaced",Font.PLAIN,12));
        viewinformation.setBackground(Color.white);
        //A image icon upon viewinformation
        ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6=icon6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewinformation.setIcon(new ImageIcon(image6));
        // when you press ctrl+V then it open viewinformation frame and some action will performed in this frame
        viewinformation.setMnemonic('V');
        viewinformation.addActionListener(this);
        viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        info.add(viewinformation);
        
         //Menu user in bar 
        JMenu user=new JMenu("USER");
        user.setForeground(Color.BLUE);
       
        // MenuItem with name paybills Added in user Menu 
        JMenuItem paybills= new JMenuItem("Pay Bills ");
        paybills.setFont(new Font("monospaced",Font.PLAIN,12));
        paybills.setBackground(Color.white);
        //A image icon upon paybills
        ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7=icon7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybills.setIcon(new ImageIcon(image7));
        // when you press ctrl+P then it open paybills frame and some action will performed in this frame
        paybills.setMnemonic('P');
        paybills.addActionListener(this);
        paybills.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        user.add(paybills);
        
        // MenuItem with name billdetails Added in user Menu 
        JMenuItem billdetails= new JMenuItem("Bill Details  ");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        billdetails.setBackground(Color.white);
        //A image icon upon billdetails/
        ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8=icon8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));
        // when you press ctrl+B then it open billdetails frame and some action will performed in this frame
        billdetails.setMnemonic('B');
        billdetails.addActionListener(this);
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        user.add(billdetails);
        
         //Menu report in bar 
        JMenu report=new JMenu("REPORT");
        report.setForeground(Color.RED);
        
        // MenuItem with name generatebills Added in report Menu 
        JMenuItem generatebills= new JMenuItem("Generate Bills ");
        generatebills.setFont(new Font("monospaced",Font.PLAIN,12));
        generatebills.setBackground(Color.white);
        //A image icon upon generatebills
        ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image9=icon9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        generatebills.setIcon(new ImageIcon(image9));
        // when you press ctrl+G then it open generatebills frame and some action will performed in this frame
        generatebills.setMnemonic('G');
        generatebills.addActionListener(this);
        generatebills.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        report.add(generatebills);
        
         //Menu utility in bar 
        JMenu utility=new JMenu("UTILITY");
        utility.setForeground(Color.BLUE);
        
        // MenuItem with name notepad Added in utility Menu 
        JMenuItem notepad= new JMenuItem("Notepad ");
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setBackground(Color.white);
        //A image icon upon notepad
        ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10=icon10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        // when you press ctrl+W then it open notepad frame and some action will performed in this frame
        notepad.setMnemonic('W');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        utility.add(notepad);
        
        // MenuItem with name \'calculator\ Added in utility Menu 
        JMenuItem calculator= new JMenuItem("Calculator ");
        calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        calculator.setBackground(Color.white);
        //A image icon upon calculator
        ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11=icon11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        // when you press ctrl+L then it open calculator frame and some action will performed in this frame
        calculator.setMnemonic('L');
        calculator.addActionListener(this);
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        utility.add(calculator);
        
         //Menu mexit in bar 
        JMenu mexit=new JMenu("SIGN_OUT");
        mexit.setForeground(Color.RED);
        
        // MenuItem with name exit Added in mexit Menu 
        JMenuItem exit= new JMenuItem("Exit  ");
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setBackground(Color.white);
        //A image icon upon exit
        ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12=icon12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        // when you press ctrl+E then it open EXIT frame and some action will performed in this frame
        exit.setMnemonic('E');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        mexit.add(exit);
        
        if(luser.equals("Admin")){
            
            //WHEN admin open this then master menu will visible 
            bar.add(master);
        }else{
            
            //when customer open this then info, user and report menu will visible
            bar.add(info);
            bar.add(user);
            bar.add(report); 
        }
        
        
        // anyone if user as well as admin open this then it visible for both
        bar.add(utility);
        bar.add(mexit);
        
        
        //frame will visible for all and apply flow layout for this frame
        setLayout(new FlowLayout());
        setVisible(true);
    }
    
    public @Override void actionPerformed(ActionEvent e){
        
        //when user give command then it verify which menu is executed 
        String msg=e.getActionCommand();
        
        if(msg.equals("New Customer")){
            //if user select new customer then it open newcustomer frame
            new NewCustomer();
            
        }else if(msg.equals("Customer Details  ")){
             //if user select Customer Details   then it open CustomerDetails frame
            new CustomerDetails();
            
        }else if(msg.equals("Deposit Details  ")){
             //if user select Deposit Details   then it open DepositeDetails frame
            new DepositeDetails();
            
        }else if(msg.equals("Calculate Bills ")){
             //if user select Calculate Bills  then it open CalculateBill frame
            new CalculateBill();
            
        }else if(msg.equals("View Information ")){
             //if user select View Information  then it open ViewInformation frame
            new ViewInformation(lmeter);
            
        }else if(msg.equals("Update Information ")){
             //if user select Update Information  then it open UpdateInformation frame
            new UpdateInformation(lmeter);
            
        }else if(msg.equals("Bill Details  ")){
             //if user select Bill Details then it open BillDetails frame
            new BillDetails(lmeter);
            
        }else if(msg.equals("Exit  ")){
             //if user select Exit then it open Login frame
            setVisible(false);
            new Login();
            
        }else if(msg.equals("Pay Bills ")){
             //if user select Pay Bills  then it open PayBill frame
            new PayBill(lmeter);
            
        }else if(msg.equals("Generate Bills ")){
             //if user select Generate Bills  then it open GenerateBill frame
            new GenerateBill(lmeter);
            
        }else if(msg.equals("Customer Update")){
             //if user select update customer then it open updatecustomer frame
              new CustomerUpdate();
             
        }else if(msg.equals("Notepad ")){
            
             //if user select Notepad  then it open  Notepad of your system
            try{
               
                Runtime.getRuntime().exec("notepad.exe");
                
            }catch(Exception ae){
                //if any error  arises it give a message
                 JOptionPane.showMessageDialog(this, "Notepad not found","ERROR",JOptionPane.ERROR_MESSAGE);

            }
            
        }else if(msg.equals("Calculator ")){
            
             //if user select Calculator then it open calculator of your system
            try{
               
                Runtime.getRuntime().exec("calc.exe");
                
            }catch(Exception ae){
                
                //if any error  arises it give a message
                JOptionPane.showMessageDialog(this, "Calculator not found","ERROR",JOptionPane.ERROR_MESSAGE);
 
            }
        }
    }

    
    public static void main(String args[]) {
        //for testing so i create object of project class
        new Project("","");
    }
}
