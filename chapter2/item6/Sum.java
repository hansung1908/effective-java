package chapter2.item6;

// 코드 6-3 끔찍이 느리다! 객체가 만들어지는 위치를 찾았는가?
public class Sum {
    private static long sum() {
        // sum 변수를 long이 아닌 Long으로 선언해서 불필요한 인스턴스가 약 2^31개나 더 만들어진 것이다.
        // 단순히 sum의 타입을 long으로만 바꿔주면 내 컴퓨터
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int numSets = 100;
        long x = 0;

        // 처음으로 관측된 기록 기준
        // 내 컴퓨터 기준 Long : 약 5.8초, long : 약 0.7 초
        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += sum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // VM이 최적화하지 못하게 막는 코드
        if (x == 42)
            System.out.println();
    }
}
