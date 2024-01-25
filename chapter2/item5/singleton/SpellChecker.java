package chapter2.item5.singleton;

import chapter2.item5.Lexicon;
import java.util.List;

// 코드 5-2 싱글턴을 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
public class SpellChecker {
    private final Lexicon dictionary = new Lexicon();

    private SpellChecker() {}
    public static SpellChecker INSTANCE = new SpellChecker();

    public static boolean isValid(String word) {
        return true;
    }

    public static List<String> suggestions(String typo) {
        List<String> result = List.of(typo);
        return result;
    }
}
