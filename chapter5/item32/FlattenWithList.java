package chapter5.item32;

import java.util.*;

// 코드 32-4 제네릭 varargs 매개변수를 List로 대체한 예 - 타입 안전하다.
public class FlattenWithList {
    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        // 이렇게 사용하는게 가능한 이유는 List.of에도 @SafeVarargs 애너테이션이 달려 있기 때문이다.
        List<Integer> flatList = flatten(List.of(
                List.of(1, 2), List.of(3, 4, 5), List.of(6,7)));
        System.out.println(flatList);
    }
}
