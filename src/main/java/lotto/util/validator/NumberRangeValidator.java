package lotto.util.validator;

public final class NumberRangeValidator {
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;

    private NumberRangeValidator() {
    }

    public static boolean isInvalidRange(Integer number) {
        return number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number;
    }
}
