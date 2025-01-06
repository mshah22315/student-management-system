package studentmangementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 * This is where the program should start from. This is the initial title 
 * screen from where, if the login button is pressed, the program should go
 * to the login screen.
 *
 * @author manth
 */
public class TitleScreen extends JFrame implements ActionListener {
  
  /**
   * Constructor where the TitleScreen object is initialized.
   * 
   */
  public TitleScreen() {
    /* Set background color of the title screen. */
    getContentPane().setBackground(Color.LIGHT_GRAY);
    /* This is here to disregard the default layout that Swing gives us, 
      so that we can make our own layout. */
    setLayout(null);
    
    /* Add the name of the application to the title screen. */
    JLabel title = new JLabel("STUDENT MANAGEMENT SYSTEM");
    title.setBounds(80, 30, 1200, 60);
    title.setFont(new Font("arial", Font.PLAIN, 60));
    title.setForeground(Color.BLACK);
    add(title);
    
    /* Load in an image to set as the background of the title screen */
    ImageIcon originalImage = new ImageIcon(ClassLoader.getSystemResource("sms_images/kenny-eliason-zFSo6bnZJTw-unsplash.jpg"));
    Image imageCopy = originalImage.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
    ImageIcon otherImageCopy = new ImageIcon(imageCopy);
    JLabel image = new JLabel(otherImageCopy);
    image.setBounds(50, 100, 1050, 500);
    add(image);
    
    /* Add button that, when pressed, should lead to the login screen. */
    JButton start = new JButton("START");
    start.setBounds(400, 400, 300, 70);
    start.setBackground(Color.BLACK);
    start.setForeground(Color.WHITE);
    start.addActionListener(this);
    image.add(start);
    
    /* Set bounds and location of the title screen, 
      and ensure the title screen is visible. */
    setSize(1170, 650);
    setLocation(200, 50);
    setVisible(true);
  }
  
  /**
   * This is the required method for which the logic must be completed  
   * when implementing the ActionListener interface. In this case,
   * the only logic needed is to close the title screen, 
   * and open up the login screen.
   * 
   * @param event the action that is being performed
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    setVisible(false);
    new AdminLogin();
  }
  
  /**
   * Main method where an instance of the TitleScreen object is called.
   * 
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    new TitleScreen();
  }
}
