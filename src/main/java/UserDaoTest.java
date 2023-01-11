
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{

        UserDao userDao = new DaoFactory().userDao();

        ApplicationContext context =
                new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);      //getBean()이라는 메소드를 이용해 UserDao정보를 가져온다.

        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();

        UserDao dao3 = context.getBean("userDao", UserDao.class);
        UserDao dao4 = context.getBean("userDao", UserDao.class);

        AccountDao dao5 = context.getBean("accountDao", AccountDao.class);
        AccountDao dao6 = context.getBean("accountDao", AccountDao.class);

        System.out.println(dao1);
        System.out.println(dao2);

        System.out.println(dao3);
        System.out.println(dao4);

        System.out.println(dao5);
        System.out.println(dao6);

        User user = new User();
        user.setId("Ship");
        user.setName("김");
        user.setPassword("kim");

        userDao.add(user);

        System.out.println(user.getId()+"등록 성공");
        User user2 = userDao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getpassword());

        System.out.println(user2.getId()+"조회 성공");
    }

}
