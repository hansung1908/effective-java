package chapter4.item19;

import java.time.Instant;

// 생성자에서 호출하는 메서드를 재정의했을 때의 문제를 보여준다.
public final class Sub extends Super {
    // 초기화되지 않은 final 필드. 생성자에서 초기화한다.
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    // 재정의 가능 메서드. 상위 클래스의 생성자가 호출한다.
    @Override public void overrideMe() {
        System.out.println(instant);
    }

    // 이 프로그램이 instant를 두 번 출력하리라 기대했겠지만, 첫 번째는 null을 출력한다.
    // 상위 클래스의 생성자는 하위 클래스의 생성자가 인스턴스 필드를 초기화하기도 전에 overrideMe를 호출하기 때문이다.
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
