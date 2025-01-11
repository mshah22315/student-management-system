package studentmangementsystem;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This is the class where the logic for adding students to the system is
 * executed. Information such as name, GPA, grade level are input from the user,
 * and, once finished, the student can be added into the students database.
 *
 * @author manth
 */
public class AddStudent extends JFrame implements ActionListener {
  /* Logic for randomly generating 5-digit number for the student ID. */
  private final Random randomizer = new Random();
  private final int randomNumber = randomizer.nextInt(99999);
  /**
   * The name of the student.
   * 
   */
  private final JTextField name;
  
  /**
   * The emergency content for the student.
   * 
   */
  private final JTextField emergencyContact;
  
  /**
   * The home address of the student.
   * 
   */
  private final JTextField address;
  
  /**
   * The phone number of the student.
   * 
   */
  private final JTextField phoneNo;
  
  /**
   * The email of the student.
   * 
   */
  private final JTextField email;
  
  /**
   * The GPA of the student.
   * 
   */
  private final JTextField gpa;
  
  /**
   * The date of birth of the student.
   * 
   */
  private final JDateChooser birthday;
  
  /**
   * The undergraduate level of the student.
   * 
   */
  private final JComboBox gradeLevel;
  
  /**
   * The unique ID of the student.
   * 
   */
  private final JLabel studentID;
  
  /**
   * The add button for adding the student.
   * 
   */
  private final JButton add;
  
  /**
   * The back button for going back to the main screen.
   * 
   */
  private final JButton back;
  
  /**
   * Constructor where the AddStudent object is created.
   */
  public AddStudent() {
    /* Set the background color of the screen. */
    getContentPane().setBackground(Color.LIGHT_GRAY);
    /* Disregard the default layout that Swing gives us, 
      so that we can make our own layout. */
    setLayout(null);
    
    /* Create the heading of the screen. */
    JLabel heading = new JLabel("Student Information");
    heading.setBounds(320, 30, 500, 50);
    heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
    add(heading);
    
    /* Create the label for indicating where to enter the student's name. */
    JLabel nameLabel = new JLabel("Name");
    nameLabel.setBounds(50, 150, 150, 30);
    nameLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(nameLabel);
    
    /* Create text box in which name will be typed. */
    name = new JTextField();
    name.setBounds(200, 150, 150, 30);
    add(name);
    
    /* Create the label for indicating where to enter the student's undergraduate level. */
    JLabel gradeLevelLabel = new JLabel("Undergraduate Status");
    gradeLevelLabel.setBounds(400, 150, 150, 30);
    gradeLevelLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(gradeLevelLabel);

    /* Create selection box in which grade level will be selected. */
    String levels[] = {"Freshman", "Sophomore", "Junior", "Senior"};
    gradeLevel = new JComboBox(levels);
    gradeLevel.setBackground(Color.WHITE);
    gradeLevel.setBounds(600, 150, 150, 30);
    add(gradeLevel);
    
    /* Create the label for indicating where the student's GPA will be typed. */
    JLabel gpaLabel = new JLabel("GPA (4.0 scale)");
    gpaLabel.setBounds(50, 200, 150, 30);
    gpaLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(gpaLabel);
    
    /* Create text box in which GPA will be typed. */
    gpa = new JTextField();
    gpa.setBounds(200, 200, 150, 30);
    add(gpa);
    
    /* Create the label for indicating where the student's birthday will be typed. */
    JLabel birthdayLabel = new JLabel("Birthday");
    birthdayLabel.setBounds(400, 200, 150, 30);
    birthdayLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(birthdayLabel);
    
    /* Create date chooser in which birthday will be selected. */
    birthday = new JDateChooser();
    birthday.setBounds(600, 200, 150, 30);
    add(birthday);
    
    /* Create the label for indicating where the student's email will be typed. */
    JLabel emailLabel = new JLabel("Email");
    emailLabel.setBounds(50, 250, 150, 30);
    emailLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(emailLabel);

    /* Create text box in which email will be typed. */
    email = new JTextField();
    email.setBounds(200, 250, 150, 30);
    add(email);
    
    /* Create the label for indicating where the student's phone number will be typed. */
    JLabel phoneNoLabel = new JLabel("Phone Number");
    phoneNoLabel.setBounds(400, 250, 150, 30);
    phoneNoLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(phoneNoLabel);

    /* Create text box in which phone number will be typed. */
    phoneNo = new JTextField();
    phoneNo.setBounds(600, 250, 150, 30);
    add(phoneNo);
    
    /* Create the label for indicating where the student's home address will be typed. */
    JLabel addressLabel = new JLabel("Address");
    addressLabel.setBounds(50, 300, 150, 30);
    addressLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(addressLabel);
    
    /* Create text box in which address will be typed. */
    address = new JTextField();
    address.setBounds(200, 300, 150, 30);
    add(address);
    
    /* Create the label for indicating where the student's emergency contact will be typed. */
    JLabel emergencyContactLabel = new JLabel("Emergency Contact");
    emergencyContactLabel.setBounds(400, 300, 200, 30);
    emergencyContactLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(emergencyContactLabel);
    
    /* Create text box in which emergency contact will be typed. */
    emergencyContact = new JTextField();
    emergencyContact.setBounds(600, 300, 150, 30);
    add(emergencyContact);
    
    /* Create the label for indicating where the student's student ID will be shown. */
    JLabel studentIDLabel = new JLabel("Student ID");
    studentIDLabel.setBounds(50, 350, 150, 30);
    studentIDLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(studentIDLabel);
    
    /* Create label in which student ID will be. */
    studentID = new JLabel("" + randomNumber);
    studentID.setBounds(200, 350, 150, 30);
    add(studentID);
    
    /* Create add button to confirm addition of student. */
    add = new JButton("Add Student");
    add.setBounds(250, 550, 150, 40);
    add.addActionListener(this);
    add.setBackground(Color.BLACK);
    add.setForeground(Color.WHITE);
    add(add);

    /* Create back button to go back to the main screen. */
    back = new JButton("Go Back");
    back.setBounds(450, 550, 150, 40);
    back.addActionListener(this);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    add(back);
    
    /* Set bounds and location of the screen, 
      and ensure it is visible. */
    setSize(900, 700);
    setLocation(300, 50);
    setVisible(true);
  }
  
