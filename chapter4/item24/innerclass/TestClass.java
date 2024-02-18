package chapter4.item24.innerclass;

public class TestClass {
    private int number = 10;

    public TestClass() {
    }

    public void foo() {
        // 지역변수처럼 선언(지역 클래스)
        class LocalClass {
            private String name;
            // private static int staticNumber; // 정적 멤버 가질 수 없음

            public LocalClass(String name) {
                this.name = name;
            }

            public void print() {
                // 비정적 문맥에선 바깥 인스턴스를 참조 가능
                // foo()가 static이면 number에서 컴파일 에러
                System.out.println(number + name);
            }
        }
        LocalClass localClass1 = new LocalClass("local1"); // 이름이 있고
        LocalClass localClass2 = new LocalClass("local2"); // 반복해서 사용 가능
    }
}
