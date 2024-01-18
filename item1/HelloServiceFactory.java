package item1;

import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static HelloService of(String lang) {
        if(lang.equals("ko")) {
            return new KoreanHelloService();
        } else {
          return new EnglishHelloService();
        }
    }

    public static void main(String[] args) {
        // 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
        HelloService ko = HelloServiceFactory.of("ko");
        System.out.println(ko.hello());

        HelloService eng = HelloServiceFactory.of("eng");
        System.out.println(eng.hello());
    }
}
