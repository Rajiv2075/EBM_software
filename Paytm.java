// Importing some java packages for swing and use of some property of awt, sql and event

package electricity.billing.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;


public class Paytm extends JFrame implements ActionListener{

    //swing components with specific variable name
    String meter;
    JButton back;
    
    Paytm(String meter){
        
        //storing value that pass when object is created
        this.meter=meter;
        
        //A image icon of this  frame
        ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
        Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        setIconImage(new ImageIcon(i11).getImage());
        
        // A editor pane with j name with property edit 
        JEditorPane j=new JEditorPane();
        j.setEditable(false);
                
        try{
            
            //setpage with this website look like all function and picture
            j.setPage("https://paytm.com/online-payments");
            
        }catch(Exception e){
            
            //if error arises then the set text will displayes
           j.setContentType("text/html");
           j.setText("<html>Could not Load</html>");
           
           
        }
        
        // JScrollPane with name js
        JScrollPane js=new JScrollPane(j);
        add(js);
        
        // button with back name and property with add actionlistener
        back=new JButton("BACK");
        back.setBounds(690,70,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        j.add(back);
        back.addActionListener(this);
        
        //some property applied for this frame
        setResizable(true);
        setSize(980,700);
        setLocation(250,50);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public @Override void actionPerformed(ActionEvent e){
        
        //click on back button then frame will close and PayBill frame will open
        setVisible(false);
        new PayBill(meter);
    }

    
    public static void main(String args[]) {
        
        //for testing so i create object of Paytm class
        new Paytm("");
    }
}
