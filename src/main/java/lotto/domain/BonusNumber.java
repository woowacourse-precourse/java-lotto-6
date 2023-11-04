package lotto.domain;

public class BonusNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private final int number;

    private BonusNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public static BonusNumber of(final int number) {
        return new BonusNumber(number);
    }

    private void validate(final int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int value() {
        return this.number;
    }
}
