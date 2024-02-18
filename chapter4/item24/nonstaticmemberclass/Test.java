package chapter4.item24.nonstaticmemberclass;

public class Test {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();

//        // 접근 불가능
//        System.out.println(new TestClass.PublicSample());
    }
}
