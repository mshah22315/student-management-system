package studentmangementsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



/**
 * This is the login class. This is where admin credentials are entered, and,
 * if the username and password entered match the username and password in a
 * connected database storing the login info, then the user is taken to the
 * main page.
 *
 * @author manth
 */
public class AdminLogin extends JFrame implements ActionListener {
  /**
   * The username of the admin.
   * 
   */
  private JTextField user;
  /**
   * The password of the admin.
   * 
   */
  private JTextField pwd;
  
  /**
   * The constructor where the AdminLogin object is created.
   */
  public AdminLogin() {
    /* Set the background color of the login screen. */
    getContentPane().setBackground(Color.LIGHT_GRAY);
    /* Disregard the default layout that Swing gives us, 
      so that we can make our own layout. */
    setLayout(null);
    
    /* Create a label for indicating where the username should be typed. */
    JLabel userLabel = new JLabel("Username");
    userLabel.setBounds(40, 20, 100, 30);
    add(userLabel);
    
    /* Add a box to the right of the label in which the username is typed. */
    user = new JTextField();
    user.setBounds(190, 20, 150, 30);
    add(user);
    
    /* Create a label for indicating where the password should be typed. */
    JLabel pwdLabel = new JLabel("Password");
    pwdLabel.setBounds(40, 70, 100, 30);
    add(pwdLabel);
    
    /* Add a box to the right of the label in which the password is typed. */
    pwd = new JPasswordField();
    pwd.setBounds(190, 70, 150, 30);
    add(pwd);
    
    /* Add a login button that, when clicked, should lead to the main page. */
    JButton login = new JButton("LOGIN");
    login.setBounds(190, 140, 150, 30);
    login.setBackground(Color.WHITE);
    login.setForeground(Color.BLACK);
    login.addActionListener(this);
    add(login);
    
    /* Set bounds and location of the login screen, 
      and ensure the login screen is visible. */
    setSize(600, 300);
    setLocation(450, 200);
    setVisible(true);
  }
  
  /**
   * This is the required method for which the logic must be completed  
   * when implementing the ActionListener interface. In this case,
   * the connection to the database must first be established, and then
   * the login info given must be validated; that is, a check is made to
   * ensure that the username and password are in the adminlogin table.
   * 
   * @param event the action being performed
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    /* Execute the logic within the try block; if exception is caught,
      print the stack trace of the exception. */
    try {
      String username = user.getText(); // Username string representation
      String password = pwd.getText(); // Password string representation
      
      DatabaseConnection c = new DatabaseConnection(); // Database connection
      /* Query that will be executed on the database. */
      String query = "select * from adminlogin where username = '" + username + "' and password = '" + password + "'";
      
      /* Data obtained from executing the query. */
      ResultSet set = c.s.executeQuery(query);
      /* For now, check if the data is valid; 
        close login screen and print "Good" if so, otherwise, print 
        "Invalid username or password" (will later change this
        to open up the main page).*/
      if (set.next()) {
        setVisible(false);
        System.out.println("Good");
      } else {
        JOptionPane.showMessageDialog(null, "Invalid username or password");
        setVisible(false);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Main method where an instance of the AdminLogin object is called.
   * 
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    new AdminLogin();
  }
    
}
