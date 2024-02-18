package chapter4.item24.anonymousclass;

public class Calculator {
    private int x;
    private int y;

    public Calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int plus() {
        // 익명 클래스
        Operator operator = new Operator() {
            private static final String COMMENT = "더하기"; // 상수
            // private static int num = 10; // 상수 외의 정적 멤버는 불가능

            @Override
            public int plus() {
                // Calculator.plus()가 static이면 x, y 참조 불가
                return x + y;
            }
        };
        return operator.plus();
    }
}
