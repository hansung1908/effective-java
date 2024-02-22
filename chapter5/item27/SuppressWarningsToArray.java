package chapter5.item27;

import java.util.ArrayList;
import java.util.Arrays;

// ArrayList의 일부분을 가져온 예시
// 코드 27-1 지역변수를 추가해 @SuppressWarnings의 범위를 좁힌다.
public class SuppressWarningsToArray {
    transient Object[] elementData; // non-private to simplify nested class access

    private int size;

//    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // 생성한 배열과 매개변수로 받은 배열의 타입이 모두 T[]로 같으므로
            // 올바른 형변환이다.
//            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
            @SuppressWarnings("unchecked") T[] result =
                    (T[]) Arrays.copyOf(elementData, size, a.getClass());
            return result;
        }
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }
}
