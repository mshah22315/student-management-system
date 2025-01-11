package studentmangementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This is the class where the logic for updating the information of an already
 * added student is executed. Name, birthday, and student ID cannot be changed,
 * but all other fields can be adjusted. Once updated here, this information is
 * also properly updated in the database.
 *
 * @author manth
 */
public class UpdateStudent extends JFrame implements ActionListener {
  /**
   * The undergraduate status of the student.
   * 
   */
  private JComboBox gradeLevel;
  /**
   * The GPA on a scale of 4.0 of the student.
   * 
   */
  private JTextField gpa;
  /**
   * The email address of the student.
   * 
   */
  private JTextField email;
  /**
   * The phone number of the student.
   * 
   */
  private JTextField phoneNo;
  /**
   * The home address of the student.
   * 
   */
  private JTextField address;
  /**
   * The emergency contact for the student.
   *
   */
  private JTextField emergencyContact;
  /**
   * The "Update" button that, when pressed, will update the student's
   * information in the database.
   * 
   */
  private final JButton update;
  /**
   * The "Go Back" button that, when pressed, allows the user to return
   * to the main page.
   * 
   */
  private final JButton back;
  /**
   * The string representation of the student's unique ID.
   * 
   */
  private String studentID;
  
  /**
   * Constructor where the UpdateStudent object will be built.
   * 
   * @param studentID the ID of the student as a string
   */
  public UpdateStudent(String studentID) {
    
    this.studentID = studentID; // student ID is set
    getContentPane().setBackground(Color.LIGHT_GRAY);
    /* Disregard default layout to make our own layout. */
    setLayout(null);
    
    /* Set up the main title of the screen. */
    JLabel heading = new JLabel("Update Student Information");
    heading.setBounds(320, 30, 500, 50);
    heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
    add(heading);
    
    JLabel nameLabel = new JLabel("Name");
    nameLabel.setBounds(50, 150, 150, 30);
    nameLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(nameLabel);
    
    /* No text box added here because name will remain constant. */
    JLabel name = new JLabel();
    name.setBounds(200, 150, 150, 30);
    add(name);
    
    JLabel gradeLevelLabel = new JLabel("Undergraduate Status");
    gradeLevelLabel.setBounds(400, 150, 150, 30);
    gradeLevelLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(gradeLevelLabel);
    
    String levels[] = {"Freshman", "Sophomore", "Junior", "Senior"};
    gradeLevel = new JComboBox(levels);
    gradeLevel.setBackground(Color.WHITE);
    gradeLevel.setBounds(600, 150, 150, 30);
    add(gradeLevel);
    
    JLabel gpaLabel = new JLabel("GPA (4.0 scale)");
    gpaLabel.setBounds(50, 200, 150, 30);
    gpaLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(gpaLabel);
    
    gpa = new JTextField();
    gpa.setBounds(200, 200, 150, 30);
    add(gpa);
    
    JLabel birthdayLabel = new JLabel("Birthday");
    birthdayLabel.setBounds(400, 200, 150, 30);
    birthdayLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(birthdayLabel);
    
    /* No date chooser object added here because birthday will remain constant. */
    JLabel birthday = new JLabel();
    birthday.setBounds(600, 200, 150, 30);
    add(birthday);
    
    JLabel emailLabel = new JLabel("Email");
    emailLabel.setBounds(50, 250, 150, 30);
    emailLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(emailLabel);
    
    email = new JTextField();
    email.setBounds(200, 250, 150, 30);
    add(email);
    
    JLabel phoneNoLabel = new JLabel("Phone Number");
    phoneNoLabel.setBounds(400, 250, 150, 30);
    phoneNoLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(phoneNoLabel);
    
    phoneNo = new JTextField();
    phoneNo.setBounds(600, 250, 150, 30);
    add(phoneNo);
    
    JLabel addressLabel = new JLabel("Address");
    addressLabel.setBounds(50, 300, 150, 30);
    addressLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(addressLabel);
    
    address = new JTextField();
    address.setBounds(200, 300, 150, 30);
    add(address);
    
    JLabel emergencyContactLabel = new JLabel("Emergency Contact");
    emergencyContactLabel.setBounds(400, 300, 200, 30);
    emergencyContactLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(emergencyContactLabel);
    
    emergencyContact = new JTextField();
    emergencyContact.setBounds(600, 300, 150, 30);
    add(emergencyContact);
    
    JLabel labelStudentID = new JLabel("Student ID");
    labelStudentID.setBounds(50, 350, 150, 30);
    labelStudentID.setFont(new Font("serif", Font.PLAIN, 20));
    add(labelStudentID);
    
    /* Unique student ID for each student, thus student ID cannot be changed. */
    JLabel studentIDLabel = new JLabel();
    studentIDLabel.setBounds(200, 350, 150, 30);
    studentIDLabel.setFont(new Font("serif", Font.PLAIN, 20));
    add(studentIDLabel);
    
    try {
      DatabaseConnection c = new DatabaseConnection();
      String query = "select * from students where studentid = '"+studentID+"'";
      ResultSet rs = c.s.executeQuery(query);
      
      /* Pull all individual values of the database entry obtained from the query. */
      while (rs.next()) {
        name.setText(rs.getString("name"));
        /* This is different because gradeLevel is a combo box object, 
          not a text field. */
        gradeLevel.setSelectedItem(rs.getString("gradelevel"));
        gpa.setText(rs.getString("gpa"));
        birthday.setText(rs.getString("birthday"));
        email.setText(rs.getString("email"));
        phoneNo.setText(rs.getString("phone"));
        address.setText(rs.getString("address"));
        emergencyContact.setText(rs.getString("econtact"));
        studentIDLabel.setText(rs.getString("studentid"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    update = new JButton("Update");
    update.setBounds(250, 550, 150, 40);
    update.addActionListener(this);
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    add(update);
    
    back = new JButton("Go Back");
    back.setBounds(450, 550, 150, 40);
    back.addActionListener(this);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    add(back);
    
    setSize(900, 700);
    setLocation(300, 50);
    setVisible(true);
  }
  
  /**
   * Required class from the ActionListener interface that must be implemented.
   * All button logic will go here.
   * 
   * @param event the action being performed
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    /* Execute this logic if the "Update" button is pressed. */
    if (event.getSource() == update) {
      String gradeLevelString = gradeLevel.getSelectedItem().toString();
      String gpaString = gpa.getText();
      String emailString = email.getText();
      String phoneNoString = phoneNo.getText();
      String addressString = address.getText();
      String emergencyContactString = emergencyContact.getText();
      
      try {
        DatabaseConnection c = new DatabaseConnection();
        String query = "update students set gradelevel = '"+gradeLevelString+"', gpa = '"+gpaString+"', email = '"+emailString+"', phone = '"+phoneNoString+"', address =  '"+addressString+"', econtact = '"+emergencyContactString+"' where studentid = '"+studentID+"'";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Details added successfully");
        setVisible(false);
        /* Will later add functionality to return to main page. */
        System.out.println("Will go to main page");
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else { /* Execute this logic if the "Go Back" button is pressed. */
      setVisible(false);
      System.out.println("Will go to main page"); // same as above
    }
  }
  
  /**
   * Main method where an instance of UpdateStudent is called.
   * 
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    new UpdateStudent("");
  }
}
