
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {


    public Connection makeConnection() throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection c = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","MySQL");

        return c;
    }


}
