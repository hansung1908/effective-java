package chapter3.item10.inheritance;

import chapter3.item10.Point;

import java.util.*;

// CounterPoint를 Point로 사용하는 테스트 프로그램
public class CounterPointTest {
    // 단위 원 안의 모든 점을 포함하도록 unitCircle을 초기화한다.
    private static final Set<Point> unitCircle = Set.of(
            new Point( 1,  0), new Point( 0,  1),
            new Point(-1,  0), new Point( 0, -1));

    // onUnitCircle에서 사용한 Set을 포함하여 대부분의 컬렉션은 이 작업에 equals 메서드를 이용하는데,
    // CounterPoint의 인스턴스는 어떤 Point와도 같을 수 없기 때문에 항상 false를 반환할 것이다.
    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,  0);
        Point p2 = new CounterPoint(1,  0);

        // true를 출력한다.
        System.out.println(onUnitCircle(p1));

        // true를 출력해야 하지만, Point의 equals가 getClass를 사용해 작성되었다면 그렇지 않다.
        System.out.println(onUnitCircle(p2));
    }
}
