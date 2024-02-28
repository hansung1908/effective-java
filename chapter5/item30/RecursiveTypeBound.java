package chapter5.item30;

import java.util.*;

// 재귀적 타입 한정을 이용해 상호 비교할 수 있음을 표현
public class RecursiveTypeBound {
    // 코드 30-7 컬렉션에서 최댓값을 반환한다. - 재귀적 타입 한정 사용
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("컬렉션이 비어 있습니다.");

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }

    // 빈 컬렉션을 건네면 IllegalArgumentException을 던지니, Optional<E>를 반환하도록 고치는 편이 나을 것이다.
    public static void main(String[] args) {
        List<String> argList = Arrays.asList();
        System.out.println(max(argList));
    }
}
