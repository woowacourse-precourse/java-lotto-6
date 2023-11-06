package lotto.domain;

import java.util.Objects;

public class Number {

    private final int value;

    public Number(final int value) {
        this.value = value;
    }

    public static Number from(final String userInput) {
        int value = validateDigit(userInput);
        return new Number(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    private static int validateDigit(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력 가능합니다!");
        }
    }


}
