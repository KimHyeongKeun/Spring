import java.sql.*;

public abstract class UserDao {

    private ConnectionMaker connectionMaker;   //인터페이스를 통해 오브젝트에 접근하므로 구체적인 클래스 정보를 알 필요가 없다.

    public UserDao(){
        connectionMaker = new DConnectionMaker();   //여기서 클래스 이름이 나온다.

    }
    public void add(User user)throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost/mysql","root","MySQL");
//        Connection c = getConnection();
        Connection c = connectionMaker.makeConnection();    //인터페이스에 정의된 메소드를 사용하므로 클래스가 바뀐다고 해도 메소드의 이르밍 변경될 걱정은 없다.
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3, user.getpassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException{
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost/mysql","root","MySQL");
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?" );
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));


        rs.close();
        ps.close();
        c.close();

        return user;
    }

    //중복된 코드를 제거하기 위해 getConnection이라는 함수를 사용하였다.
//    private Connection getConnection() throws ClassNotFoundException,SQLException{
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost/mysql","root","MySQL");
//
//        return c;
//
//    }
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;


//    public static void main(String[] args) throws ClassNotFoundException, SQLException{
//        UserDao dao = new UserDao() {
//            @Override
//            public Connection getConnection() throws ClassNotFoundException, SQLException {
//                return null;
//            }
//        };
//
//        User user = new User();
//        user.setId("whiteship");
//        user.setName("심범수");
//        user.setPassword("ok");
//
//        dao.add(user);
//
//        System.out.println(user.getId()+"등록 성공");
//        User user2 = dao.get(user.getId());
//        System.out.println(user2.getName());
//        System.out.println(user2.getpassword());
//
//        System.out.println(user2.getId()+"조회 성공");
//    }

}

