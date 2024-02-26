package chapter5.item28;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        // 코드 28-1 런타임에 실패한다.
        Object[] objectArray = new Long[1];
        objectArray[0] = "타입이 달라도 넣을 수 없다."; // ArrayStoreException을 던진다.

//        // 코드 28-2 컴파일되지 않는다!
//        List<Object> ol = new ArrayList<Long>(); // 호환되지 않는 타입이다.
//        ol.add("타입이 달라 넣을 수 없다.");

//        // 코드 28-3 제네릭 배열 생성을 허용하지 않는 이유 - 컴파일되지 않는다.
//        // (1)을 허용할 경우 아래 코드와 같이 List<String>만 넣겠다고 정의하였으나
//        // (2)~(4)의 과정을 거쳐 List<Integer>가 첫번째 원소에 들어가게 된다.
//        // 그러면 (5)에서 꺼내는 첫 원소는 컴파일러는 선언부를 보고 자동으로 String으로 형변환하는데,
//        // 이 원소는 Integer이므로 런타임에 ClassCastException이 발생한다.
//        // 그래서 이를 방지하기 위해 (1)에서 컴파일 오류를 낸다.
//        List<String>[] stringLists = new List<String>[1]; // (1)
//        List<Integer> intList = List.of(42); // (2)
//        Object[] objects = stringLists; // (3)
//        objects[0] = intList; // (4)
//        String s = StringLists[0].get(0); // (5)

        // 코드 28-4 Chooser - 제네릭을 시급히 적용해야 한다.

    }

}
