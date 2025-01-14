package studentmangementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * This is the class where the logic for deleting a student from the records
 * is executed. The user will be able to select the student to delete based off
 * of their unique student ID.
 *
 * @author manth
 */
public class RemoveStudent extends JFrame implements ActionListener {
  /**
   * The selection menu for all student IDs in the database.
   * 
   */
  private Choice studentIDChoice;
  /**
   * The "Remove Student" button.
   * 
   */
  private final JButton remove;
  /**
   * The "Go Back" button.
   * 
   */
  private final JButton back;
  
  /**
   * 
   * Constructor where the RemoveStudent object will be created.
   */
  public RemoveStudent() {
    getContentPane().setBackground(Color.LIGHT_GRAY);
    setLayout(null); // disregard Swing's default layout
    
    JLabel studentIDLabel = new JLabel("Student ID");
    studentIDLabel.setBounds(50, 50, 100, 30);
    add(studentIDLabel);
    
    studentIDChoice = new Choice(); // initialize Choice object
    studentIDChoice.setBounds(200, 50, 150, 30);
    add(studentIDChoice);
    
    try {
      DatabaseConnection c = new DatabaseConnection();
      String query = "select * from students";
      ResultSet rs = c.s.executeQuery(query);
      /* Populate the Choice object with all student IDs in the database. */
      while (rs.next()) {
        studentIDChoice.add(rs.getString("studentid"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    JLabel nameLabel = new JLabel("Name");
    nameLabel.setBounds(50, 100, 100, 30);
    add(nameLabel);
    
    JLabel name = new JLabel();
    name.setBounds(200, 100, 100, 30);
    add(name);
    
    JLabel gradeLevelLabel = new JLabel("Undergraduate Status");
    gradeLevelLabel.setBounds(50, 150, 150, 30);
    add(gradeLevelLabel);
    
    JLabel gradeLevel = new JLabel();
    gradeLevel.setBounds(200, 150, 100, 30);
    add(gradeLevel);
    
    JLabel gpaLabel = new JLabel("GPA (on 4.0 scale)");
    gpaLabel.setBounds(50, 200, 150, 30);
    add(gpaLabel);
    
    JLabel gpa = new JLabel();
    gpa.setBounds(200, 200, 100, 30);
    add(gpa);
    
    try {
      DatabaseConnection c = new DatabaseConnection();
      String query = "select * from students where studentid = '"+studentIDChoice.getSelectedItem()+"'";
      ResultSet rs = c.s.executeQuery(query);
      /* For all students added, pull their name, undergraduate status, and GPA. */
      while (rs.next()) {
        name.setText(rs.getString("name"));
        gradeLevel.setText(rs.getString("gradelevel"));
        gpa.setText(rs.getString("gpa"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    studentIDChoice.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        try {
          DatabaseConnection c = new DatabaseConnection();
          String query = "select * from students where studentid = '"+studentIDChoice.getSelectedItem()+"'";
          ResultSet rs = c.s.executeQuery(query);
          while (rs.next()) {
            name.setText(rs.getString("name"));
            gradeLevel.setText(rs.getString("gradelevel"));
            gpa.setText(rs.getString("gpa"));
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    
    remove = new JButton("Remove Student"); // initialize remove button
    remove.setBounds(80, 300, 100, 30);
    remove.setBackground(Color.BLACK);
    remove.setForeground(Color.WHITE);
    remove.addActionListener(this);
    add(remove);
    
    back = new JButton("Go Back"); // initialize back button
    back.setBounds(220, 300, 100, 30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
    
    /* Load in and add image that will be used for this screen/ */
    ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("sms_images/linkedin-sales-solutions-h448yp0t2qQ-unsplash.jpg"));
    Image scaledImage = image.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
    ImageIcon imageCopy = new ImageIcon(scaledImage);
    JLabel imageLabel = new JLabel(imageCopy);
    imageLabel.setBounds(400, 0, 600, 400);
    add(imageLabel);
    
    setSize(1000, 400);
    setLocation(300, 150);
    setVisible(true);
  }

  /**
   * Required method from the ActionListener interface. All button logic
   * is dealt with here.
   * 
   * @param event the action being performed
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == remove) { // if "Remove Student" button pressed
      try {
        DatabaseConnection c = new DatabaseConnection();
        String query = "delete from students where studentid = '" + studentIDChoice.getSelectedItem() + "'";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Information Successfully Removed");
        setVisible(false);
        System.out.println("Will go back to main screen");
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else { // if "Go Back" button pressed
      setVisible(false);
      System.out.println("Go back to main screen");
    }
  }
  
  /**
   * Main method where an instance of RemoveStudent is called.
   * 
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    new RemoveStudent();
  }
}
