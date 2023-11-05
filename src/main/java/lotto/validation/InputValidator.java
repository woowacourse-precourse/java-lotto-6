package lotto.validation;

public interface InputValidator {
    default boolean isInteger(String input) {
        return input.matches("\\d+");
    }

    boolean isDivisibleBy1000(int input);
}
