package lotto.validation;

public interface InputValidator {
    default boolean isInteger(String input) {
        return input.matches("\\d+");
    }

    default boolean isBiggerThan(int number, int n) {
        return number > n;
    }

    boolean isDivisibleBy1000(int input);
}
