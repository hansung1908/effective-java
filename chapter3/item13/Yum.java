package chapter3.item13;

public class Yum {

    // 코드 13-7 복사 생성자
    public Yum(Yum yum) {}

    // 코드 13-8 복사 팩터리
    public static Yum newInstance(Yum yum) {
        return yum;
    }
}
