package chapter2.item3.staticfactory;

// 코드 3-2 정적 팩터리 방식의 싱글턴
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() { }

    // Elvis.getInstance는 항상 같은 객체의 참조를 반환하므로 제2의 Elvis 인스턴스는 결코 만들어지지 않는다.
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
        System.out.println("기다려 자기야, 지금 나갈께!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}
