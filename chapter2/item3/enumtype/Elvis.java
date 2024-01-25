package chapter2.item3.enumtype;

// 코드 3-3 열거 타입 방식의 싱글턴 - 바람직한 방법
public enum Elvis {
    // public 필드 방식과 비슷하지만, 더 간결하고 추가 노력 없이 직렬화할 수 있다.
    // 심지어 아주 복잡한 직렬화 상황이나 리플렉션 공격에서도 제2의 인스턴스가 생기는 일을 완벽히 막아준다.
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("기다려 자기야, 지금 나갈께!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
