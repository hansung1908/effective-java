package chapter4.item24.staticmemberclass;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(new Animal.PublicSample());

//        // private 선언시 바깥 클래스에서만 접근 가능하다.
//        System.out.println(new Animal.PrivateSample());
    }
}
