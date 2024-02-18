package chapter4.item22.constantutilityclass;

import static chapter4.item22.constantutilityclass.PhysicalConstants.AVOGADROS_NUMBER;

public class Test {
    double atmos(double mols) {
        return AVOGADROS_NUMBER * mols;
    }
    // PhysicalConstans를 빈번히 사용한다면 정적 임포트가 값어치를 한다.
}
