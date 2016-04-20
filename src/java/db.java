
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class db {
    private static Connection con=null;
  public static Connection createConnection()
  {
      
      try
      {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
      }
      catch(ClassNotFoundException e)
      {
          System.out.println(e);
      }
      try
      {
          con=DriverManager.getConnection("jdbc:derby://localhost:1527/EMAILER","MANAS","123");
      }
      catch(SQLException e)
      {
         System.out.println(e); 
      }
      return con;
  }
    
}
