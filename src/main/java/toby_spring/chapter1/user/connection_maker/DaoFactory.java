package toby_spring.chapter1.user.connection_maker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시다.
public class DaoFactory {

    @Bean//오브젝트 생성을 담당하는 IOC용 메소드라는 표시다.
    public UserDao userDao(){  //팩토리의 메소드는 UserDao타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지를 결정한다.
        return new UserDao(connectionMaker());
    }




    @Bean
    public AccountDao accountDao(){
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao(){
        return new MessageDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker(); //분리해서 중복을 제거한 ConnectionMaker타입 오브젝트 생성코드
    }



}
