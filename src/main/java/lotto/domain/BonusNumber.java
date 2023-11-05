package lotto.domain;

public class BonusNumber {
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 1;

    Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (isOutOfRangeNumber(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRangeNumber(Integer number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }
}
