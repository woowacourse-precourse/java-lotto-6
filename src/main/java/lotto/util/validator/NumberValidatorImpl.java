package lotto.util.validator;

public class NumberValidatorImpl implements NumberValidator {
    private static final int INCLUDE_START = 1;
    private static final int INCLUDE_END = 45;

    @Override
    public boolean isInRange(int target) {
        return target >= INCLUDE_START && target <= INCLUDE_END;
    }
}
