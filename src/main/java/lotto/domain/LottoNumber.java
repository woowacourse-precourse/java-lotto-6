package lotto.domain;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(
                    LottoErrorMessages.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int number) {
        return number < LottoConfig.MIN_NUMBER.getValue()
                || number > LottoConfig.MAX_NUMBER.getValue();
    }

}
