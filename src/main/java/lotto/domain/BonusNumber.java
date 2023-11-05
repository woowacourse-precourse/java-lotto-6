package lotto.domain;

record BonusNumber(int value) {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    BonusNumber {
        validateRange(value);
    }

    private void validateRange(int value) {
        if (value < MIN_RANGE || value > MAX_RANGE) {
            throw new IllegalArgumentException();
        }
    }
}
