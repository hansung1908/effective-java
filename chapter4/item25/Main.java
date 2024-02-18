package chapter4.item25;

public class Main {
    // 컴파일러에 어느 소스 파일(Utensil.java or Dessert.java)을 먼저 건네느냐에 따라 동작이 달라지므로 반드시 바로 잡아야 할 문제다.
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }
}
