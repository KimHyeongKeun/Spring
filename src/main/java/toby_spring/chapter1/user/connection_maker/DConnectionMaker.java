package toby_spring.chapter1.user.connection_maker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {


    public Connection makeConnection() throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","MySQL");

        return connection;
    }


}
