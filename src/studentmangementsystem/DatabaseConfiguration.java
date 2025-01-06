package studentmangementsystem;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manth
 */
public class DatabaseConfiguration {
  private static Properties properties;
  
  static {
    properties = new Properties();
    try (InputStream input = DatabaseConfiguration.class.getClassLoader().getResourceAsStream("config.properties")) {
      if (input == null) {
        System.out.println("Unable to find config.properties");
      }
      properties.load(input);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
    
  public static String getURL() {
    return properties.getProperty("db.url");
  }
    
  public static String getUser() {
    return properties.getProperty("db.user");
  }
    
  public static String getPwd() {
    return properties.getProperty("db.password");
  }
}
