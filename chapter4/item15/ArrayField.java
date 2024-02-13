package chapter4.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayField {
    // 보안 허점이 숨어 있다.
    // 이런 필드나 접근자를 제공한다면 클라이언트에서 그 배열의 내용을 수정할 수 있게 된다.
    public static final Thing[] VALUES = {new Thing("a"), new Thing("b"), new Thing("c")};

    // 해결책 1. 앞 코드의 public 배열을 private으로 만들고 public 불변 리스트를 추가하는 것이다.
    private static final Thing[] PRIVATE_VALUES = {new Thing("a"), new Thing("b"), new Thing("c")};

    public static final List<Thing> VALUES2 = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    // 해결책 2. 배열을 private으로 만들고 그 복사본을 반환하는 public 메서드를 추가하는 방법이다.(방어적 복사)
    private static final Thing[] PRIVATE_VALUES2 = {new Thing("a"), new Thing("b"), new Thing("c")};

    public static final Thing[] values() {
        return PRIVATE_VALUES.clone();
    }
}
