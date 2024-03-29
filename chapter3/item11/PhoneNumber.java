package chapter3.item11;

import java.util.HashMap;
import java.util.Map;

// equals를 재정의하면 hashCode로 재정의해야 함을 보여준다.
public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

//    // 코드 11-1 최악의 (하지만 적법한) hashCode 구현 - 사용 금지!
//    // 모든 객체에게 똑같은 값만 내어주므로 모든 객체가 해시테이브의 버킷 하나에 담겨 마치 연결 리스트처럼 동작한다.
//    // 그 결과 평균 수행시간이 O(1)인 해시테이블이 O(n)으로 느려져서, 객체가 많아지면 도저히 쓸 수 없게 된다.
//    @Override public int hashCode() {
//        return 42;
//    }

    // hashCode 없이는 제대로 동작하지 않는다. 다음 셋 중 하나를 활성화하자.

//    // 코드 11-2 전형적인 hashCode 메서드
//    @Override public int hashCode() {
//    // 핵심 필드 3개를 모두 사용하여 해시코드를 저장하는 이유는 세 값의 충돌을 방지하고 해시 코드 값을 더 넓은 범위에 균등하게 배포하는 방식으로 최종 해시 코드에 기여하도록 하기 위함입니다.
//        int result = Short.hashCode(areaCode);
//        result = 31 * result + Short.hashCode(prefix);
//        result = 31 * result + Short.hashCode(lineNum);
//        return result;
//    }

//    // 코드 11-3 한 줄짜리 hashCode 메서드 - 성능이 살짝 아쉽다.
//    @Override public int hashCode() {
//        return Objects.hash(lineNum, prefix, areaCode);
//    }

    // 코드 11-4 해시코드를 지연 초기화하는 hashCode 메서드 - 스레드 안정성까지 고려해야 한다.
    private int hashCode; // 자동으로 0으로 초기화된다.

    @Override public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "제니");
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}
