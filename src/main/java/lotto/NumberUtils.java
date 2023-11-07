package lotto;

public class NumberUtils {

    public static boolean isNotInRange(int startInclusive, int endInclusive, int targetNumber) {
        return targetNumber < startInclusive || endInclusive < targetNumber;
    }
}
