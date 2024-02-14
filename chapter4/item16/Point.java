package chapter4.item16;

public class Point {
//    // 코드 16-1 이처럼 퇴보한 클래스는 public이어서는 안 된다!
//    public double x;
//    public double y;

    // 코드 16-2 접근자와 변경자(mutator) 메서드를 활용해 데이터를 캡슐화한다.
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
