import java.sql.Connection;
import java.sql.SQLException;

public class NUserDao extends UserDao {

    // 상속을 통해 확장된 getConnection() method
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        // N 사 DB Connection 생성 코드
        return null;
    }
}
