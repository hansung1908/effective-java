package chapter4.item24.anonymousclass;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 5, 6, 7, 1, 3, 4);

        // 익명 클래스 사용
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        // 람다 도입 후
        Collections.sort(list, Comparator.comparingInt(o -> o));
    }
}
