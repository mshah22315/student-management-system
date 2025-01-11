package studentmangementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 * This is the class where the logic for viewing already added employees is 
 * executed. This is where the list of all added employees, as well as
 * details for specific employees can be viewed.
 *
 * @author manth
 */
public class ViewStudents extends JFrame implements ActionListener {
  /**
   * The table containing all students entered into the database.
   * 
   */
  private JTable table;
  /**
   * The drop-down menu including all valid student IDs.
   * 
   */
  private Choice chooseStudentID;
  /**
   * The button for finding a student.
   * 
   */
  private final JButton find;
  /**
   * The button for getting a PDF of the table.
   * 
   */
  private final JButton display;
  /**
   * The button for updating a student's information.
   * 
   */
  private final JButton update;
  /**
   * The button for going back to the main page.
   * 
   */
  private final JButton back;
  
  public ViewStudents() {
    getContentPane().setBackground(Color.LIGHT_GRAY);
    /* Disregard Swing's default layout to make our own layout. */
    setLayout(null);
    
    /* Create label indicating where to find specific students. */
    JLabel findLabel = new JLabel("Find Student by ID");
    findLabel.setBounds(20, 20, 150, 20);
    add(findLabel);
    
    /* Create dropdown menu indicating choice of student ID. */
    chooseStudentID = new Choice();
    chooseStudentID.setBounds(180, 20, 150, 20);
    add(chooseStudentID);
    
    try {
      DatabaseConnection c = new DatabaseConnection();
      ResultSet rs = c.s.executeQuery("select * from students");
      
      /* If the query is valid, pull all student IDs out. */
      while (rs.next()) {
        chooseStudentID.add(rs.getString("studentid"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    table = new JTable();
    
    try {
      DatabaseConnection c = new DatabaseConnection();
      ResultSet rs = c.s.executeQuery("select * from students");
      /* Convert ResultSet object into JTable object. */
      table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    /* Add scrolling functionality to the table. */
    JScrollPane pane = new JScrollPane(table);
    pane.setBounds(0, 100, 900, 600);
    add(pane);
    
    /* Set up the "Find Student" button. */
    find = new JButton("Find Student");
    find.setBounds(20, 70, 180, 20);
    find.addActionListener(this);
    add(find);
    
    /* Set up the "Print Student List" button. */
    display = new JButton("Print Student Table");
    display.setBounds(220, 70, 180, 20);
    display.addActionListener(this);
    add(display);
    
    /* Set up the "Update Student" button. */
    update = new JButton("Update Student");
    update.setBounds(420, 70, 180, 20);
    update.addActionListener(this);
    add(update);
    
    /* Set up the "Go Back" button. */
    back = new JButton("Go Back");
    back.setBounds(620, 70, 180, 20);
    back.addActionListener(this);
    add(back);
    
    /* Set bounds and location of the screen, 
      and ensure it is visible. */
    setSize(900, 700);
    setLocation(300, 100);
    setVisible(true);
  }
  
  /**
   * The required method to be implemented from the ActionListener interface.
   * All button logic goes here.
   * 
   * @param event the action being performed
   */
  public void actionPerformed(ActionEvent event) {
    /* Execute this logic if "Find Student" button pressed. */
    if (event.getSource() == find) {
      String query = "select * from students where studentid = '"+chooseStudentID.getSelectedItem()+"'";
      try {
        DatabaseConnection c = new DatabaseConnection();
        ResultSet rs = c.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (event.getSource() == display) { /* Execute this logic if "Print Student List" button pressed. */
      try {
        table.print();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (event.getSource() == update) { /* Execute this logic if "Update Student" button pressed. */
      setVisible(false);
      new UpdateStudent(chooseStudentID.getSelectedItem());
    } else if (event.getSource() == back) { /* Execute this logic if "Go Back" button pressed. */
      setVisible(false);
      /* Will later add functionality to switch to MainPage. */
      System.out.println("Will go back to main page");
    }
  }
  
  /**
   * Main method where an instance of ViewStudents is called.
   * 
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    new ViewStudents();
  }
}
