package toby_spring.chapter1.user.dao;

import toby_spring.chapter1.user.connection_maker.ConnectionMaker;
import toby_spring.chapter1.user.connection_maker.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    private ConnectionMaker connectionMaker;

    private Connection c;
    private User user;

    public AccountDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void add(AccountDao accountDao)throws ClassNotFoundException, SQLException {

        Connection c = connectionMaker.makeConnection();    //인터페이스에 정의된 메소드를 사용하므로 클래스가 바뀐다고 해도 메소드의 이르밍 변경될 걱정은 없다.

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2,user.getName());
        ps.setString(3, user.getpassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException{

//        Connection c = connectionMaker.makeConnection();
//        PreparedStatement ps = c.prepareStatement(
//                "select * from users where id = ?" );
//        ps.setString(1,id);
//
//        ResultSet rs = ps.executeQuery();
//        rs.next();
//        User user = new User();
//        user.setId(rs.getString("id"));
//        user.setName(rs.getString("name"));
//        user.setPassword(rs.getString("password"));
//
//
//        rs.close();
//        ps.close();
//        c.close();
//
//        return user;

        this.c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?" );
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        this.user = new User();
        this.user.setId(rs.getString("id"));
        this.user.setName(rs.getString("name"));
        this.user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        this.c.close();

        return this.user;
    }

}
