# effective-java
'effective java 3/e - 조슈아 블로크'를 읽고 정리하는 글

## 객체 생성과 파괴

  - ### 아이템 1. 생성자 대신 정적 팩터리 메서드를 고려하라
    - 정적 팩터리 메서드가 생성자보다 좋은 이유 5가지
    - 첫번째, 이름을 가질 수 있다.
    - 두번째, 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
    - 세번째, 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
    - 네번째, 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
    - 다섯 번째, 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

  - ### 아이템 2. 생성자에 매개변수가 많다면 빌더를 고려하라
    - 점층적 생성자 패턴도 쓸 수는 있지만, 매개변수 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.
    - 자바빈즈 패턴에서는 객체 하나를 만들려면 메서드를 여러개 호출해야 하고, 객체가 완전히 생성되기 전까지는 일관성이 무너진 상태에 놓이게 된다.
    - 빌더 패턴은 (파이썬과 스칼라에 있는) 명명된 선택적 매개변수를 흉내 낸 것이다.
    - 빌더 패턴은 계층적으로 설계된 클래스와 함께 쓰기에 좋다.

  - ### 아이템 3. private 생성자나 열거타입으로 싱글턴임을 보증하라
    - 클래스를 싱글턴으로 만들면 이를 사용하는 클라이언트를 테스트하기가 어려워질 수 있다.
    - 대부분 상황에서는 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이다.