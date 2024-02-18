package chapter4.item24.nonstaticmemberclass;

public class TestClass {
    private String name = "yeonlog";

    // (비정적) 멤버 클래스
    public class PublicSample {
        public void printName() {
            // 바깥 클래스의 private 멤버 가져오기
            System.out.println(name);
        }

        public void callTestClassMethod() {
            // 바깥 클래스의 메소드 호출하기
            TestClass.this.testMethod();
        }
    }

    public PublicSample createPublicSample() {
        return new PublicSample();
    }

    public void testMethod() {
        System.out.println("hello world");
    }
}
