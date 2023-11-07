package lotto.validation;

public interface Validator<TInput> {
    default boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    default boolean isPositive(int input) {
        return input > 0;
    }

    void validate(TInput input);
}
