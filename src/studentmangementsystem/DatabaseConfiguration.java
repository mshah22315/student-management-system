package studentmangementsystem;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author manth
 */
public class DatabaseConfiguration {
  private static Properties properties;
  
  static {
    properties = new Properties();
    try (InputStream input = DatabaseConfiguration.class.getClassLoader().getResourceAsStream("dbproperties.properties")) {
      if (input == null) {
        System.out.println("Unable to find dbproperties.properties");
      }
      properties.load(input);
    } catch (Exception e) {
      e.printStackTrace();
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
