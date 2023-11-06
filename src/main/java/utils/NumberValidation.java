package utils;

public class NumberValidation {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final String OUT_OF_RANGE = "[ERROR] 1~45 사이의 값을 입력해야 합니다. ";

    public static void isOverMaxNumber(int number) {
        if (number > MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    public static void isUnderMinNumber(int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
}
