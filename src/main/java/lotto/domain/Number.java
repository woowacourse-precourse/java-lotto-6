package lotto.domain;

public class Number {
    private static final String NUMBER_OUT_OF_RANGE = "[ERROR] 1에서 45사이의 숫자를 입력해주세요.";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number from(int number) {
        validateRange(number);
        return new Number(number);
    }

    private static void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }
    }

    public int getValue() {
        return number;
    }
}