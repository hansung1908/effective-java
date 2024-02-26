package chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//// 코드 28-4 Chooser - 제네릭을 시급히 적용해야 한다!
//public class Chooser {
//    private final Object[] choiceArray;
//
//    public Chooser(Collection choices) {
//        choiceArray = choices.toArray();
//    }
//
//    public Object choose() {
//        Random rnd = ThreadLocalRandom.current();
//        return choiceArray[rnd.nextInt(choiceArray.length)];
//    }
//}

//// 코드 28-5 Chooser를 제네릭으로 만들기 위한 첫 시도 - 컴파일되지 않는다.
//public class Chooser<T> {
//    private final T[] choiceArray;
//
//    public Chooser(Collection<T> choices) {
//        choiceArray = choices.toArray();
//   }
//
//   // choose 메서드는 그대로다.
//}

// 코드 28-6 리스트 기반 Chooser - 타입 안전성 확보!
public class Chooser<T> {
    private final List<T> choiceList;

    public Chooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

        Chooser<Integer> chooser = new Chooser<>(intList);

        for (int i = 0; i < 10; i++) {
            Number choice = chooser.choose();
            System.out.println(choice);
        }
    }
}
