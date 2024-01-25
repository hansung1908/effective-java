package chapter2.item7;

import java.util.*;

// 코드 7-1 메모리 누수가 일어나는 위치는 어디인가?
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 스택이 커졌다가 줄어들었을 때 스택에서 꺼내진 객체들을 가비지 컬렉터가 회수 하지 않는다.
    // 이 스택이 그 객체들의 다 쓴 참조를 여전히 가지고 있기 때문이다.
    // 여기서 다 쓴 참조란 문자 그대로 앞으로 다시 쓰지 않을 참조를 뜻한다.
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

//    // 코드 7-2 제대로 구현한 pop 메서드
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        elements[size] = null; // 다 쓴 참조 해제
//        return result;
//    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        for (int i = 0; i < 100; i++)
            stack.push(i);

        while (true)
            System.err.println(stack.pop());
    }
}
