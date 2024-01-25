package chapter2.item6;

public class stringinstance {
    // 문장이 실행될 때마다 String 인스턴스를 새로 만들어서 자원이 낭비된다.
    String s = new String("bikini"); // 따라 하지 말 것!

    // 하나의 String 인스턴스를 사용한다.
    String s1 = "bikini";
}
