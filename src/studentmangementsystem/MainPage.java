package studentmangementsystem;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author manth
 */
public class MainPage extends JFrame implements ActionListener {
  private JButton view;
  private JButton add;
  private JButton update;
  private JButton remove;
  
  public MainPage() {
    setLayout(null);
    
    ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("sms_images/akson-1K8pIbIrhkQ-unsplash.jpg"));
    Image scaledImage = image.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
    ImageIcon imageCopy = new ImageIcon(scaledImage);
    JLabel imageLabel = new JLabel(imageCopy);
    imageLabel.setBounds(0, 0, 1120, 630);
    add(imageLabel);
    
    JLabel title = new JLabel("Student Management System");
    title.setBounds(750, 20, 400, 40);
    title.setFont(new Font("Times New Roman", Font.BOLD, 25));
    imageLabel.add(title);
    
    add = new JButton("Add Student");
    add.setBounds(750, 80, 150, 40);
    add.addActionListener(this);
    imageLabel.add(add);
    
    view = new JButton("View Students");
    view.setBounds(920, 80, 150, 40);
    view.addActionListener(this);
    imageLabel.add(view);

    update = new JButton("Update Student");
    update.setBounds(750, 140, 150, 40);
    update.addActionListener(this);
    imageLabel.add(update);

    remove = new JButton("Remove Student");
    remove.setBounds(920, 140, 150, 40);
    remove.addActionListener(this);
    imageLabel.add(remove);

    setSize(1120, 630);
    setLocation(250, 100);
    setVisible(true);
  }
  
  @Override
  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == add) {
      setVisible(false);
      new AddStudent();
    } else if (event.getSource() == view) {
      setVisible(false);
      new ViewStudents();
    } else if (event.getSource() == update) {
      setVisible(false);
      new ViewStudents();
    } else {
      setVisible(false);
      new RemoveStudent();
    }
  }
  
  public static void main(String[] args) {
    new MainPage();
  }
  
}
