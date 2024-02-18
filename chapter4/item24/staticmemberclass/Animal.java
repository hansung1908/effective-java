package chapter4.item24.staticmemberclass;

public class Animal {
    private String name = "cat";

    // 열거 타입도 암시적 static
    public enum Kinds {
        MAMMALS, BIRDS, FISH, REPTILES, INSECT
    }

    // 정적 멤버 클래스
    private static class PrivateSample {
        private int temp;

        public void method() {
            Animal outerClass = new Animal();
            System.out.println("private" + outerClass.name); // 바깥 클래스인 Animal의 private 멤버 접근
        }
    }

    public static class PublicSample {
        private int temp;

        public void method() {
            Animal outerClass = new Animal();
            System.out.println("public" + outerClass.name); // 바깥 클래스인 Animal의 private 멤버 접근
        }
    }
}
