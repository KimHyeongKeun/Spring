package toby_spring.chapter1.user.connection_maker;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoConnectioinCountingTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(CountingDaoFactory.class);

        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection Counter:" +ccm.getCounter());

    }



}
