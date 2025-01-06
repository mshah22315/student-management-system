package studentmangementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * This is the class in which a connection to the database will be established.
 *
 * @author manth
 */
public class DatabaseConnection {
  /**
   * The connection to the database that will be established.
   * 
   */
  private Connection conn;
  /**
   * The SQL statement that will be sent to the database.
   * 
   */
  protected Statement s;
  
  public DatabaseConnection() {
    String dbURL = DatabaseConfiguration.getURL(); // Database URL
    String dbUser = DatabaseConfiguration.getUser(); // Database admin username
    String dbPwd = DatabaseConfiguration.getPwd(); // Database admin password
    
    /* Execute the logic within the try block; if exception is caught,
      print the stack trace of the exception. */
    try {
      /* Establishes database connection given its URL,
        admin username, and admin password. */
      conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
      /* Prepare statement that will be sent to the database. */
      s = conn.createStatement();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