  /**
   * Required class to implement when implementing the ActionListener interface.
   * This is where the connection to the database is made, and the student's
   * information is added to the database if the "Add Student" button is clicked, 
   * or the screen changes to the main screen if the "Go Back" button is clicked.
   * 
   * @param event the action being performed
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    /* Execute this logic if "Add Student" button clicked. */
    if (event.getSource() == add) {
      /* Get all necessary student information. */
      String nameCopy = name.getText();
      String gradeLevelCopy = (String) gradeLevel.getSelectedItem();
      String gpaCopy = gpa.getText();
      String birthdayCopy = ((JTextField) birthday.getDateEditor().getUiComponent()).getText();
      String emailCopy = email.getText();
      String phoneNoCopy = phoneNo.getText();
      String addressCopy = address.getText();
      String emergencyContactCopy = emergencyContact.getText();
      String studentIDCopy = studentID.getText();
      
      try {
        DatabaseConnection c = new DatabaseConnection();
        String query = "insert into students values('" + nameCopy + "', '" + gradeLevelCopy + "', '" + gpaCopy + "', '" + birthdayCopy + "', '" + emailCopy + "', '" + phoneNoCopy + "', '" + addressCopy + "', '" + emergencyContactCopy + "', '" + studentIDCopy + "')";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Details added successfully");
        /* For now, print "Success" if all this is done. (Will later add 
          functionality to swap the screen back to the main screen.)*/
        setVisible(false);
        System.out.println("Success");
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else { /* Execute this logic if "Go Back" button clicked. */
      setVisible(false);
      System.out.println("Other Success");
    }
  }
  
  /**
   * Main method where an instance of AddStudent is called.
   * 
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    new AddStudent();
  }
    
}
