package chapter3.item14;

import java.util.Comparator;

public class CompareMethod {

//    // 코드 14-4 해시코드 값의 차를 기준으로 하는 비교자 - 추이성을 위배한다!
//    // 이 방식은 정수 오버플로를 일으키거나 IEEE 754 부동소수점 계산방식에 따른 오류를 낼 수 있다.
//    static Comparator<Object> hashCodeOrder = new Comparator<>() {
//        @Override
//        public int compare(Object o1, Object o2) {
//            return o1.hashCode() - o2.hashCode();
//        }
//    };

    // 코드 14-5 정적 compare 메서드를 활용한 비교자
    static Comparator<Object> hashCodeOrder = new Comparator<>() {
        @Override
        public int compare(Object o1, Object o2) {
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
    };

    // 코드 14-6 비교자 생성 메서드를 활용한 비교자
    static Comparator<Object> hashCodeOrder2 =
            Comparator.comparingInt(o -> o.hashCode());
}
