// Importing some java packages for swing and use of some property of awt
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;


public   class Splash extends JFrame implements Runnable {
    
    Splash(){
       
       // here, we define some frame property
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //here, we put a image icon for this frame
      ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icon/logoE.jpg"));
      Image i11=i10.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
      setIconImage(new ImageIcon(i11).getImage());
      
      // here, we take a image for interface
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
      Image i2=i1.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT );
      ImageIcon i3=new ImageIcon(i2);  
      JLabel image=new JLabel(i3);
      add(image);
      
      // Here, we want to put a animation like opening window of the our project
      for(int i=0;i<360;i=i+1){
            setLocation(850-i,550-i);
            setSize(2*i,i+i/2); 
            try{
              Thread.sleep(2);
            }catch(Exception e){
              JOptionPane.showMessageDialog(null, "System not responding");

            }
       }
      
       // here, we take a obj of Thread class for call sleep method
       Thread t=new Thread(this);
       t.start();

       //visible for frame for all
       setVisible(true);
       
    }
    
    // here, run method of Thread class
    public @Override void   run(){
        try{
            //here, frame hold on the screen for 7 sec. then it automatically close
            Thread.sleep(7000);
            setVisible(false);
            
            //when splash class frame closes, then it automatically open login frame;
            new Login();
        }catch(Exception e){
            // if Exception arises then it give a  message for user
            JOptionPane.showMessageDialog(null, "Wait!");

        }
    }
    
   
    public static void main(String[] args) {
       //here, we made a object of the class Splash for constructor call
      new Splash();
    }
}
