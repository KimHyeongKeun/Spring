import java.sql.Connection;
import java.sql.SQLException;

import java.sql.*;

public class DUserDao extends UserDao {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        // D 사 DB Connection 생성 코드

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","MySQL");

        return c;

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException{

        DUserDao Ddao = new DUserDao();

        User user = new User();
        user.setId("Greenship");
        user.setName("김나물");
        user.setPassword("gg");

        Ddao.add(user);

        System.out.println(user.getId()+"등록 성공");
        User user2 = Ddao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getpassword());

        System.out.println(user2.getId()+"조회 성공");
    }
}
