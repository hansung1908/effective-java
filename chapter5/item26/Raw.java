package chapter5.item26;

import chapter5.item26.Coin;

import java.util.*;

public class Raw {
//    // 코드 26-1 컬렉션의 로 타입 - 따라 하지 말 것!
//    // stamp 인스턴스만 취급한다.
//    private static final Collection stamps = new ArrayList<>();

    // 코드 26-3 매개변수화된 컬렉션 타입 - 타입 안전성 확보!
    private static final Collection<Stamp> stamps = new ArrayList<>();

    public static void main(String[] args) {
//        // 실수로 동전을 넣는다.
//        // 코드 26-3으로 설정하면 컴파일 오류가 발생하며 잘못된 타입의 인스턴스를 넣는다고 정확히 알려준다.
//        stamps.add(new Coin()); // "unchecked call" 경고를 내뱉는다.

        // 코드 26-2 반복자의 로 타입 - 따라 하지 말 것!
        for(Iterator i = stamps.iterator(); i.hasNext(); ) {
            Stamp stamp = (Stamp) i.next(); // ClassCastException을 던진다.
            stamp.cancel();
        }

        // 코드 26-4 런타임에 실패한다. - unsafeAdd 메서드가 로 타입(List)을 사용
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // 컴파일러가 자동으로 형변환 코드를 넣어준다.
    }

    // 로 타입인 List를 매개변수화 타입인 List<Object>로 바꾸면 오류 메세지가 뜨면서 컴파일조차 되지 않는다.
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

//    // 코드 26-5 잘못된 예 - 모르는 타입의 원소도 받는 로 타입을 사용했다.
//    static int numElementsInCommon(Set s1, Set s2) {
//        int result = 0;
//        for(Object o1 : s1)
//            if(s2.contains(o1))
//                result++;
//        return result;
//    }

    // 코드 26-6 비한정적 와일드카드 타입을 사용하라. - 타입 안전하며 유연하다.
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;



        for(Object o1 : s1)
            if(s2.contains(o1))
                result++;


        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // 코드 26-7 로 타입을 써도 좋은 예 - instanceof 연산자
        // 예시를 위해 추가한 것이기에 필요없거나 추가 작성이 필요하다.
        if(obj instanceof Set) { // 로 타입
            Set<?> s = (Set<?>) obj; // 와일드카드 타입
        }

        return super.equals(obj);
    }
}
