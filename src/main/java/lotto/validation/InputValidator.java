package lotto.validation;

public interface InputValidator {
    default boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    default boolean isPositive(int input) {
        return input > 0;
    }
}
