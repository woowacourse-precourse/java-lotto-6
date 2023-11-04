package lotto.domain;

public class LottoNumber {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber from(int value) {
        return new LottoNumber(value);
    }

    private void validate(int value) {
        validateRange(value);
    }

    private void validateRange(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException();
        }
    }
}