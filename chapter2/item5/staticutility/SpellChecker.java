package chapter2.item5.staticutility;

import chapter2.item5.Lexicon;
import java.util.List;

// 코드 5-1 정적 유틸리티를 잘못 사용한 예 - 유연한지 않고 테스트하기 어렵다.
public class SpellChecker {
    private final Lexicon dictionary = new Lexicon();

    private SpellChecker() {} // 객체 생성 방지

    public static boolean isValid(String word) {
        return true;
    }

    public static List<String> suggestions(String typo) {
        List<String> result = List.of(typo);
        return result;
    }
}
