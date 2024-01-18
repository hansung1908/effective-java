package item1;

import java.util.EnumSet;

public class Foo {

    String name;
    String address;

    private static final Foo GOOD_NIGHT = new Foo();

    public Foo() {}

    public Foo(String name) {
        this.name = name;
    }

//    // 생성자는 같은 타입의 생성자를 하나만 만들 수 있다.
//    public Foo (String address) {
//        this.address = address;
//    }

    // 1. 이름을 가질 수 있다.
    public static Foo withName(String name) {
        return new Foo(name);
    }

    public static Foo withAddress(String address) {
        Foo foo = new Foo();
        foo.address = address;
        return foo;
    }

    public static Foo getFoo() {
        return GOOD_NIGHT;
    }

    public static Foo getFoo(boolean flag) {
        // 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
        return flag ? new Foo() : new BarFoo();
    }

    public static void main(String[] args) {
        Foo foo = new Foo("dlfma");

        // 2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
        Foo foo1 = Foo.withName("dlfma");

        Foo foo2 = Foo.getFoo();

        Foo foo3 = Foo.getFoo(false);
    }

    static class BarFoo extends Foo {
    }

    // 5. 정적 팩터리 메소드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
    public static void doSomething() {
        // TODO 청소를 한다.
        // TODO 애들이랑 놀아준다.
        // TODO 저녁 약속에 간다.
        gameAndSleep();
    }

    public static void doSomethingTomorrow() {
        // TODO 애들 데리고 수영장에 간다.
        // TODO 밥을 먹는다.
        gameAndSleep();
    }

    public static void gameAndSleep() {
        // TODO 게임을 한다.
        // TODO 잔다.
    }
}
