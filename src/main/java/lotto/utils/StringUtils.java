package lotto.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isDigit(String s) {
        return s.chars()
                .allMatch(Character::isDigit);
    }
}
