package lotto.exception;

import java.util.List;


public class WinningCheck {
    private static final int size = 6;
    private static final int standCount = 5;
    private static final char standard = ',';
    public static boolean checkNumberLength(List<Integer> numbers) {
        if (numbers.size() != size) {
            return false;
        }
        return true;
    }

    public static boolean checkCommaCount(String winningNum) throws IllegalArgumentException {
        Long countComma = countStand(winningNum);
        if (countComma != standCount) {
            return false;
        }
        return true;
    }

    public static Long countStand(String input) {
        return input.chars().filter(c -> c == standard).count();
    }
}
