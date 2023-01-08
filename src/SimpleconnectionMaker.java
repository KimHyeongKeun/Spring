
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class SimpleconnectionMaker {  //더 이상 상속을 이용한 확장 방식을 사용할 필요가 없으니 추상 클래스로 만들 필요가 없다.
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","MySQL");

        return c;
    }
}
